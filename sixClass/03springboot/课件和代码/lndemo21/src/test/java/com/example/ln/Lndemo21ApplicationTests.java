package com.example.ln;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Lndemo21ApplicationTests {

	@Autowired
	private StringRedisTemplate sredisTemplate;
	
	//String
/*	@Test
	public void valueAdd() {
		ValueOperations<String , String> voper =  sredisTemplate.opsForValue();
		voper.set("key", "value");
	}
	
	@Test
	public void valueGet() {
		ValueOperations<String , String> voper =  sredisTemplate.opsForValue();
		String key = voper.get("key");
		System.out.println(key);
	}
	
	@Test
	public void valueDelete() {
		sredisTemplate.delete("key");

	}*/
	
	//List
	/*@Test
	public void listPhsh() {
		//从右边添加数据
		sredisTemplate.opsForList().rightPush("MyList", "1");
		sredisTemplate.opsForList().rightPush("MyList", "2");
		sredisTemplate.opsForList().rightPush("MyList", "3");
		sredisTemplate.opsForList().rightPush("MyList", "A");
		sredisTemplate.opsForList().rightPush("MyList", "B");
		
		//依次由左添加
		sredisTemplate.opsForList().leftPush("MyList", "0");
		
	}
	
	@Test
	public void listGet() {
		
		//查询所有的元素
		List<String> list = sredisTemplate.opsForList().range("MyList", 0, -1);
		System.out.println(list);
		
		//查询前三个元素
		list = sredisTemplate.opsForList().range("MyList", 0, 2);
		System.out.println(list);
	}
	
	@Test
	public void listdelete1() {
		//删除先进入的A的元素
		sredisTemplate.opsForList().remove("MyList", 1, "A");
		
	}
	
	@Test
	public void listdelete2() {
		//删除所有B的元素
		sredisTemplate.opsForList().remove("MyList", 0, "B");
		
	}*/
	
	
	//Hash
	@Test
	public void hashPut() {
		
		sredisTemplate.opsForHash().put("user:1:info", "userSex", "man");
		sredisTemplate.opsForHash().put("user:1:info", "userAg", "18");
	}
	
	@Test
	public void hashGet() {
		
		Map<Object,Object> map = sredisTemplate.opsForHash().entries("user:1:info");
		System.out.println(map);
	}
	
	@Test
	public void hashDelete() {
		//根据map的key删除这个元素
		sredisTemplate.opsForHash().delete("user:1:info", "userSex");
	}
	
	@Test
	public void hashGetKeys() {
		//获取map所有的key的集合
		Set<Object> objs = sredisTemplate.opsForHash().keys("user:1:info");
		System.out.println(objs);
	}
	
	
	@Test
	public void hashGetValues() {
		//获取map所有的key的集合
		List<Object> objs = sredisTemplate.opsForHash().values("user:1:info");
		System.out.println(objs);
	} 
	
	@Test
	public void hashSize() {
		//获取map对象的大小
		long size = sredisTemplate.opsForHash().size("user:1:info");
		System.out.println(size);
		
		
	}
}
