package com.ln.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.ln.po.Person;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreeTest {

	/**
	 * 生成HTML页面
	 * 
	 * @param ftlname
	 *            模版
	 * @param map
	 *            数据
	 *            
	 * @param outname 输出页面         
	 */
	public void process(String ftlname, Map<Object, Object> map,String outname) {
		try {
			// 配置对象
			Configuration conf = new Configuration();
			// 模版路径
			String dir = "D:\\Users\\eclipse-workspace201801\\freemarker\\ftl\\";

			// 倒入模版
			conf.setDirectoryForTemplateLoading(new File(dir));

			// 获取模版
			Template temp = conf.getTemplate(ftlname);

			// 输出流
			Writer out = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(new File(dir + outname)), "UTF-8"));

			// 生成页面
			temp.process(map, out);

			// 关闭资源
			out.flush();
			out.close();
			System.out.println("生成完毕");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("生成失败");
		}

	}
	
	/**
	 * 输出对象
	 */
	@Test
	public void testObj() {
		//数据
		Person p = new Person();
		p.setId(1001);
		p.setName("张三");
		p.setSex("男");
		
		Map<Object, Object> map = new HashMap<>();
		map.put("person", p);
		
		//生成HTML
		process("person.ftl",map,"person.html");
		
	}
	
	/**
	 * 遍历list
	 */
	@Test
	public void testList() {
		List<Person> list = new ArrayList<>();
		
		for(int i = 0 ;i<10;i++) {
			Person p = new Person();
			p.setId(1000+i);
			p.setName("张三"+i);
			p.setSex("男");
			list.add(p);
		}
		
		Map<Object, Object> map = new HashMap<>();
		map.put("plist", list);
		
		
		//生成HTML
		process("person_list.ftl",map,"person_list.html");
		
	}
	
	@Test
	public void testMap() {
		Map<String,Object> map = new HashMap<>();
		map.put("id", 9527);
		map.put("name", "华安");
		map.put("age", 18);
		
		Map<Object,Object> root = new HashMap<>();
		root.put("map", map);
		
		
		//生成HTML
		process("map.ftl",root,"map.html");
		
	}
	
	
	@Test
	public void testListMap() {
		Map<String,Object> map1 = new HashMap<>();
		map1.put("id", 9527);
		map1.put("name", "华安");
		map1.put("age", 18);
		
		
		Map<String,Object> map2 = new HashMap<>();
		map2.put("id", 1001);
		map2.put("name", "秋香");
		map2.put("age", 18);
		
		List<Map> list = new ArrayList<Map>();
		list.add(map1);
		list.add(map2);
		
		
		Map<Object,Object> root = new HashMap<>();
		root.put("maplist", list);
		
		
		//生成HTML
		process("list_map.ftl",root,"list_map.html");
		
	}
	
	
	@Test
	public void testif() {
		
		List<String> list = new ArrayList<>();
		list.add("星期1");
		list.add("星期2");
		list.add("星期3");
		list.add("星期4");
		list.add("星期5");
		
		Map<Object,Object> root = new HashMap<>();
		root.put("list", list);
		
		
		//生成HTML
		process("test_if.ftl",root,"test_if.html");
		
	}
	@Test
	public void testDate() {
		
		Map<Object,Object> root = new HashMap<>();
		root.put("dt", new Date());

		//生成HTML
		process("date.ftl",root,"date.html");
		
	}
}
