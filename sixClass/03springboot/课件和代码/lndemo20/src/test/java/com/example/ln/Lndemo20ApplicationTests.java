package com.example.ln;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.ln.bean.UserInfo;
import com.example.ln.dao.UserInfoDAO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Lndemo20ApplicationTests {

	@Autowired
	private UserInfoDAO userdao;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void query() {
		UserInfo user = userdao.findById(3);
		System.out.println(user);
		
	}
}
