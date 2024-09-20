package com.example.creatshop.security;
/*
 * @author HongAnh
 * @created 20 / 09 / 2024 - 6:58 PM
 * @project CreaTShop-server
 * @social Github: https://github.com/lehonganh0201
 * @social Facebook: https://www.facebook.com/profile.php?id=100047152174225
 */

import com.example.creatshop.constant.ErrorMessage;
import com.example.creatshop.constant.Status;
import com.example.creatshop.domain.dto.global.GlobalResponse;
import com.example.creatshop.domain.dto.global.Meta;
import com.example.creatshop.security.jwt.AuthTokenFilter;
import com.example.creatshop.security.jwt.JwtAuthEntryPoint;
import com.example.creatshop.util.MessageSourceUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Configuration
@EnableMethodSecurity(jsr250Enabled = true, securedEnabled = true)
public class WebSecurityConfig {

    @NonFinal
    String CATCH_ALL_WILDCARD = "/**";

    JwtAuthEntryPoint      authEntryPoint;
    AuthTokenFilter        authTokenFilter;
    AuthenticationProvider authenticationProvider;
    ObjectMapper           objectMapper;
    MessageSourceUtil      messageSourceUtil;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .exceptionHandling(exception -> {
                exception.authenticationEntryPoint(authEntryPoint)
                         .accessDeniedHandler(((request, response, accessDeniedException) -> {
                             response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                             response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                             GlobalResponse<Meta, Void> responseBody = GlobalResponse.<Meta, Void>builder()
                                                                                     .meta(Meta.builder()
                                                                                               .status(Status.ERROR)
                                                                                               .message(messageSourceUtil.getLocalizedMessage(ErrorMessage.Auth.ERR_FORBIDDEN))
                                                                                               .build()
                                                                                     )
                                                                                     .build();
                             objectMapper.writeValue(response.getOutputStream(), responseBody);
                         }));
            })
            .authorizeHttpRequests(auth ->
                    auth.anyRequest().permitAll()
            )
            .authenticationProvider(authenticationProvider);

        http.exceptionHandling().authenticationEntryPoint(authEntryPoint);
        http.addFilterBefore(authTokenFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}