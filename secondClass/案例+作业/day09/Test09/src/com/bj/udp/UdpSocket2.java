package com.bj.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

//tcp
public class UdpSocket2 {

	
	//发送方
	public static void main(String[] args) throws IOException {
		  //创建输入的对象
		Scanner scanner= new Scanner(System.in);
		//创建Sockect
		DatagramSocket  socket=	new DatagramSocket();
		
		while (true) {
			//获取控制台的数据
		String str=	scanner.nextLine();
			if("esc".equals(str)){
				break;
			}
		
			//创建一个集装箱
			//参数1。发送的数据转换数组，参数2长度 参数3 IP   参数4端口 
			DatagramPacket packet=new DatagramPacket(str.getBytes(),
					str.getBytes().length,
					InetAddress.getByName("127.0.0.1"),
					5555);
			
			socket.send(packet);//发送数据
			
		}
		socket.close();
		
		
		
		
	}
}
