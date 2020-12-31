package com.bjlemon.mybatis.mapper;

import com.bjlemon.mybatis.domain.Student;
import com.bjlemon.mybatis.domain.Teacher;
import com.bjlemon.mybatis.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName TeacherMapperTest.java
 * @Description TODO
 * @createTime 2019年12月26日 20:24:00
 */
public class TeacherMapperTest {

    @Test
    public void testFindStudentsByTeacherName() {
        SqlSession sqlSession = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);

            List<Student> studentList = teacherMapper.findStudentsByTeacherName("zhangsan");
            studentList.stream().forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession();
        }
    }

    @Test
    public void testFindByName() {
        SqlSession sqlSession = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);

            Teacher teacher = teacherMapper.findByName("lisi");
            teacher.getStudents().stream().forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession();
        }
    }


}