package com.bjlemon.security.web.filter;

import com.bjlemon.security.config.RsaKeyConfig;
import com.bjlemon.security.domain.Role;
import com.bjlemon.security.domain.User;
import com.bjlemon.security.service.RoleService;
import com.bjlemon.security.service.impl.RoleServiceImpl;
import com.bjlemon.security.util.JwtUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.*;

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

    @Autowired
    private RoleService roleService = new RoleServiceImpl();

    public TokenAuthenticateFilter(AuthenticationManager authenticationManager, RsaKeyConfig rsaKeyConfig) {
        this.authenticationManager = authenticationManager;
        this.rsaKeyConfig = rsaKeyConfig;
    }

    /**
     * @description 认证凭证
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

        // TODO 没实现
        /*List<Role> roleList = new ArrayList<>();
        for (GrantedAuthority authority : authorities) {
            String roleName = authority.getAuthority();
            Role role = this.roleService.findRoleByName(roleName);
            roleList.add(role);
        }*/

        // 以下代码是测试代码
        Role role1 = new Role();
        role1.setId(1);
        role1.setName("ROLE_ADMIN");
        role1.setDescription("ROLE_ADMIN");

        Role role2 = new Role();
        role2.setId(1);
        role2.setName("ROLE_USER");
        role2.setDescription("ROLE_USER");

        List<Role> roleList = new ArrayList<>();
        roleList.add(role1);
        roleList.add(role2);
        user.setRoles(roleList);

        // 生成token  user是载荷中的数据
        String token = JwtUtils.generateTokenExpireInMinutes(user, this.rsaKeyConfig.getPrivateKey(), 24 * 60);

        // 返回token  放在头部 cors（跨域资源共享）
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
