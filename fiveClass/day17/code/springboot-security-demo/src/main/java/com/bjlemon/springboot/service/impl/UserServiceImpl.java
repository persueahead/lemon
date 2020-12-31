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
import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName UserServiceImpl.java
 * @Description TODO
 * @createTime 2020年02月18日 20:44:00
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RoleMapper roleMapper;


    /**
     * @description 根据用户名称查询该用户，同时将该用户的所有的权限查询出来
     * @author admin
     * @updateTime 2020/2/18 20:49
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = null;
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        List<String> roleNameList = new ArrayList<>();

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(username);
        List<User> userList = this.userMapper.selectByExample(userExample);

        if (CollectionUtils.isNotEmpty(userList)) {
            User user = userList.get(0);

            // TODO 查询该用户的所有的角色
            UserRoleExample userRoleExample = new UserRoleExample();
            UserRoleExample.Criteria userRoleExampleCriteria = userRoleExample.createCriteria();
            userRoleExampleCriteria.andUserIdEqualTo(user.getUserId());
            List<UserRoleKey> userRoleKeyList = this.userRoleMapper.selectByExample(userRoleExample);
            if (CollectionUtils.isNotEmpty(userRoleKeyList)) {
                for (UserRoleKey userRoleKey : userRoleKeyList) {
                    Integer roleId = userRoleKey.getRoleId();
                    Role role = this.roleMapper.selectByPrimaryKey(roleId);
                    String roleName = role.getRoleName();
                    roleNameList.add(roleName);
                }
            }
            System.out.println(roleNameList);
            // TODO 角色封装成SimpleGrantedAuthority
            for (String roleName : roleNameList) {
                SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(roleName);
                grantedAuthorityList.add(grantedAuthority);
            }

            // TODO 根据用户查询该用户的权限
            List<Permission> permissionList = this.userMapper.findPermissionsByUserId(user.getUserId());
            if (CollectionUtils.isNotEmpty(permissionList)) {
                for (Permission permission : permissionList) {
                    String permissionName = permission.getPermissionName();
                    SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permissionName);
                    grantedAuthorityList.add(grantedAuthority);

                }
            }

            userDetails = new org.springframework.security.core.userdetails.User(user.getUserName(),
                    user.getUserPassword(),
                    user.getUserStatus() == 1,
                    true,
                    true,
                    true,
                    grantedAuthorityList);
        } else {
            return null;
        }


        return userDetails;
    }
}
