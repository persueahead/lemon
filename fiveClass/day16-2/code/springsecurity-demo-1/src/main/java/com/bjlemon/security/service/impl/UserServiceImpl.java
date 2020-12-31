package com.bjlemon.security.service.impl;

import com.bjlemon.security.dao.UserRepository;
import com.bjlemon.security.domain.User;
import com.bjlemon.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService {

   /* @Autowired
    private UserRepository userRepository;*/

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = null;
        GrantedAuthority grantedAuthority1 = null;
        GrantedAuthority grantedAuthority2 = null;
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();

        /*// 根据用户名查询该用户
        User user = this.userRepository.findUserByName(username);
        if (user == null) {
            return null;
        }*/

        User user = new User();
        user.setId(1000);
        user.setName("zhangsan");
        user.setPassword("admin");
        user.setSalary(12.34F);
        user.setBirthday(new Date());


        grantedAuthority1 = new SimpleGrantedAuthority("ROLE_ADMIN");
        grantedAuthority2 = new SimpleGrantedAuthority("ROLE_USER");
        grantedAuthorityList.add(grantedAuthority1);
        grantedAuthorityList.add(grantedAuthority2);

        userDetails = new org.springframework.security.core.userdetails.User(
                user.getName(),
                "{noop}" + user.getPassword(),
                grantedAuthorityList
        );

        return userDetails;
    }
}