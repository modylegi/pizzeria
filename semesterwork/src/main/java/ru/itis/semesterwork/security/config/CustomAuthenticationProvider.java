//package ru.itis.semesterwork.security.config;
//
//import lombok.RequiredArgsConstructor;
//
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
//import org.springframework.stereotype.Component;
//import ru.itis.semesterwork.entities.AuthenticateRequest;
//import ru.itis.semesterwork.security.details.CustomUserDetails;
//import ru.itis.semesterwork.security.services.AuthService;
//
//
//
//@Component
//@RequiredArgsConstructor
//public class CustomAuthenticationProvider implements AuthenticationProvider {
//    private final AuthService authService;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//
//
//
//        CustomUserDetails user = null;
//
//        if (authentication instanceof UsernamePasswordAuthenticationToken) {
//            user = authService.authenticate(new AuthenticateRequest((String) authentication.getPrincipal(), (char[]) authentication.getCredentials()));
//        } else if (authentication instanceof PreAuthenticatedAuthenticationToken) {
//            user = authService.findByToken((String) authentication.getPrincipal());
//        }
//
//        assert user != null;
//        return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
//    }
//
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return true;
//    }
//}
