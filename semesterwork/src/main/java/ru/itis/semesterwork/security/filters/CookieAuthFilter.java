package ru.itis.semesterwork.security.filters;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.itis.semesterwork.entities.User;
import ru.itis.semesterwork.repositories.UserRepository;
import ru.itis.semesterwork.security.details.CustomUserDetails;
import ru.itis.semesterwork.security.details.CustomUserDetailsService;

import ru.itis.semesterwork.security.token.Token;
import ru.itis.semesterwork.security.token.TokenRepository;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;


@Component
@RequiredArgsConstructor
@Slf4j
public class CookieAuthFilter extends OncePerRequestFilter {
    private final TokenRepository tokenRepository;
    private final CustomUserDetailsService customUserDetailsService;
    private final UserRepository userRepository;
    public static final String COOKIE_NAME = "dodo-pizza";

    @Override
    protected void doFilterInternal(
            @NotNull HttpServletRequest httpServletRequest,
            @NotNull HttpServletResponse httpServletResponse,
            @NotNull FilterChain filterChain) throws ServletException, IOException {

        Optional<Cookie> cookieAuth = Stream.of(Optional.ofNullable(httpServletRequest.getCookies()).orElse(new Cookie[0]))
                .filter(cookie -> COOKIE_NAME.equals(cookie.getName()))
                .findFirst();
        if (httpServletRequest.getServletPath().contains("/api/v1/auth")) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }
        if (cookieAuth.isEmpty()) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }
        if (cookieAuth.isPresent()) {
            Token token = tokenRepository.findByToken(cookieAuth.get().getValue()).orElseThrow();

            User user = token.getUser();

            if(user.getEmail() != null && SecurityContextHolder.getContext().getAuthentication() == null){
                CustomUserDetails customUserDetails = customUserDetailsService.loadUserByUsername(user.getEmail());
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        customUserDetails, null,
                        customUserDetails.getAuthorities()
                );
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
//        tokenRepository.findByToken(cookieAuth.get().getName());
//        Token token = Token.builder()
//                        .
//                build();
//        User user = userRepository.findUserByTokens(Tok)
//
//
//        cookieAuth.ifPresent(cookie -> SecurityContextHolder.getContext().setAuthentication(
//                new PreAuthenticatedAuthenticationToken(cookie.getValue(), null)));
        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }
}
