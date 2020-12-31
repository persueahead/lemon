package com.bj.spring.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class UsersDaoImp extends JdbcDaoSupport implements  UsersDao {
    @Override
    public void addMoney(Integer id, Integer money) {
        String  sql="update user set  user_money=user_money+? where user_id=?";

        assert super.getJdbcTemplate() != null;
        super.getJdbcTemplate().update(sql,money,id);
    }

    @Override
    public void updateMoney(Integer id, Integer money) {
        String  sql="update user set  user_money=user_money-? where user_id=?";
        assert super.getJdbcTemplate() != null;
        super.getJdbcTemplate().update(sql,money,id);
    }
}
