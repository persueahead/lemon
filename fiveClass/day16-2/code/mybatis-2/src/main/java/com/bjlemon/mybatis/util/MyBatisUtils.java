package com.bjlemon.mybatis.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName MyBatisUtils.java
 * @Description 由于SqlSession线程不安全，那么我们必须将它做成线程局部变量（ThreadLocal(Map) k:绑定当前线程）
 * @createTime 2020年03月03日 20:44:00
 */
public class MyBatisUtils {

    private static SqlSessionFactoryBuilder builder;
    private static SqlSessionFactory factory;

    private static ThreadLocal<SqlSession> sqlSessionThreadLocal = new ThreadLocal<>();

    static {
        builder = new SqlSessionFactoryBuilder();
        InputStream inputStream = MyBatisUtils.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        factory = builder.build(inputStream);
    }

    public static SqlSession getSqlSession() {
        SqlSession sqlSession = sqlSessionThreadLocal.get();
        if (sqlSession == null) {
            sqlSession = factory.openSession();
            sqlSessionThreadLocal.set(sqlSession);
        }

        return sqlSession;
    }

    public static void closeSqlSession() {
        SqlSession sqlSession = sqlSessionThreadLocal.get();
        if (sqlSession != null) {
            sqlSession.close();
            sqlSessionThreadLocal.remove();
        }
    }
}
