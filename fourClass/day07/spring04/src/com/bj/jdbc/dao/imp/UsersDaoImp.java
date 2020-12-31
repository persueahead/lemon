package com.bj.jdbc.dao.imp;

import com.bj.jdbc.dao.IUsersDao;
import com.bj.jdbc.pojo.Users;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UsersDaoImp implements IUsersDao {

    private JdbcTemplate jdbcTemplate;



    @Override
    public void add(Users user) {
        String sql="INSERT INTO user values(null,?,?) ";

        jdbcTemplate.update(sql,user.getUserName(),user.getUserMoney());
    }

    @Override
    public void del(Users user) {
        String sql="delete  from user  where user_id =? ";
        jdbcTemplate.update(sql,user.getUserId());
    }

    @Override
    public void upeate(Users user) {
        String sql="UPDATE  user SET  user_name =? ,user_money=? WHERE  user_id =? ";
        jdbcTemplate.update(sql,user.getUserName(),user.getUserMoney(),user.getUserId());
    }

    @Override
    public Users getById(Integer id) {
        String sql="SELECT * FROM user where user_id=?";

/*有结果集，用来装对象的的  返回单个对象
       return: the single mapped object (may be null if the given RowMapper returned null)*/
        return jdbcTemplate.queryForObject(sql, new RowMapper<Users>() {
            @Override
            public Users mapRow(ResultSet resultSet, int i) throws SQLException {
                Users  user= new Users();
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserName(resultSet.getString("user_name"));
                user.setUserMoney(resultSet.getInt("user_money"));
                return user;
            }
        },id);
    }

    @Override
    public int getTotal() {
        String  sql="select count(*) FROM user";
//        没结果集，return：the result object of the required type, or null in case of SQL NULL
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }

    @Override
    public List<Users> getALL() {
        String sql="SELECT * FROM user";
//        返回List：the result List, containing mapped objects
        return jdbcTemplate.query(sql, new RowMapper<Users>() {
            @Override
            public Users mapRow(ResultSet resultSet, int i) throws SQLException {

                Users  user= new Users();
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserName(resultSet.getString("user_name"));
                user.setUserMoney(resultSet.getInt("user_money"));
                return user;
            }
        });
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
