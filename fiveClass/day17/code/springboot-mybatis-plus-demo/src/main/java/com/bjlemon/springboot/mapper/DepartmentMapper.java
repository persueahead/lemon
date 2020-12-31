package com.bjlemon.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bjlemon.springboot.domain.Department;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName DepartmentMapper.java
 * @Description TODO
 * @createTime 2020年01月12日 21:43:00
 */
public interface DepartmentMapper extends BaseMapper<Department> {

    @Select("SELECT * FROM springboot_mybatis_department WHERE department_id = #{id}")
    @Results(id = "DepartmentResultMap", value = {
            @Result(id = true, property = "id", column = "department_id"),
            @Result(property = "name", column = "department_name"),
            @Result(property = "location", column = "department_location")
    })
    Department findById(Integer id);
}
