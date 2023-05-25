package ru.itis.semesterwork.services.impl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.itis.semesterwork.security.token.Token;
import ru.itis.semesterwork.security.token.TokenRepository;
import ru.itis.semesterwork.services.LogoutService;

import java.io.IOException;
import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class LogoutServiceImpl implements LogoutService {
    private final TokenRepository tokenRepository;

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        Token token = null;
        for (Cookie c : request.getCookies()) {
            if (c.getName().equals("auth_by_cookie"))
                token = tokenRepository.findByToken(c.getValue()).orElseThrow();
                if(token != null) {
                    token.setRevoked(true);
                    token.setExpired(true);
                    tokenRepository.save(token);


                }
        }
    }
}

