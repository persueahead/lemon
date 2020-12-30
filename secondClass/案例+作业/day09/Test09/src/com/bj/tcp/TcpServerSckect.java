package com.bj.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//客户端
public class TcpServerSckect {
	ServerSocket  serverSocket=null;
     Socket socket=null;
     BufferedReader  bufferedReader=null;
     BufferedReader  bufferedReader1=null;
     PrintWriter  printWriter=null;
     public void name() throws IOException {
    	 try {
			
	
    	 //设置端口
    	 serverSocket=new ServerSocket(6666);
    	 System.out.println("等待请求.........");
    	 //设置监听客户端的请求
    	 socket=serverSocket.accept();
    	 //接受客户端的信息
    	 String str;
    	 bufferedReader =new BufferedReader(
    			 new InputStreamReader(
    					 socket.getInputStream()));
    	 //服务器返回给客户端的信息
    	 bufferedReader1=new BufferedReader(
    			 new InputStreamReader(
    					 System.in));
    	 //打包发送给客户端
    	 printWriter=new PrintWriter(socket.getOutputStream());
    	 while(true) {
    		 //接受客户端信息
    		 str=bufferedReader.readLine();
    		 System.out.println("服务端收到:"+str);
    		 //返回信息给客户端
    		 str=bufferedReader1.readLine();
    		 printWriter.println(str);
    		 printWriter.flush();
    	 }
    	 
    		} catch (Exception e) {
    			// TODO: handle exception
    		e.printStackTrace();
    		}finally {
    			bufferedReader1.close();
    			bufferedReader.close();
    			printWriter.close();
    			socket.close();	
    			serverSocket.close();	
			}
     }
     
     
     public static void main(String[] args) {

     
      try {
		new TcpServerSckect().name();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
     
     
     
     }
	
	
	
}
