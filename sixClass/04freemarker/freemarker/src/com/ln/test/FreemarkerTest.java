package com.ln.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreemarkerTest {

	
	public static void main(String[] args) throws IOException, TemplateException {
		//���ö���
		Configuration conf = new Configuration();
		//ģ��·��
		String dir = "D:\\Users\\eclipse-workspace201801\\freemarker\\ftl\\";
	
		//����ģ��
		conf.setDirectoryForTemplateLoading(new File(dir));
	
		//��ȡģ��
		Template temp = conf.getTemplate("hello.ftl");
		//����
		Map<String,String> map =  new HashMap<String,String>();
		map.put("name", "world! ���");
		
		//�����
		//Writer out = new FileWriter(dir+"hello.html");
		Writer out =  new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(dir+"hello.html")),"UTF-8"));
		
		//����ҳ��
		temp.process(map, out);
		
		//�ر���Դ
		out.flush();
		out.close();
		
		System.out.println("�������");
	}
}
