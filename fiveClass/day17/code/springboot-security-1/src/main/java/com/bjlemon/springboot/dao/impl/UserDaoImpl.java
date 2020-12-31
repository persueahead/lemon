package com.bjlemon.springboot.dao.impl;

import com.bjlemon.springboot.dao.UserDao;
import com.bjlemon.springboot.domain.Role;
import com.bjlemon.springboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName UserDaoImpl.java
 * @Description TODO
 * @createTime 2020年02月11日 22:22:00
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findByName(String name) {
        User user = null;
        if ("zhangsan".equals(name)) {
            user = new User();
            user.setId(1);
            user.setName(name);
            String password = bCryptPasswordEncoder.encode("admin");
            user.setPassword(password);
            user.setSalary(12.34F);
            user.setBirthday(new Date());

            Set<Role> roles = new HashSet<Role>();
            roles.add(new Role(1, "ROLE_ADMIN"));
            user.setRoles(roles);
        } else if ("lisi".equals(name)) {
            user = new User();
            user.setId(2);
            user.setName(name);
            String password = bCryptPasswordEncoder.encode("admin");
            user.setPassword(password);
            user.setSalary(34.34F);
            user.setBirthday(new Date());

            Set<Role> roles = new HashSet<Role>();
            roles.add(new Role(1, "USER"));
            user.setRoles(roles);
        }

        return user;
    }
}
