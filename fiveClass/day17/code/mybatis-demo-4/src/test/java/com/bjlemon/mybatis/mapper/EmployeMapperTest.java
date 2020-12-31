package com.bjlemon.mybatis.mapper;

import com.bjlemon.mybatis.domain.Employee;
import com.bjlemon.mybatis.util.MyBatisUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName EmployeMapperTest.java
 * @Description TODO
 * @createTime 2019年12月28日 21:57:00
 */
public class EmployeMapperTest {

    @Test
    public void testLazy1() {
        SqlSession sqlSession = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            // 下面的代码只会发一条SQL语句（只查询员工，部门不会查询）
            List<Employee> employeeList = employeeMapper.findAll();
            if (CollectionUtils.isNotEmpty(employeeList)) {
                for (Employee employee : employeeList) {
                    System.out.println(employee.getId() + "-----" + employee.getName());
                    System.out.println(employee.getDepartment());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSqlSession();
        }

        sqlSession = MyBatisUtils.getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employeeList = employeeMapper.findAll();
        if (CollectionUtils.isNotEmpty(employeeList)) {
            for (Employee employee : employeeList) {
                System.out.println(employee.getId() + "-----" + employee.getName());
                System.out.println(employee.getDepartment());
            }
        }
    }


}