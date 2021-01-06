package com.example.ln.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import com.example.ln.po.UserInfo;

@Mapper
@Transactional
public interface UserInfoDAO {

	@Select("select * from user_info where id=#{id}")
	@Results(value= {
			@Result(column="id",property="id"),
			@Result(column="name",property="name"),
			@Result(column="sex",property="sex")
	})
	public UserInfo findById(Integer id);
	
	
	@Select("select * from user_info ")
	@Results(value= {
			@Result(column="id",property="id"),
			@Result(column="name",property="name"),
			@Result(column="sex",property="sex")
	})
	public List<UserInfo> findAll();
	
	
	@Insert("insert into user_info (name,sex) value(#{name},#{sex})")
	public int addUser(UserInfo user);
	
	
	@Update(" update user_info set name=#{name},sex=#{sex} where id=#{id}")
	public int updateUser(UserInfo user);
	
	@Delete("delete from user_info where id = #{id}")
	public int deleteUser(Integer id);
	
	
}
