//package ru.itis.semesterwork.controllers;
//
//
//
//
//import lombok.RequiredArgsConstructor;
//
//import org.springframework.stereotype.Controller;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.util.UriComponentsBuilder;
//import ru.itis.semesterwork.entities.AuthenticateRequest;
//import ru.itis.semesterwork.entities.RegisterRequest;
//import ru.itis.semesterwork.security.services.AuthService;
//
//import javax.servlet.http.HttpServletResponse;
//
//
//@Controller
//@RequiredArgsConstructor
//public class AuthController {
//    private final AuthService authService;
//
//    @GetMapping("/sign-up")
//    public String getSignUpPage(){
//        return "security/signUp";
//    }
//
//    @GetMapping("/sign-in")
//    public String getSignInPage(){
//        return "security/signIn";
//    }
//
//    @PostMapping("/auth/sign-in")
//    public String signIn(AuthenticateRequest authenticateRequest, HttpServletResponse servletResponse){
//        servletResponse.addCookie(authService.authenticate(authenticateRequest));
//        return "redirect:/products" ;
//
//    }
//
//    @PostMapping("/auth/sign-up")
//    public String signUp(RegisterRequest registerRequest){
//        authService.register(registerRequest);
//        return "redirect:/sign-in";
//    }
//
//
//    @GetMapping("/auth/sign-out")
//    public String signOut(){
//
//        return "redirect:/products";
//    }
//
//}
