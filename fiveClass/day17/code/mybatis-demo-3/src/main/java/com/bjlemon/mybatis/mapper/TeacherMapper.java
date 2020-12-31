package com.bjlemon.mybatis.mapper;

import com.bjlemon.mybatis.domain.Student;
import com.bjlemon.mybatis.domain.Teacher;

import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName DepartmentMapper.java
 * @Description TODO
 * @createTime 2019年12月26日 21:16:00
 */
public interface TeacherMapper {

    Teacher findByName(String name);

    List<Student> findStudentsByTeacherName(String name);
}
