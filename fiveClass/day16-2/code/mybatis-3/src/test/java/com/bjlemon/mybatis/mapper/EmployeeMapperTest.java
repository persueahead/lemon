package com.bjlemon.mybatis.mapper;

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
 * @createTime 2020年03月03日 21:58:00
 */
public class EmployeeMapperTest {

    @Test
    public void save() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            Employee employee = Employee.builder()
                    .name("lisi")
                    .password("admin")
                    .salary(12.34F)
                    .birthday(new Date())
                    .department(null)
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
}