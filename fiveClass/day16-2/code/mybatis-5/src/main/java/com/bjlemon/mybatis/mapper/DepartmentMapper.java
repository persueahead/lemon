package com.bjlemon.mybatis.mapper;

import com.bjlemon.mybatis.domain.Department;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName DepartmentMapper.java
 * @Description TODO
 * @createTime 2020年03月03日 21:45:00
 */
public interface DepartmentMapper {

    Department findById(Integer id);

}
