package com.example.ln;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.ln.dao.UserInfoDAO;
import com.example.ln.po.UserInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Lndemo18ApplicationTests {

	@Autowired
	private UserInfoDAO userdao;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void add() {
		UserInfo user = new UserInfo();
		user.setName("张小三");
		user.setSex("女");
		//把对象持久化到数据库中
		userdao.save(user);
	}
	
	@Test
	public void update() {
		UserInfo user = new UserInfo();
		user.setId(1);
		user.setName("张大三");
		user.setSex("女男");
		//把对象持久化到数据库中
		userdao.save(user);
	}

}
