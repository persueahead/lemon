package com.java.test;

import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//线程的常用的方法
public class JavaTest6 {
	public static void main(String[] args) throws IOException, InterruptedException {
		Timer  timer=	new Timer();
		timer.schedule(new MyTime(),new Date(),300);
		while(true) {
			Thread.sleep(1000);
			System.out.println(new Date());
			
		}
	}
}

class  MyTime extends TimerTask{
	public void run() {
		 System.out.println("不能乱来...................");
		//
	}
}