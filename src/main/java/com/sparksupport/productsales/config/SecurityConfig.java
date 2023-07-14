package com.sparksupport.productsales.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@SuppressWarnings("removal")
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailService() {
        UserDetails admin = User.withUsername("Admin").password("{noop}Admin123").roles("ADMIN").build();
        UserDetails user = User.withUsername("User").password("{noop}User123").roles("USER").build();
        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> {
            auth.requestMatchers("*/products","*/product/{id}")
                    .permitAll().requestMatchers("*/add","*/delete/{id}","*/update/{id}").authenticated();
        } );
         http.httpBasic();
         http.csrf().disable();
         http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
         return http.build();
    }

}
