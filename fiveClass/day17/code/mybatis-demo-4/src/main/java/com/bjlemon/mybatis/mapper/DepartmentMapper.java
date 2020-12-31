package com.bjlemon.mybatis.mapper;

import com.bjlemon.mybatis.domain.Department;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName DepartmentMapper.java
 * @Description TODO
 * @createTime 2019年12月26日 21:16:00
 */
public interface DepartmentMapper {

    Department findById(Integer id);

}
