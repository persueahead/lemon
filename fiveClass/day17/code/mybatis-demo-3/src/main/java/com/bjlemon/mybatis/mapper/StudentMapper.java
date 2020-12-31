package com.bjlemon.mybatis.mapper;

import com.bjlemon.mybatis.domain.Student;

import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName StudentMapper.java
 * @Description TODO
 * @createTime 2019年12月26日 21:17:00
 */
public interface StudentMapper {


    List<Student> findStudentsByTeacherId(Integer id);
}
