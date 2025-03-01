package com.example.canteen.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean(name = "customHttpFirewall")
    public HttpFirewall customHttpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowUrlEncodedSlash(true); // Configure as needed
        return firewall;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/users/**").permitAll() 
                .requestMatchers("/admins/register/**").permitAll() 
                .requestMatchers("/users/**").hasAnyRole("USER", "ADMIN") 
                .requestMatchers("/fooditems/**").permitAll() 
                .requestMatchers("/orders/**").hasAnyRole("USER", "ADMIN") 
                .anyRequest().authenticated() // Secure all other endpoints
            )
            .csrf(csrf -> csrf
                .disable()); 

        return http.build();
    }
}
