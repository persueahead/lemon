package com.example.ln.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MyListener implements HttpSessionListener{



	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("session--创建");
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("session--销毁");
		
	}

}
