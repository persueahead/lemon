package com.bjlemon.springboot.service.impl;

import com.bjlemon.springboot.domain.*;
import com.bjlemon.springboot.mapper.RoleMapper;
import com.bjlemon.springboot.mapper.UserMapper;
import com.bjlemon.springboot.mapper.UserRoleMapper;
import com.bjlemon.springboot.service.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = null;
        List<String> roleNameList = Collections.emptyList();
        List<String> permissionCodeList = Collections.emptyList();
        Collection<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();


        // TODO 根据用户名称查询用户
        user = this.userMapper.findUserByName(name);

        // TODO 根据用户查询用户角色名称
        roleNameList = this.userMapper.findRoleNameListByUserId(user.getUserId());
        if (CollectionUtils.isNotEmpty(roleNameList)) {
            for (String roleName : roleNameList) {
                simpleGrantedAuthorities.add(new SimpleGrantedAuthority(roleName));

                // TODO 根据角色名称查询权限名称
                permissionCodeList = this.roleMapper.findPermissionCodeListByName(roleName);
                if (CollectionUtils.isNotEmpty(permissionCodeList)) {
                    for (String permissionCode : permissionCodeList) {
                        simpleGrantedAuthorities.add(new SimpleGrantedAuthority(permissionCode));
                    }
                }
            }
        }

        return new org.springframework.security.core.userdetails.User(name, user.getUserPassword(), simpleGrantedAuthorities);
    }
}
