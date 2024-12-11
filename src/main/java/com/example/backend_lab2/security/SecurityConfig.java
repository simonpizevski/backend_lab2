package com.example.backend_lab2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(GET, "/api/categories/**").permitAll()
                        .requestMatchers(POST, "/api/categories/**").hasAuthority("SCOPE_ADMIN")

                        .requestMatchers(GET, "/api/locations/public/**").permitAll()
                        .requestMatchers(GET, "/api/locations/public/category/**").permitAll()
                        .requestMatchers(GET, "/api/locations/radius").permitAll()
                        .requestMatchers(GET, "/api/locations/user/**").authenticated()
                        .requestMatchers(POST, "/api/locations/**").authenticated()
                        .requestMatchers(PUT, "/api/locations/**").authenticated()
                        .requestMatchers(DELETE, "/api/locations/**").authenticated()

                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));
        return http.build();
    }
}