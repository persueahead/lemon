package com.bjlemon.mybatis.mapper;

import com.bjlemon.mybatis.domain.Student;
import com.bjlemon.mybatis.domain.Teacher;

import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName PersonMapper.java
 * @Description TODO
 * @createTime 2020年03月03日 21:45:00
 */
public interface TeacherMapper {

    List<Student> findStudentsByName(String name);

    Teacher findByName(String name);
}
