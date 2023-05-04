package com.herbalife.mysecuredapp.config;

import com.herbalife.mysecuredapp.security.DatabaseAuthenticationProvider;
import com.herbalife.mysecuredapp.security.JwtAuthenticationFilter;
import com.herbalife.mysecuredapp.security.JwtAuthorizationFilter;
import com.herbalife.mysecuredapp.security.MyCustomAuthenticationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Autowired
    private DatabaseAuthenticationProvider databaseAuthenticationProvider;

    @Autowired
    private MyCustomAuthenticationManager myCustomAuthenticationManager;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(auth -> auth
                        .antMatchers("/api/services/user/login").permitAll()
                        .anyRequest().authenticated());
        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(myCustomAuthenticationManager);
        JwtAuthorizationFilter jwtAuthorizationFilter = new JwtAuthorizationFilter(myCustomAuthenticationManager);
        http.addFilter(jwtAuthenticationFilter);
        http.addFilter(jwtAuthorizationFilter);
        return http.build();
    }

    //Uncomment this for formlogin
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests(auth -> auth
//                        .antMatchers("/home/**")
//                        .authenticated())
//                .formLogin();
//        http.authenticationProvider(databaseAuthenticationProvider);
//        http
//                .authorizeRequests((authz) -> authz
//                        .anyRequest().permitAll()
//                );
//        return http.build();
//    }

    //@Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails user = User
                .builder()
                .username("user")
                .password("{noop}password")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
}
