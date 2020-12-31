package com.bjlemon.security.web.filter;

import com.bjlemon.security.config.RsaKeyConfig;
import com.bjlemon.security.domain.Payload;
import com.bjlemon.security.domain.Role;
import com.bjlemon.security.domain.User;
import com.bjlemon.security.util.JwtUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

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
        Collection<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer")) {
            // 没有认证通过的提示
            // 没有Token,提示用户重新认证
            try {
                response.setContentType("application/json;charset=UTF-8");
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                PrintWriter writer = response.getWriter();
                Map<String, Object> map = new HashMap<>();
                map.put("code", HttpServletResponse.SC_FORBIDDEN);
                map.put("message", " 没有Token,请重新认证");
                writer.write(new ObjectMapper().writeValueAsString(map));
                writer.flush();
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            // 校验
            //去掉Bearer 得到Token
            String token = header.replace("Bearer ", "");
            //通过公钥获取载荷
            Payload<User> payload = JwtUtils.getInfoFromToken(token, rsaKeyConfig.getPublicKey(), User.class);
            //得到载荷的信息
            User user = payload.getUserInfo();
            if (user != null) {
                //得到RoleList
                List<Role> roleList = user.getRoles();

                for (Role role : roleList) {
                    SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role.getName());
                    simpleGrantedAuthorities.add(simpleGrantedAuthority);
                }


                UsernamePasswordAuthenticationToken authenticateResult = new UsernamePasswordAuthenticationToken(
                        user.getName(),
                        user.getPassword(), simpleGrantedAuthorities);
                SecurityContextHolder.getContext().setAuthentication(authenticateResult);
                chain.doFilter(request, response);
            }
        }

    }
}
