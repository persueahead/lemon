package com.bj.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//客户端
public class TcpSckect {
     Socket socket=null;
     BufferedReader  bufferedReader=null;
     BufferedReader  bufferedReader1=null;
     PrintWriter  printWriter=null;
     public void name() throws IOException {
    	 try  {
    			System.out.println("等待发送信息.........................");
    			 //客户端的ip 和端口
    			socket= new Socket("127.0.0.1",6666);
    			//捕获发送给服务端的信息
    			bufferedReader=new BufferedReader(
    					new InputStreamReader(System.in));
    			
    		   String str=bufferedReader.readLine();
    			//将信息进行打包发送给服务
    		   printWriter =new PrintWriter(socket.getOutputStream());
    		   //接受服务端的信息
    		   bufferedReader1=new BufferedReader(
    				   new InputStreamReader(
    						   socket.getInputStream()));
    		   while(true
    				   ) {
    			   printWriter.println(str);
    			   printWriter.flush();
    			   //服务端发送的信息
    			   str=bufferedReader1.readLine();
    			   System.out.println("客户端收到"+str);
    			   //捕获信息发送给服务端
    			   str=bufferedReader.readLine();
    		   }
    		} catch (Exception e) {
    			// TODO: handle exception
    		  e.printStackTrace();
    		}finally {
    			bufferedReader1.close();
    			bufferedReader.close();
    			printWriter.close();
    			socket.close();
			}
	}
     
     
     public static void main(String[] args) {
  try {
	new TcpSckect().name();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
     
     
     
     
     
     
     }
	
	
	
}
