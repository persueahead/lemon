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
 * @createTime 2020年03月07日 21:19:00
 */
public class DepartmentMapperTest {

    @Test
    public void testFirstLevelCache() {
        SqlSession sqlSession = null;
        Department department = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();

            DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
            department = mapper.findById(1);
            System.out.println(department);

            department = mapper.findById(1);
            System.out.println(department);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession();
        }
    }
    
    @Test
    public void testFirstLevelCache1() {
        SqlSession sqlSession = null;
        Department department = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();

            DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
            department = mapper.findById(1);
            System.out.println(department);

            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession();
        }
        
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        department = mapper.findById(1);
        System.out.println(department);
    }
    
    @Test
    public void testFirstLevelCache2() {
        SqlSession sqlSession = null;
        Department department = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();

            DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
            department = mapper.findById(1);
            System.out.println(department);

//            department.setName("SUN");
//            mapper.update(department);
            
            // 发SQL语句
            department = mapper.findById(1);
            System.out.println(department);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession();
        }
    }
    
    @Test
    public void testFirstLevelCache3() {
        SqlSession sqlSession = null;
        Department department = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();

            DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
            department = mapper.findById(1);
            System.out.println(department);

            sqlSession.clearCache();
            
            // 发SQL语句
            department = mapper.findById(1);
            System.out.println(department);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession();
        }
    }
}