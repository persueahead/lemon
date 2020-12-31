package com.bjlemon.security.config;

import com.bjlemon.security.web.filter.JwtVerifyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

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

    /*@Autowired
    private UserService userService;*/

    @Autowired
    private RsaKeyConfig rsaKeyConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .csrf()
                .disable()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .addFilter(new JwtVerifyFilter(this.authenticationManager(), this.rsaKeyConfig))
                // 前后台分离是无状态，不用Session，禁用
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userService);
    }*/
}
