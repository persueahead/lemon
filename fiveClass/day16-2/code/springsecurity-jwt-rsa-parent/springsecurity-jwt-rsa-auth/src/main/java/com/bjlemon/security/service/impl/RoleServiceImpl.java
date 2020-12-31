package com.bjlemon.security.service.impl;

import com.bjlemon.security.domain.Role;
import com.bjlemon.security.mapper.RoleMapper;
import com.bjlemon.security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role findRoleByName(String name) {
        return this.roleMapper.findRoleByName(name);
    }
}
