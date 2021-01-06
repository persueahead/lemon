package com.example.ln.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.ln.dao.UserInfoDAO;
import com.example.ln.po.UserInfo;

@Repository
public class UserInfoDAOImpl implements UserInfoDAO {

	/**
	 * spring jdbc 操作的对象JdbcTemplate
	 */
	@Autowired
	private JdbcTemplate template;
	
	@Override
	public int addUser(UserInfo user) {
		String sql  = "insert into userinfo(t_name,t_sex) values(?,?)";
		return template.update(sql,user.getName(),user.getSex());
	}

	@Override
	public int updateUser(UserInfo user) {
		String sql = "update userinfo set t_name=?,t_sex=? where t_id=?";
		return template.update(sql,user.getName(),user.getSex(),user.getId());
	}

	@Override
	public int deleteUser(UserInfo user) {
		String sql = "delete from  userinfo  where t_id=?";
		return template.update(sql,user.getId());
	}

	@Override
	public UserInfo getUser(UserInfo user) {
		
		String sql = "select * from userinfo where t_id=?";
		
		return template.queryForObject(sql, new RowMapper<UserInfo>() {

			@Override
			public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserInfo userinfo = new UserInfo();
				userinfo.setId(rs.getInt("t_id"));
				user.setName(rs.getString("t_name"));
				user.setSex(rs.getString("t_sex"));
				return user;
			}
			
		},user.getId());
	}

	@Override
	public List<Map<String, Object>> getList(UserInfo user) {
		
		String sql = "select * from userinfo ";
		
		return template.queryForList(sql);
	}

}
