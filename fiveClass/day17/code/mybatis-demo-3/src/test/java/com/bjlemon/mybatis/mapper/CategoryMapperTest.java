package com.bjlemon.mybatis.mapper;

import com.bjlemon.mybatis.domain.Category;
import com.bjlemon.mybatis.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName CategoryMapperTest.java
 * @Description TODO
 * @createTime 2019年12月28日 21:20:00
 */
public class CategoryMapperTest {

    @Test
    public void testFindParentByName() {
        SqlSession sqlSession = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);

            Category parentCategory = categoryMapper.findParentByName("Thinkpad W540");
            System.out.println(parentCategory);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession();
        }
    }
}