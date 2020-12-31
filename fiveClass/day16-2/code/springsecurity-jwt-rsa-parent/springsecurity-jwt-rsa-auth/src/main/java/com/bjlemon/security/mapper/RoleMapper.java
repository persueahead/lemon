package com.bjlemon.security.mapper;

import com.bjlemon.security.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName RoleMapper.java
 * @Description TODO
 * @createTime 2020年02月20日 21:05:00
 */
public interface RoleMapper {

    @Select("SELECT role_id id, role_name name, role_description description\n" +
            "FROM t_role\n" +
            "WHERE user_id = #{id}")
    List<Role> findRolesByUserId(Integer id);

    @Select("SELECT role_id id, role_name name, role_description description\n" +
            "FROM t_role\n" +
            "WHERE role_name = #{name}")
    Role findRoleByName(String name);
}
