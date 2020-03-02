package com.elv.catmvcthymeleaf.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration @EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth
            .inMemoryAuthentication()
            .withUser("admin")
            .password(passwordEncoder.encode("admin"))
            .roles("USER", "ADMIN")
            .and()
            .withUser("user")
            .password(passwordEncoder.encode("1234"))
            .roles("USER");


    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()
            .and()
            .authorizeRequests()
            .antMatchers("/user/*")
            .hasRole("USER")
            .and()
            .authorizeRequests()
            .antMatchers("/admin/*")
            .hasRole("ADMIN")
            .and()
            .exceptionHandling().accessDeniedPage("/403");

        http.csrf().disable();

    }
}
