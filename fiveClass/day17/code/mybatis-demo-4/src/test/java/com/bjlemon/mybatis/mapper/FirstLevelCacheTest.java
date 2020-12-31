package com.bjlemon.mybatis.mapper;

import com.bjlemon.mybatis.domain.Employee;
import com.bjlemon.mybatis.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName EmployeMapperTest.java
 * @Description TODO
 * @createTime 2019年12月28日 21:57:00
 */
public class FirstLevelCacheTest {

    @Test
    public void testLazy1() {
        SqlSession sqlSession = null;
        Employee employee = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            employee = employeeMapper.findById(1);
            System.out.println(employee);


            employee = employeeMapper.findById(1);
            System.out.println(employee);

        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSqlSession();
        }
    }

    @Test
    public void testLazy2() {
        SqlSession sqlSession = null;
        Employee employee = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            employee = employeeMapper.findById(1);
            System.out.println(employee);

        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSqlSession();
        }

        sqlSession = MyBatisUtils.getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        employee = employeeMapper.findById(1);
        System.out.println(employee);
    }

    @Test
    public void testLazy3() {
        SqlSession sqlSession = null;
        Employee employee = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            employee = employeeMapper.findById(1);
            System.out.println(employee);

            // 清空缓存
            sqlSession.clearCache();

            employee = employeeMapper.findById(1);
            System.out.println(employee);

        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSqlSession();
        }

    }

    @Test
    public void testLazy4() {
        SqlSession sqlSession = null;
        Employee employee = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            employee = employeeMapper.findById(1);
            System.out.println(employee);

            employee.setName("C罗");
            employeeMapper.update(employee);


            employee = employeeMapper.findById(1);
            System.out.println(employee);

            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSqlSession();
        }

    }

    @Test
    public void testLazy5() {
        SqlSession sqlSession = null;
        Employee employee = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            employee = employeeMapper.findById(1);
            System.out.println(employee);

            employee = employeeMapper.getById(1);
            System.out.println(employee);

            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSqlSession();
        }

    }


}