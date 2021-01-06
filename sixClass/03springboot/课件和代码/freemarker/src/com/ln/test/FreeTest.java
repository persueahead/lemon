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
	 * ����HTMLҳ��
	 * 
	 * @param ftlname
	 *            ģ��
	 * @param map
	 *            ����
	 *            
	 * @param outname ���ҳ��         
	 */
	public void process(String ftlname, Map<Object, Object> map,String outname) {
		try {
			// ���ö���
			Configuration conf = new Configuration();
			// ģ��·��
			String dir = "D:\\Users\\eclipse-workspace201801\\freemarker\\ftl\\";

			// ����ģ��
			conf.setDirectoryForTemplateLoading(new File(dir));

			// ��ȡģ��
			Template temp = conf.getTemplate(ftlname);

			// �����
			Writer out = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(new File(dir + outname)), "UTF-8"));

			// ����ҳ��
			temp.process(map, out);

			// �ر���Դ
			out.flush();
			out.close();
			System.out.println("�������");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("����ʧ��");
		}

	}
	
	/**
	 * �������
	 */
	@Test
	public void testObj() {
		//����
		Person p = new Person();
		p.setId(1001);
		p.setName("����");
		p.setSex("��");
		
		Map<Object, Object> map = new HashMap<>();
		map.put("person", p);
		
		//����HTML
		process("person.ftl",map,"person.html");
		
	}
	
	/**
	 * ����list
	 */
	@Test
	public void testList() {
		List<Person> list = new ArrayList<>();
		
		for(int i = 0 ;i<10;i++) {
			Person p = new Person();
			p.setId(1000+i);
			p.setName("����"+i);
			p.setSex("��");
			list.add(p);
		}
		
		Map<Object, Object> map = new HashMap<>();
		map.put("plist", list);
		
		
		//����HTML
		process("person_list.ftl",map,"person_list.html");
		
	}
	
	@Test
	public void testMap() {
		Map<String,Object> map = new HashMap<>();
		map.put("id", 9527);
		map.put("name", "����");
		map.put("age", 18);
		
		Map<Object,Object> root = new HashMap<>();
		root.put("map", map);
		
		
		//����HTML
		process("map.ftl",root,"map.html");
		
	}
	
	
	@Test
	public void testListMap() {
		Map<String,Object> map1 = new HashMap<>();
		map1.put("id", 9527);
		map1.put("name", "����");
		map1.put("age", 18);
		
		
		Map<String,Object> map2 = new HashMap<>();
		map2.put("id", 1001);
		map2.put("name", "����");
		map2.put("age", 18);
		
		List<Map> list = new ArrayList<Map>();
		list.add(map1);
		list.add(map2);
		
		
		Map<Object,Object> root = new HashMap<>();
		root.put("maplist", list);
		
		
		//����HTML
		process("list_map.ftl",root,"list_map.html");
		
	}
	
	
	@Test
	public void testif() {
		
		List<String> list = new ArrayList<>();
		list.add("����1");
		list.add("����2");
		list.add("����3");
		list.add("����4");
		list.add("����5");
		
		Map<Object,Object> root = new HashMap<>();
		root.put("list", list);
		
		
		//����HTML
		process("test_if.ftl",root,"test_if.html");
		
	}
	@Test
	public void testDate() {
		
		Map<Object,Object> root = new HashMap<>();
		root.put("dt", new Date());

		//����HTML
		process("date.ftl",root,"date.html");
		
	}
}
