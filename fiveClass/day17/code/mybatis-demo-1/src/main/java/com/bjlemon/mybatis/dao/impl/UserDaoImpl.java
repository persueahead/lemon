package com.bjlemon.mybatis.dao.impl;

import com.bjlemon.mybatis.dao.UserDao;
import com.bjlemon.mybatis.domain.User;
import com.bjlemon.mybatis.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.Collections;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public void save(User user) {
        SqlSession sqlSession = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            sqlSession.insert("com.bjlemon.mybatis.domain.save", user);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSqlSession();
        }
    }

    @Override
    public void delete(User user) {
        SqlSession sqlSession = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            sqlSession.delete("com.bjlemon.mybatis.domain.delete", user);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSqlSession();
        }
    }

    @Override
    public void update(User user) {
        SqlSession sqlSession = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            sqlSession.update("com.bjlemon.mybatis.domain.update", user);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSqlSession();
        }
    }

    @Override
    public User findById(Integer id) {
        SqlSession sqlSession = null;
        User user = null;
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            user = sqlSession.selectOne("com.bjlemon.mybatis.domain.findById", id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession();
        }

        return user;
    }

    @Override
    public List<User> findAll() {
        SqlSession sqlSession = null;
        List<User> userList = Collections.emptyList();
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            userList = sqlSession.selectList("com.bjlemon.mybatis.domain.findAll");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession();
        }

        return userList;
    }
}
