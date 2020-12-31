package com.bjlemon.mybatis.mapper;

import com.bjlemon.mybatis.domain.Department;
import com.bjlemon.mybatis.domain.Employee;
import com.bjlemon.mybatis.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName EmployeeMapperTest.java
 * @Description TODO
 * @createTime 2019年12月26日 21:26:00
 */
public class EmployeeMapperTest {

    @Test
    public void save() {
        SqlSession sqlSession = null;
        Department department = null;
        Employee employee = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            department = departmentMapper.findById(2);

            employee = Employee.builder().name("lisi")
                    .password("123456")
                    .salary(45.34F)
                    .birthday(new Date())
                    .department(department)
                    .build();
            employeeMapper.save(employee);

            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSqlSession();
        }
    }

    @Test
    public void testFindDepartmentByEmployeeName() {
        SqlSession sqlSession = null;
        Department department = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            department = employeeMapper.findDepartmentByEmployeeName("zhangsan");
            System.out.println(department);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession();
        }
    }

    @Test
    public void testFindByName() {
        SqlSession sqlSession = null;
        Employee employee = null;
        Department department = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            employee = employeeMapper.findByName("zhangsan");
            department = employee.getDepartment();
            System.out.println(department);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession();
        }
    }

}