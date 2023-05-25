package ru.itis.semesterwork.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

public interface LogoutService extends LogoutHandler {
    @Override
    void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication);
}
