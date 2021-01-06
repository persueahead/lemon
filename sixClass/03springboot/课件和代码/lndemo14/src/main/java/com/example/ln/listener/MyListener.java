package com.example.ln.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

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
