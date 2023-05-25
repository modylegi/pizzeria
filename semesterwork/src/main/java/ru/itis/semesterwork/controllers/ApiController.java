package ru.itis.semesterwork.controllers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ru.itis.semesterwork.dto.UserDto;
import ru.itis.semesterwork.entities.AuthenticateRequest;
import ru.itis.semesterwork.entities.RegisterRequest;
import ru.itis.semesterwork.mappers.UserMapper;
import ru.itis.semesterwork.repositories.UserRepository;
import ru.itis.semesterwork.security.filters.CookieAuthFilter;
import ru.itis.semesterwork.security.services.AuthService;
import ru.itis.semesterwork.security.token.TokenRepository;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Slf4j
public class ApiController {

    private final AuthService authService;


    @PostMapping("/auth/sign-in")
    public ModelAndView signIn(AuthenticateRequest authenticateRequest, HttpServletResponse servletResponse){
        servletResponse.addCookie(authService.authenticate(authenticateRequest));

        return new ModelAndView("redirect:/products" );

    }

    @PostMapping("/auth/sign-up")
    public String signUp(RegisterRequest registerRequest){
        authService.register(registerRequest);
        return "redirect:/sign-in";
    }
}
