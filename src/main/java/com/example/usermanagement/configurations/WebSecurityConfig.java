//package com.example.usermanagement.configurations;
//
//import com.example.usermanagement.services.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import javax.sql.DataSource;
//
//TODO fix security
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig {
//
//    private final DataSource securityDataSource;
//
//    public WebSecurityConfig(DataSource securityDataSource) {
//        this.securityDataSource = securityDataSource;
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//
//        return new UserInfoDetailService();
//    }
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//
//
//        http
//                .csrf().disable()
//                .httpBasic()
//                .and()
//                .authorizeHttpRequests()
//                .requestMatchers(HttpMethod.GET, "/api").hasAnyRole("USER", "ADMIN")
//                .requestMatchers(HttpMethod.GET, "/api/**").hasAnyRole("USER", "ADMIN")
//                .requestMatchers(HttpMethod.PUT, "/api/**").hasAnyRole("USER", "ADMIN")
//                .requestMatchers(HttpMethod.POST, "/api/create").permitAll()
//                .and()
//                .formLogin().disable();
//
//        return http.build();
//
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(userDetailsService());
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//        return authenticationProvider;
//    }
//
//    @Bean
//    public UserDetailsManager userDetailsManager() {
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
//        jdbcUserDetailsManager.setDataSource(securityDataSource);
//        return jdbcUserDetailsManager;
//    }
//}
