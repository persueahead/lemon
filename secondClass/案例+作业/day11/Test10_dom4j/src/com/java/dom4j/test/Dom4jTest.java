package com.java.dom4j.test;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jTest {

	
	//解释XML文件
	public static void main(String[] args) throws DocumentException {
      //获取解析器
		SAXReader  sax=	new SAXReader();
		//获取doument文档对象
		Document doc=  sax.read("src/com/java/dom4j/xml/web.xml");
		//获取根元素
		Element  rootel=doc.getRootElement();
		System.out.println("根元素名称"+rootel.getName());
		System.out.println("根属性名称"+rootel.attributeValue("version"));
		//获取对应的子元素
	List<Element > list=	rootel.elements();
		for (Element element : list) {
			System.out.println(element.getName());
			
			if("servlet".equals(element.getName())) {
				//
			 Element  serEl=	element.element("servlet-name");
				System.out.println(serEl.getText());
				 Element  serclass=	element.element("servlet-class");
					System.out.println(serclass.getText());
			}
			//通过java代码获取数据连接 需要密码和账号
			//
		}
	
	
	
		
		
		
			
		
		
		
	}

}
