package com.bjlemon.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bjlemon.springboot.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName DepartmentMapper.java
 * @Description TODO
 * @createTime 2020年01月12日 21:43:00
 */
public interface UserMapper extends BaseMapper<User> {

    /*@Select(value = "SELECT user_id id, user_name name, user_password password, user_salary salary, user_birthday birthday " +
            "FROM springboot_mybatis_user " +
            "WHERE department_id = #{id}")
    List<User> findUsersByDepartmentId(@Param(value = "id") Integer departmentId);*/

    /*@Select(value = "SELECT user_id, user_name, user_password, user_salary, user_birthday " +
            "FROM springboot_mybatis_user " +
            "WHERE department_id = #{id}")
    @Results(id = "UserBaseResultMap", value = {
            @Result(property = "id", column = "user_id", id = true),
            @Result(property = "name", column = "user_name"),
            @Result(property = "password", column = "user_password"),
            @Result(property = "salary", column = "user_salary"),
            @Result(property = "birthday", column = "user_birthday")
    })
    List<User> findUsersByDepartmentId(@Param(value = "id") Integer departmentId);*/

    @Select(value = "SELECT " +
            "smu.user_id,\n" +
            "       smu.user_name,\n" +
            "       smu.user_password,\n" +
            "       smu.user_salary,\n" +
            "       smu.user_birthday,\n" +
            "       smd.department_id,\n" +
            "       smd.department_name,\n" +
            "       smd.department_location\n" +
            "FROM springboot_mybatis_user smu\n" +
            "         " +
            "LEFT JOIN springboot_mybatis_department smd ON smu.department_id = smd.department_id\n" +
            "WHERE smd.department_id = #{id}")
    @Results(id = "UserResultMap", value = {
            @Result(property = "id", column = "user_id", id = true),
            @Result(property = "name", column = "user_name"),
            @Result(property = "password", column = "user_password"),
            @Result(property = "salary", column = "user_salary"),
            @Result(property = "birthday", column = "user_birthday"),
            @Result(property = "department", column = "department_id", one = @One(select = "com.bjlemon.springboot.mapper.DepartmentMapper.findById"))
    })
    List<User> findUsersByDepartmentId(@Param(value = "id") Integer departmentId);

}
