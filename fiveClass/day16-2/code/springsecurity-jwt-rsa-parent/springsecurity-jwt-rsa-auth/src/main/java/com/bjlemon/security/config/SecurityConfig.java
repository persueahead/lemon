package com.bjlemon.security.config;

import com.bjlemon.security.encoder.CustomPasswordEncoder;
import com.bjlemon.security.service.UserService;
import com.bjlemon.security.web.filter.TokenAuthenticateFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName SecurityConfig.java
 * @Description TODO
 * @createTime 2020年02月18日 20:45:00
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Autowired
    private RsaKeyConfig rsaKeyConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated()
                .and()
                .addFilter(new TokenAuthenticateFilter(this.authenticationManager(), this.rsaKeyConfig))
//                .addFilter(new JwtVerifyFilter(this.authenticationManager(), this.rsaKeyConfig))
                .cors()
                .and()
                .csrf()
                .disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userService).passwordEncoder(new CustomPasswordEncoder());
    }
}
