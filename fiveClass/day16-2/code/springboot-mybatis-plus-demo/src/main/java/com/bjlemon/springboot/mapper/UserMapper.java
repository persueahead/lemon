package com.bjlemon.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bjlemon.springboot.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    @Select(value = "SELECT su.user_id id, su.user_name name, su.user_password password, su.user_salary salary, su.user_birthday birthday " +
            "FROM sm_user su LEFT JOIN sm_department sd ON su.department_id = sd.department_id " +
            "WHERE sd.department_name = #{name}")
    List<User> findUsersByDepartmentName(String name);

    @Select(value = "SELECT " +
            "su.user_id, " +
            "su.user_name, " +
            "su.user_password, " +
            "su.user_salary, " +
            "su.user_birthday, " +
            "sd.department_id, " +
            "sd.department_name, " +
            "sd.department_location " +
            "FROM sm_user su LEFT JOIN sm_department sd ON su.department_id = sd.department_id " +
            "WHERE sd.department_name = #{name}")
    @Results(id = "UserResultMap", value = {
            @Result(property = "id", column = "user_id", id = true),
            @Result(property = "name", column = "user_name"),
            @Result(property = "password", column = "user_password"),
            @Result(property = "salary", column = "user_salary"),
            @Result(property = "birthday", column = "user_birthday"),
            @Result(property = "department", column = "department_id",
                    one = @One(select = "com.bjlemon.springboot.mapper.DepartmentMapper.findById"))
    })
    List<User> findUserListByDepartmentName1(String name);

    @Select(value = "SELECT " +
            "user_id       id,\n" +
            "       user_name     name,\n" +
            "       user_password password,\n" +
            "       user_salary   salary,\n" +
            "       user_birthday birthday\n" +
            "FROM" +
            " sm_user\n" +
            "WHERE department_id = #{id}")
    List<User> findUsersByDepartmentId(Integer id);
}
