package com.bj.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

public class TestJdbc {

    /**
     *
     */
    @Test
    public   void test() throws PropertyVetoException {
         //1.获取连接池对象
        ComboPooledDataSource dataSource
                = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&amp;characterEncoding=utf-8");
        dataSource.setUser("root");
        dataSource.setPassword("wdylzyn");

        //2.创建连接对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        System.out.println("---------"+jdbcTemplate);
        //编写sql
       String sql="insert into user values(1,'amdin',123)";
        int update = jdbcTemplate.update(sql);
        System.out.println(update);


    }
}
