package com.example.ln;




import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.ln.controller.IndexController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Lndemo02ApplicationTests {

	private MockMvc mvc;
	
	@Before
	public void before() {
		mvc = MockMvcBuilders.standaloneSetup(new IndexController()).build();
	}
	
	@Test
	public void contextLoads() throws Exception {
		// 模拟请求
		RequestBuilder req = get("/index/test");
		mvc.perform(req)
		.andExpect(status().isOk())//请求状态
		.andExpect(content().string("hello")); //比较结果	
	}

}
