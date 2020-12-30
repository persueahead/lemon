package com.bj.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpSocket {

	
	//接收方
	public static void main(String[] args) throws IOException {
		DatagramSocket  socket=new DatagramSocket(5555);//指定端口
		DatagramPacket packet=new DatagramPacket(new byte[1024], 1024);
		while(true) {
			//接受数据
			socket.receive(packet);
			byte[] arr= packet.getData();//获取数据
			System.out.println(arr.length);
			System.out.println("字节数"+packet.getLength());
			System.out.println("IP"+packet.getAddress().getHostAddress());
			System.out.println("端口"+packet.getPort());
		}
		
		
		
		
		
	}
}
