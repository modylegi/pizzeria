package ru.itis.semesterwork.security.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.semesterwork.dto.UserDto;
import ru.itis.semesterwork.entities.*;
import ru.itis.semesterwork.repositories.UserRepository;


import ru.itis.semesterwork.security.details.CustomUserDetailsService;
//import ru.itis.semesterwork.security.details.UserDetailsServiceImpl;
import ru.itis.semesterwork.security.filters.CookieAuthFilter;
import ru.itis.semesterwork.security.token.Token;
import ru.itis.semesterwork.security.token.TokenRepository;
import ru.itis.semesterwork.security.token.TokenType;
import ru.itis.semesterwork.security.services.AuthService;
import ru.itis.semesterwork.validators.EmailValidator;



import javax.servlet.http.Cookie;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailValidator emailValidator;
    private final CustomUserDetailsService customUserDetailsService;
    private final AuthenticationManager authenticationManager;


//    private final AuthenticationManager authenticationManager;

//    @Value("${application.security.jwt.access-token.secret-key}")
//    private String secretKey;



    @Override
    public UserDto register(RegisterRequest registerRequest) {
        boolean isValidEmail = emailValidator.test(registerRequest.getEmail());
        if(!isValidEmail){
            throw new IllegalStateException("email not valid");
        }
        Optional<User> userOptional = userRepository.findUserByEmail(registerRequest.getEmail());
        if(userOptional.isPresent()){
            throw new IllegalStateException("email is already taken");
        }
        String encodedPassword = passwordEncoder.encode(registerRequest.getPassword());
        User registeredUser = new User(
                registerRequest.getFirstName(),
                registerRequest.getLastName(),
                registerRequest.getEmail(),
                registerRequest.getAge(),
                encodedPassword,
                UserRole.USER
        );
        User savedUser = userRepository.save(registeredUser);



        log.info("Пользователь: {} зарегистрировался на сайте.", savedUser.getEmail());


        return UserDto.from(savedUser);

    }


    @Override
    public Cookie authenticate(AuthenticateRequest authenticateRequest) {
        User user = userRepository.findUserByEmail(authenticateRequest.getEmail()).orElseThrow();

        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticateRequest.getEmail(),
                        authenticateRequest.getPassword()
                )
        );

        String token = createToken();
        System.out.println(auth.isAuthenticated());
        saveToken(user, token);
        Cookie authCookie = new Cookie(CookieAuthFilter.COOKIE_NAME, token);
        authCookie.setHttpOnly(true);
        authCookie.setSecure(true);
        authCookie.setMaxAge((int) Duration.of(1, ChronoUnit.DAYS).toSeconds());
        authCookie.setPath("/");
        return authCookie;

    }


    public String createToken() {
        return UUID.randomUUID().toString();
    }

    public void saveToken(User user, String generatedToken) {
        Token token = Token.builder()
                .type(TokenType.BEARER)
                .user(user)
                .token(generatedToken)
//                .revoked(false)
//                .expired(false)
                .build();
        tokenRepository.save(token);
    }


}
