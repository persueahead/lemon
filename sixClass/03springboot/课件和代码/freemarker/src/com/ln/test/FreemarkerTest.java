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
		//配置对象
		Configuration conf = new Configuration();
		//模版路径
		String dir = "D:\\Users\\eclipse-workspace201801\\freemarker\\ftl\\";
	
		//倒入模版
		conf.setDirectoryForTemplateLoading(new File(dir));
	
		//获取模版
		Template temp = conf.getTemplate("hello.ftl");
		//数据
		Map<String,String> map =  new HashMap<String,String>();
		map.put("name", "world! 你好");
		
		//输出流
		//Writer out = new FileWriter(dir+"hello.html");
		Writer out =  new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(dir+"hello.html")),"UTF-8"));
		
		//生成页面
		temp.process(map, out);
		
		//关闭资源
		out.flush();
		out.close();
		
		System.out.println("生成完成");
	}
}
