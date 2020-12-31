package com.department.manager.config;

import com.department.manager.service.ManagerService;
import com.department.manager.web.handler.CustomAuthenticFailureHandler;
import com.department.manager.web.handler.CustomAuthenticSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author 夜神
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiger extends WebSecurityConfigurerAdapter {
    @Autowired
    private ManagerService managerService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

//invalidateHttpSession(true)   登出时使session无效化
//anyRequest().authenticated()  其他请求都要认证

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.headers().contentTypeOptions().disable();
        http.authorizeRequests()
                .antMatchers("/error").permitAll()
                .anyRequest().authenticated()//其他请求都要认证
                .and()
                .formLogin()
                .loginPage("/manager/login")
                .loginProcessingUrl("/login")
                .successHandler(new CustomAuthenticSuccessHandler())
                .failureHandler(new CustomAuthenticFailureHandler())
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/manager/login")
                .invalidateHttpSession(true)
                .permitAll()
                .and()
                .csrf()
                .disable();
        http.headers().contentTypeOptions().disable();
        // X-Content-Type-Options头设置允许加载静态资源
        http.headers().frameOptions().sameOrigin();
    }

    /**
     * security要求必须有Password实例
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//        使用BCryptPasswordEncoder编码器，它实现了PasswordEncoder接口
        auth.userDetailsService(this.managerService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //配置静态文件不需要认证
        web.ignoring().
                antMatchers("/assets/**")
                .antMatchers("/css/**")
                .antMatchers("/js/**")
                .antMatchers("/img/**");
    }
}
