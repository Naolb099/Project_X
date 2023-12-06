//package com.projectX_F23.ProjectX.Project_X.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.security.web.util.matcher.MvcRequestMatcher;
//import org.springframework.web.servlet.handler.HandlerMappingIntrospector;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
//        http
//                .authorizeRequests(authz -> authz
//                        .requestMatchers(new MvcRequestMatcher(introspector, "/login")).permitAll()
//                        .requestMatchers(new MvcRequestMatcher(introspector, "/signup")).permitAll()
//                        .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
//                        .anyRequest().authenticated()
//                )
//                .formLogin(form -> form
//                        .loginPage("/login")
//                        .defaultSuccessUrl("/home", true)
//                )
//                .logout(logout -> logout.permitAll());
//
//        // Additional configuration for H2 console
//        http.csrf().ignoringAntMatchers("/h2-console/**");
//        http.headers().frameOptions().sameOrigin();
//
//        return http.build();
//    }
//
//}
