package com.bjlemon.security.service.impl;

import com.bjlemon.security.dao.UserDao;
import com.bjlemon.security.domain.Role;
import com.bjlemon.security.domain.User;
import com.bjlemon.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName UserServiceImpl.java
 * @Description TODO
 * @createTime 2020年02月11日 22:10:00
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        User user = this.userDao.findByName(username);

        if (user == null) {
            return null;
        }

        // TODO 查询该用户所有的权限
        Set<Role> roles = user.getRoles();
        if (!CollectionUtils.isEmpty(roles)) {
            for (Role role : roles) {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            }
        }

        // 没有加密需要加上"{noop}"
//        return new org.springframework.security.core.userdetails.User(user.getName(), "{noop}" + user.getPassword(), authorities);
//        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), authorities);
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), true, true, true, true, authorities);

    }
}
