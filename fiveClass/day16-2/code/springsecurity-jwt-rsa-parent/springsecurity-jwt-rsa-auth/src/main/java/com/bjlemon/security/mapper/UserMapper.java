package com.bjlemon.security.mapper;

import com.bjlemon.security.domain.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName UserMapper.java
 * @Description TODO
 * @createTime 2020年02月20日 21:05:00
 */
public interface UserMapper {


    @Select("SELECT user_id , user_name , user_password, user_status\n" +
            "FROM t_user  \n" +
            "WHERE user_name = #{name}")
    @Results(value = {
            @Result(id = true, property = "id", column = "user_id"),
            @Result(property = "name", column = "user_name"),
            @Result(property = "password", column = "user_password"),
            @Result(property = "status", column = "user_status"),
            @Result(property = "roles", column = "user_id", javaType = List.class, many = @Many(
                    select = "com.bjlemon.security.mapper.RoleMapper.findRolesByUserId"
            ))
    })
    User findByName(String username);
}
