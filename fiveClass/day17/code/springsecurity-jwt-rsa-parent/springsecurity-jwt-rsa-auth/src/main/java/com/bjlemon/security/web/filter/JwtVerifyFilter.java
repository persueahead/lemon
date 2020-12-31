package com.bjlemon.security.web.filter;

import com.bjlemon.security.config.RsaKeyConfig;
import com.bjlemon.security.domain.Payload;
import com.bjlemon.security.domain.User;
import com.bjlemon.security.util.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName JwtVerifyFilter.java
 * @Description TODO
 * @createTime 2020年02月20日 21:49:00
 */
public class JwtVerifyFilter extends BasicAuthenticationFilter {

    private RsaKeyConfig rsaKeyConfig;

    public JwtVerifyFilter(AuthenticationManager authenticationManager, RsaKeyConfig rsaKeyConfig) {
        super(authenticationManager);
        this.rsaKeyConfig = rsaKeyConfig;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer")) {
            // 没有认证通过的提示
        } else {
            // 校验
            String token = header.replace("Bearer ", "");
            Payload<User> payload = JwtUtils.getInfoFromToken(token, rsaKeyConfig.getPublicKey(), User.class);
            User user = payload.getUserInfo();
            if (user != null) {
                UsernamePasswordAuthenticationToken authenticateResult = new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword(), user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authenticateResult);
                chain.doFilter(request, response);
            }
        }

    }
}
