package com.bjlemon.mybatis.mapper;

import com.bjlemon.mybatis.domain.Category;
import com.bjlemon.mybatis.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName CategoryMapperTest.java
 * @Description TODO
 * @createTime 2020年03月05日 21:34:00
 */
public class CategoryMapperTest {

    @Test
    public void findParentByName() {
        SqlSession sqlSession = null;
        Category parentCategory = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
            parentCategory = mapper.findParentByName("Thinkpad W");
            System.out.println(parentCategory);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession();
        }
    }

    @Test
    public void findChildrenByName() {
        SqlSession sqlSession = null;
        List<Category> categoryList = Collections.emptyList();

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
            categoryList = mapper.findChildrenByName("IBM笔记本");
            categoryList.stream().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession();
        }
    }

}