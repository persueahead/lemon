package com.bjlemon.mybatis.mapper;

import com.bjlemon.mybatis.domain.IdCard;
import com.bjlemon.mybatis.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName PersonMapperTest.java
 * @Description TODO
 * @createTime 2020年03月05日 20:37:00
 */
public class PersonMapperTest {

    @Test
    public void findIdCardByName() {
        SqlSession sqlSession = null;
        IdCard idCard = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
            idCard = mapper.findIdCardByName("zhangsan");
            System.out.println(idCard);
        } catch (Exception e) {

        } finally {
            MyBatisUtils.closeSqlSession();
        }
    }
}