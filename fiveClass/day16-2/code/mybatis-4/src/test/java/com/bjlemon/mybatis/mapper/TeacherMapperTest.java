package com.bjlemon.mybatis.mapper;

import com.bjlemon.mybatis.domain.Student;
import com.bjlemon.mybatis.domain.Teacher;
import com.bjlemon.mybatis.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName TeacherMapperTest.java
 * @Description TODO
 * @createTime 2020年03月05日 21:10:00
 */
public class TeacherMapperTest {

    @Test
    public void findStudentsByName() {
        SqlSession sqlSession = null;
        List<Student> studentList = Collections.emptyList();

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            studentList = mapper.findStudentsByName("zhangsan");
            studentList.stream().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession();
        }
    }

    @Test
    public void findByName() {
        SqlSession sqlSession = null;
        Teacher teacher = null;
        List<Student> studentList = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            teacher = mapper.findByName("zhangsan");

            Set<Student> studentSet = teacher.getStudents();
            studentList = new ArrayList(studentSet);
            studentList.stream().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession();
        }
    }
}