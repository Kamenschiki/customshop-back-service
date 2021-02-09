package com.customshop.back.config;

import com.customshop.back.auth.security.jwt.JwtConfigurer;
import com.customshop.back.auth.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;
    private final String ADMIN_ENDPOINTS = "/customshop/v1/admin/**";
    private final String USER_ENDPOINTS = "/customshop/v1/user/**";
    private final String LOGIN_ENDPOINT = "/customshop/v1/auth/login";

    @Autowired
    public SecurityConfig(JwtTokenProvider jwtTokenProvider
    ) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    // TODO: update privacy policies
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .httpBasic().disable()
                .csrf().disable() // should be enabled later
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // not creating session for each user
                .and()
                .authorizeRequests()
                .antMatchers(LOGIN_ENDPOINT).permitAll() // urls
                .antMatchers(ADMIN_ENDPOINTS).hasRole("ADMIN")
                .antMatchers(USER_ENDPOINTS).hasRole("USER")
                .and()
                .apply(new JwtConfigurer(jwtTokenProvider));
    }

}
