package com.bjlemon.mybatis.mapper;

import com.bjlemon.mybatis.domain.User;
import com.bjlemon.mybatis.util.MyBatisUtils;
import com.bjlemon.mybatis.vo.UserQueryVO;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName UserMapperTest.java
 * @Description TODO
 * @createTime 2020年03月05日 22:58:00
 */
public class UserMapperTest {

    @Test
    public void findUsersByQueryVO() {
        SqlSession sqlSession = null;
        List<User> userList = Collections.emptyList();

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            UserQueryVO userQueryVO = new UserQueryVO();
            userQueryVO.setName("%z%");
            userQueryVO.setPassword("%a%");
            userList = mapper.findUsersByQueryVO(userQueryVO);
            userList.stream().forEach(System.out::println);
        } catch (Exception e) {

        } finally {
            MyBatisUtils.closeSqlSession();
        }
    }

    @Test
    public void findUsersByIds() {
        SqlSession sqlSession = null;
        List<User> userList = Collections.emptyList();

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            Integer[] ids = new Integer[]{1, 2, 3};
            userList = mapper.findUsersByIds(ids);

            userList.stream().forEach(System.out::println);
        } catch (Exception e) {

        } finally {
            MyBatisUtils.closeSqlSession();
        }
    }

    @Test
    public void findUsersByIdList() {
        SqlSession sqlSession = null;
        List<User> userList = Collections.emptyList();

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            Integer[] ids = new Integer[]{1, 2, 3};
            userList = mapper.findUsersByIdList(Arrays.asList(ids));

            userList.stream().forEach(System.out::println);
        } catch (Exception e) {

        } finally {
            MyBatisUtils.closeSqlSession();
        }
    }
}