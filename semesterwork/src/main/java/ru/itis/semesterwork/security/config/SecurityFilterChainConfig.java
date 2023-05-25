package ru.itis.semesterwork.security.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import ru.itis.semesterwork.security.filters.CookieAuthFilter;
//import ru.itis.semesterwork.security.filters.EncodingFilter;
//import ru.itis.semesterwork.security.filters.UsernamePasswordAuthFilter;
import ru.itis.semesterwork.services.LogoutService;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityFilterChainConfig {


    private final LogoutService logoutService;

//    private final CustomAuthenticationProvider customAuthenticationProvider;
    private final CookieAuthFilter cookieAuthFilter;
//    private final UsernamePasswordAuthFilter usernamePasswordAuthFilter;
    private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
//    private final EncodingFilter encodingFilter;
    private final AuthenticationProvider authenticationProvider;



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers(
                        "/products",
                        "/sign-in",
                        "/sign-up",
                        "/api/v1/auth/sign-in",
                        "/api/v1/auth/sign-up",
                        "/add-to-cart/{id}",
                        "/remove-from-cart/{id}",
                        "/create-order",
                        "/cart",
                        "/logout"
                )
                .permitAll()
                .antMatchers("/management/**").hasAuthority("ADMIN")
                .antMatchers("/create-order", "/cart").hasAuthority("USER")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/sign-in")
                .defaultSuccessUrl("/products")
                .failureUrl("/auth/sign-in?error")
//                .usernameParameter("email")
//                .passwordParameter("password")
//                .permitAll()
//                .and()
//                .rememberMe().tokenRepository(persistentTokenRepository())

                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .exceptionHandling().authenticationEntryPoint(customAuthenticationEntryPoint)
                .and()
//                .authenticationProvider(authenticationProvider)
//                .addFilterBefore(encodingFilter, ChannelProcessingFilter.class)
//                .addFilterBefore(usernamePasswordAuthFilter, BasicAuthenticationFilter.class)
                .addFilterBefore(cookieAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout().deleteCookies(cookieAuthFilter.COOKIE_NAME)
                .logoutUrl("/logout")
                .addLogoutHandler(logoutService)
                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())

                ;
        return httpSecurity.build();

    }






}


