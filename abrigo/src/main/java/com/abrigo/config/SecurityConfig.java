package com.abrigo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/css/**", "/img/**", "/h2-console/**").permitAll()
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/abrigos", "/abrigos/**").fullyAuthenticated()
                        .anyRequest().fullyAuthenticated()
                )
                .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
                .headers(headers -> headers.frameOptions(frame -> frame.disable()))
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/oauth2/authorization/google")
                        .defaultSuccessUrl("/abrigos", true)
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/abrigos")
                        .permitAll()
                );

        return http.build();
    }
}
