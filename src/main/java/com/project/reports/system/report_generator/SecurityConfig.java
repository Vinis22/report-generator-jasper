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
                .csrf(csrf -> csrf.disable()) // Disable CSRF for REST endpoints
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/reports/**").permitAll() // Allows public access to API endpoints
                        .anyRequest().authenticated() // Require authentication for other routes
                );
        return http.build();
    }
}
