package ru.boldyrev.weblibrarysb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        final String AUTH_PAGE = "/auth/login";
        http.authorizeHttpRequests(
                request -> request.requestMatchers("/admin/**").hasRole("ADMIN")
                    .requestMatchers(AUTH_PAGE, "/error").permitAll()
                    .anyRequest().hasAnyRole("ADMIN", "WORKER"))
            .formLogin(
                form -> form.loginPage(AUTH_PAGE).defaultSuccessUrl("/books", true)
                    .failureUrl("/auth/login?error").loginProcessingUrl("/process_login"))
            .logout(
                logout -> logout.logoutUrl("/logout").logoutSuccessUrl(AUTH_PAGE));
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
