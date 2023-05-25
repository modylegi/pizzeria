package ru.itis.semesterwork.controllers;




import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;


@Controller
@RequiredArgsConstructor
public class AuthController {

    @GetMapping("/sign-up")
    public String getSignUpPage(){
        return "security/signUp";
    }

    @GetMapping("/sign-in")
    public String getSignInPage(){
        return "security/signIn";
    }

//    @GetMapping("/logout")
//    public ModelAndView logout(){
//        return new ModelAndView("redirect:/products" );
//    }

}
