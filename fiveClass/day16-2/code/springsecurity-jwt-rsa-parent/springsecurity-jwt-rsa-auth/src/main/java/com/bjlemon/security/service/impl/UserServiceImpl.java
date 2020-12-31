package com.bjlemon.security.service.impl;

import com.bjlemon.security.domain.Role;
import com.bjlemon.security.domain.User;
import com.bjlemon.security.mapper.UserMapper;
import com.bjlemon.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName UserServiceImpl.java
 * @Description TODO
 * @createTime 2020年02月20日 21:06:00
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();

        User user = this.userMapper.findByName(username);
        String name = user.getName();
        String password = user.getPassword();
        List<Role> roleList = user.getRoles();

        for (Role role : roleList) {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role.getName());
            simpleGrantedAuthorities.add(simpleGrantedAuthority);
        }

        return new org.springframework.security.core.userdetails.User(name, password, simpleGrantedAuthorities);
    }
}
