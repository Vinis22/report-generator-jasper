package com.project.reports.system.report_generator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desativa CSRF para endpoints REST
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/reports/**").permitAll() // Permite acesso público aos endpoints da API
                        .anyRequest().authenticated() // Exige autenticação para outras rotas
                );
        return http.build();
    }
}
