package com.bjlemon.mybatis.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName MyBatisUtils.java
 * @Description TODO MyBatis工具类(Demo版 真正的开发不能用 SqlSession是线程不安全的)
 * @createTime 2020年02月29日 22:44:00
 */
public class MyBatisUtils {

    private static SqlSessionFactoryBuilder builder;
    private static SqlSessionFactory factory;

    static {
        builder = new SqlSessionFactoryBuilder();
        InputStream inputStream = MyBatisUtils.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        factory = builder.build(inputStream);
    }

    public static SqlSession getSqlSession() {
        return factory.openSession();
    }

    public static void closeSqlSession(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

}
