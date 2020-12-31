package com.bjlemon.security.web.filter;

import com.bjlemon.security.config.RsaKeyConfig;
import com.bjlemon.security.domain.Role;
import com.bjlemon.security.domain.User;
import com.bjlemon.security.util.JwtUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName TokenAuthenticateFilter.java
 * @Description TODO
 * @createTime 2020年02月20日 21:24:00
 */
public class TokenAuthenticateFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    private RsaKeyConfig rsaKeyConfig;

    public TokenAuthenticateFilter(AuthenticationManager authenticationManager, RsaKeyConfig rsaKeyConfig) {
        this.authenticationManager = authenticationManager;
        this.rsaKeyConfig = rsaKeyConfig;
    }

    /**
     * @description
     * @author admin
     * @updateTime 2020/2/20 21:25
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = null;
        try {
            ServletInputStream inputStream = request.getInputStream();

            User user = new ObjectMapper().readValue(inputStream, User.class);
            String name = user.getName();
            String password = user.getPassword();
            usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(name, password);
        } catch (Exception e) {
            try {
                response.setContentType("application/json;charset=UTF-8");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                PrintWriter writer = response.getWriter();
                Map<String, Object> map = new HashMap<>();
                map.put("code", HttpServletResponse.SC_UNAUTHORIZED);
                map.put("message", "账户或密码错误");
                writer.write(new ObjectMapper().writeValueAsString(map));
                writer.flush();
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
    }

    /**
     * @description 认证成功后生成token
     * @author admin
     * @updateTime 2020/2/20 21:34
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException, ServletException {
        User user = new User();
        String name = authResult.getName();
        Collection<? extends GrantedAuthority> authorities = authResult.getAuthorities();

        user.setName(name);
        user.setRoles((List<Role>) authorities);

        // 生成token
        String token = JwtUtils.generateTokenExpireInMinutes(user, this.rsaKeyConfig.getPrivateKey(), 24 * 60);

        // 返回token
        response.addHeader("Authorization", "Bearer " + token);

        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);
        PrintWriter writer = response.getWriter();
        Map<String, Object> map = new HashMap<>();
        map.put("code", HttpServletResponse.SC_OK);
        map.put("message", "认证成功");
        writer.write(new ObjectMapper().writeValueAsString(map));
        writer.flush();
        writer.close();
    }
}
