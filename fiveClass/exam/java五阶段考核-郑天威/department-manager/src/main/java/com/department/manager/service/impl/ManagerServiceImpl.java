package com.department.manager.service.impl;

import com.department.manager.domain.Manager;
import com.department.manager.domain.ManagerExample;
import com.department.manager.domain.Role;
import com.department.manager.mapper.ManagerMapper;
import com.department.manager.mapper.RoleMapper;
import com.department.manager.service.ManagerService;
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
 * @author 夜神
 */
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerMapper managerMapper;
    @Autowired
    private RoleMapper roleMapper;

    /**
     * @param managerName 管理员名
     * @return UserDetails对象
     * @throws UsernameNotFoundException
     * @description 根据管理员名查询角色 用角色访问 没有使用权限
     */
    @Override
    public UserDetails loadUserByUsername(String managerName) throws UsernameNotFoundException {
//        要返回的userDetails对象
        UserDetails userDetails = null;
//      装载UserDetails的User对象的authority信息
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        ManagerExample managerExample = new ManagerExample();
//        装条件，用来按名称查询数据库的user对象
        ManagerExample.Criteria criteria = managerExample.createCriteria();
//        以名字作为查询条件
        criteria.andManagerNameEqualTo(managerName);
//       按名称查询 假设无重名
        List<Manager> managerList = this.managerMapper.selectByExample(managerExample);
//        如果能够根据名字查到该人
        if (CollectionUtils.isNotEmpty(managerList)) {
//            通过名称从数据库查询出来的user，假设没有同名的
            Manager manager = managerList.get(0);
//            根据roleId查到角色
            Role role=this.managerMapper.selectRoleByManagerId(manager.getRoleId());

//将角色封装成SimpleGrantedAuthority

            SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRoleName());
            grantedAuthorities.add(grantedAuthority);

//          返回一个UserDetails对象
//            利用user.status状态标识用户是否可用
            userDetails = new org.springframework.security.core.userdetails.User(
                    manager.getManagerName(),
                    manager.getManagerPassword(),
                    true,
                    true,
                    true,
                    true,
                    grantedAuthorities
            );
            return userDetails;
        } else {
//            根据名字查不到这个人，直接返回null结束方法
            return null;
        }
    }
}
