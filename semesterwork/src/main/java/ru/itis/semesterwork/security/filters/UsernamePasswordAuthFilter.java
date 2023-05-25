//package ru.itis.semesterwork.security.filters;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.RequiredArgsConstructor;
//import org.jetbrains.annotations.NotNull;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//import ru.itis.semesterwork.entities.AuthenticateRequest;
//import ru.itis.semesterwork.security.details.CustomUserDetails;
//import ru.itis.semesterwork.security.details.UserDetailsServiceImpl;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//@RequiredArgsConstructor
//public class UsernamePasswordAuthFilter extends OncePerRequestFilter {
//    private static final ObjectMapper MAPPER = new ObjectMapper();
//
//
//    @Override
//    protected void doFilterInternal(
//            @NotNull HttpServletRequest httpServletRequest,
//            @NotNull HttpServletResponse httpServletResponse,
//            @NotNull FilterChain filterChain) throws ServletException, IOException {
//
//        if ("/api/v1/auth/sign-in".equals(httpServletRequest.getServletPath()) && HttpMethod.POST.matches(httpServletRequest.getMethod())) {
//            AuthenticateRequest authenticateRequest = MAPPER.readValue(httpServletRequest.getInputStream(), AuthenticateRequest.class);
//            SecurityContextHolder.getContext().setAuthentication(
//                    new UsernamePasswordAuthenticationToken(authenticateRequest.getEmail(), authenticateRequest.getPassword()));
//        }
//
//        filterChain.doFilter(httpServletRequest, httpServletResponse);
//    }
//}
