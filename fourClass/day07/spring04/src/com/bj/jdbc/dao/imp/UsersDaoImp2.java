package com.bj.jdbc.dao.imp;

import com.bj.jdbc.dao.IUsersDao;
import com.bj.jdbc.pojo.Users;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UsersDaoImp2  extends JdbcDaoSupport implements IUsersDao {

   /* private JdbcTemplate jdbcTemplate;*/



    @Override
    public void add(Users users) {
        String sql="INSERT INTO users values(null,?,?) ";

        super.getJdbcTemplate().update(sql,users.getName(),users.getMonery());
    }

    @Override
    public void del(Users users) {
        String sql="delete  from users  where id =? ";
        super.getJdbcTemplate().update(sql,users.getId());
    }

    @Override
    public void upeate(Users users) {
        String sql="UPDATE  users SET  NAME =? ,monery=? WHERE  id =? ";
        super.getJdbcTemplate().update(sql,users.getName(),users.getMonery(),users.getId());
    }

    @Override
    public Users getById(Integer id) {
        String sql="SELECT * FROM users where id=?";

        return   super.getJdbcTemplate().queryForObject(sql, new RowMapper<Users>() {
            @Override
            public Users mapRow(ResultSet resultSet, int i) throws SQLException {
                Users  user= new Users();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setMonery(resultSet.getInt("monery"));
                return user;
            }
        });
    }

    @Override
    public int getTotal() {
        String  sql="select count(*) FROM users";
        return   super.getJdbcTemplate().queryForObject(sql,Integer.class);
    }

    @Override
    public List<Users> getALL() {
        String sql="SELECT * FROM users";
        return   super.getJdbcTemplate().query(sql, new RowMapper<Users>() {
            @Override
            public Users mapRow(ResultSet resultSet, int i) throws SQLException {

                Users  user= new Users();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setMonery(resultSet.getInt("monery"));
                return user;
            }
        });
    }

 }
