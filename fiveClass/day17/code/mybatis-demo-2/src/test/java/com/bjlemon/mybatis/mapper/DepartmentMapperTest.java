package com.bjlemon.mybatis.mapper;

import com.bjlemon.mybatis.domain.Department;
import com.bjlemon.mybatis.domain.Employee;
import com.bjlemon.mybatis.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName DepartmentMapperTest.java
 * @Description TODO
 * @createTime 2019年12月26日 21:24:00
 */
public class DepartmentMapperTest {

    @Test
    public void testSave() {
        SqlSession sqlSession = null;
        Department department = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
            department = Department.builder().name("IBM").location("LOS").build();
            departmentMapper.save(department);

            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSqlSession();
        }
    }

    @Test
    public void testFindEmployeesByDepartmentName() {
        SqlSession sqlSession = null;
        List<Employee> employeeList = Collections.emptyList();

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
            employeeList = departmentMapper.findEmployeesByDepartmentName("IBM");
            employeeList.stream().forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession();
        }
    }

    @Test
    public void testFindByName() {
        SqlSession sqlSession = null;
        Department department = null;
        List<Employee> employeeList = Collections.emptyList();

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
            department = departmentMapper.findByName("IBM");
            Set<Employee> employees = department.getEmployees();
            employees.stream().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession();
        }
    }
}