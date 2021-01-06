package com.example.ln;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.ln.dao.UserInfoDAO;
import com.example.ln.po.UserInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Lndemo19ApplicationTests {

	
	@Autowired
	private UserInfoDAO userdao;
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void query1() {
		
		UserInfo user = userdao.findById(1);
		System.out.println(user);
	}
	
	@Test
	public void query2() {
		
		List<UserInfo> list = userdao.findAll();
		for(UserInfo user:list) {
			System.out.println(user);
		}
		
	}
	
	@Test
	public void add() {
		
		UserInfo user = new UserInfo();
		user.setName("孙悟空");
		user.setSex("男");
		
		int count = userdao.addUser(user);
		
		System.out.println("响应行数:"+count);
		
		
	}
	
	
	@Test
	public void update() {
		
		UserInfo user = new UserInfo();
		user.setId(1);
		user.setName("小悟空");
		user.setSex("男");
		
		int count = userdao.updateUser(user);
		
		System.out.println("响应行数:"+count);
		
		
	}
	
	
	@Test
	public void delete() {
		
		
		
		int count = userdao.deleteUser(1);
		
		System.out.println("响应行数:"+count);
		
		
	}
}
