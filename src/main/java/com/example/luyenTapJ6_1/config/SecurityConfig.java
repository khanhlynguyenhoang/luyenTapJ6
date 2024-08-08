package com.example.luyenTapJ6_1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        PasswordEncoder encoder = passwordEncoder();
        UserDetails nhanVien = User.builder()
                .username("HangNT169")
                .password(encoder.encode("123@123"))
                .roles("NHANVIEN")
                .build();
        return new InMemoryUserDetailsManager(nhanVien);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/hien-thi").hasRole("NHANVIEN") // Cần vai trò NHANVIEN
                        .anyRequest().permitAll() // Tất cả các yêu cầu khác đều được phép
                )
                .csrf().disable(); // Bắt buộc cần nếu không sẽ lỗi khi dùng update

        return httpSecurity.build();
    }

}
