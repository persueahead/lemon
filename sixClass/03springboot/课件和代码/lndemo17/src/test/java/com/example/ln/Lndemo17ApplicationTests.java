package com.example.ln;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.ln.dao.UserInfoDAO;
import com.example.ln.po.UserInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Lndemo17ApplicationTests {

	@Autowired
	private UserInfoDAO userdao;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void add() {
		UserInfo user = new UserInfo();
		user.setName("猪八戒");
		user.setSex("男");
		
		int count = userdao.addUser(user);
		System.out.println("影响行数："+count);
	}
	
	@Test
	public void update() {
		UserInfo user = new UserInfo();
		user.setId(1);
		user.setName("猪小戒");
		user.setSex("女");
		
		int count = userdao.updateUser(user);
		System.out.println("影响行数："+count);
	}
	
	@Test
	public void delete() {
		UserInfo user = new UserInfo();
		user.setId(1);

		
		int count = userdao.deleteUser(user);
		System.out.println("影响行数："+count);
	}

	@Test
	public void getUser() {
		
		UserInfo user = new UserInfo();
		user.setId(2);
		
		user = userdao.getUser(user);
		
		System.out.println(user);
	}
	
	@Test
	public void list() {
		
		UserInfo user = new UserInfo();
		List<Map<String, Object>> list = userdao.getList(user);
		
		for(Map<String, Object> map:list) {
			System.out.println(map.get("t_id")+" "+map.get("t_name")+" "+map.get("t_sex"));
		}
	}
}
