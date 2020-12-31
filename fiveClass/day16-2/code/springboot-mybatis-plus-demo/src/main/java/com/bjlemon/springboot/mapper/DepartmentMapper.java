package com.bjlemon.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bjlemon.springboot.domain.Department;
import org.apache.ibatis.annotations.*;

public interface DepartmentMapper extends BaseMapper<Department> {

    @Select("SELECT * FROM sm_department WHERE department_id = #{id}")
    @Results(
            id = "DepartmentResultMap",
            value = {
                    @Result(property = "id", column = "department_id", id = true),
                    @Result(property = "name", column = "department_name"),
                    @Result(property = "location", column = "department_location")
            }
    )
    Department findById(Integer id);

    @Select("SELECT * FROM sm_department WHERE department_name = #{name}")
    @ResultMap(value = "DepartmentResultMap")
    Department findByName(String name);

    @Select("SELECT " +
            "sd.department_id,\n" +
            "       sd.department_name,\n" +
            "       sd.department_location " +
            "FROM sm_department sd\n" +
            "WHERE sd.department_name = #{name}")
    @Results(id = "DepartmentResultMap1",value = {
            @Result(property = "id",column = "department_id",id = true),
            @Result(property = "name",column = "department_name"),
            @Result(property = "location",column = "department_location"),
            @Result(property = "users",column = "department_id",many = @Many(
                    select = "com.bjlemon.springboot.mapper.UserMapper.findUsersByDepartmentId"
            ))
    })
    Department findByName1(String name);
}
