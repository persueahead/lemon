package com.bjlemon.security.service;

import com.bjlemon.security.domain.Role;

public interface RoleService {

    Role findRoleByName(String name);
}
