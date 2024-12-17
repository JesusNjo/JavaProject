package com.todevelop.todevelop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final String API_PUBLIC_PATH_PATTERN = "/public/**";
    private static final String OAUTH2_PATH_PATTERN = "/v1/oauth/tokens/**";

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


        return http
                .authorizeHttpRequests(auth ->{
                    auth.requestMatchers("/login").permitAll();
                    auth.requestMatchers("/logout").permitAll();
                    auth.requestMatchers(API_PUBLIC_PATH_PATTERN).permitAll();
                    auth.requestMatchers(OAUTH2_PATH_PATTERN).permitAll();
                    auth.anyRequest().authenticated();
                }).formLogin()
                .successHandler(authSuccessHandler()).permitAll()
                .and()
                .sessionManagement(sess->{
                    sess.sessionCreationPolicy(SessionCreationPolicy.ALWAYS).invalidSessionUrl("/login")
                            .maximumSessions(1).maxSessionsPreventsLogin(true)
                            .expiredUrl("/login")
                            .sessionRegistry(sessionRegistry())
                            .and()
                            .sessionFixation()
                            .migrateSession();
                })
                //.httpBasic().and()
                .build();
    }

    public AuthenticationSuccessHandler authSuccessHandler(){
        return ((request, response, auth) -> {
            response.sendRedirect("/public/index");
        });
    }

    @Bean
    public SessionRegistry sessionRegistry(){
        return new SessionRegistryImpl();
    }
}
