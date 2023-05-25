package ru.itis.semesterwork.security.services;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
import ru.itis.semesterwork.dto.UserDto;
import ru.itis.semesterwork.entities.AuthResponse;
import ru.itis.semesterwork.entities.AuthenticateRequest;
import ru.itis.semesterwork.entities.RegisterRequest;
import ru.itis.semesterwork.entities.User;
import ru.itis.semesterwork.security.details.CustomUserDetails;

import javax.servlet.http.Cookie;


public interface AuthService {
    UserDto register(RegisterRequest registerRequest);

    Cookie authenticate(AuthenticateRequest authenticateRequest);




}
