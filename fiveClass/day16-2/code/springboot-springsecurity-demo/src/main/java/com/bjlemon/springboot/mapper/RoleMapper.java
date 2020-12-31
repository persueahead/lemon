package com.bjlemon.springboot.mapper;

import com.bjlemon.springboot.domain.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {

    List<String> findPermissionCodeListByName(String roleName);
}