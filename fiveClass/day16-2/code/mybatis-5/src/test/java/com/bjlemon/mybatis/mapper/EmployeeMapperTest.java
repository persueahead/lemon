package com.bjlemon.mybatis.mapper;

import com.bjlemon.mybatis.domain.Employee;
import com.bjlemon.mybatis.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName EmployeeMapperTest.java
 * @Description TODO
 * @createTime 2020年03月07日 20:41:00
 */
public class EmployeeMapperTest {

    @Test
    public void findDepartmentByName() {
        SqlSession sqlSession = null;
        List<Employee> employeeList = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();

            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            employeeList = mapper.findAll();
            for (Employee employee : employeeList) {
                System.out.println(employee.getDepartment());
            }
        } catch (Exception e) {

        } finally {

        }
    }
}