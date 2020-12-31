package com.bjlemon.mybatis.mapper;

import com.bjlemon.mybatis.domain.Department;
import com.bjlemon.mybatis.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName DepartmentMapperTest.java
 * @Description TODO
 * @createTime 2020年03月05日 22:20:00
 */
public class DepartmentMapperTest {

    @Test
    public void save() {
        SqlSession sqlSession = null;
        Department department = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
            department = new Department();
            department.setName("IBM");
            department.setLocation("LOS");

            mapper.save(department);

            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSqlSession();
        }
    }
}