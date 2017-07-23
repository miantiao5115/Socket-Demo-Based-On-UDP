package com.hit.java.UDPSocket2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
 * 基于UDP编程的Socket通信
 * 服务器端：
 * 接受客户端信息步骤
 * 1、创建DategramSocket,指定端口号
 * 2、创建数据包DategramPacket，用来接收客户端发来的数据
 * 3、接收客户端发送的数据
 * 4、读取数据
 * 响应客户端步骤
 * 1、定义客户端的地址、端口号、数据
 * 2、创建数据报，包含响应的数据信息
 * 3、响应客户端
 * 关闭资源
 */
public class Server {

	public static void main(String[] args) throws IOException {
		
		DatagramSocket socket = new DatagramSocket(8800);
		byte[] data = new byte[1024];
		System.out.println("===========服务器已经启动，等待客户端发送数据===========");
		while(true){
			DatagramPacket packet = new DatagramPacket(data, data.length);
			socket.receive(packet);//此方法在接收到数据之前，一直处于组塞状态
			ServerThread st = new ServerThread(socket,packet);
			st.start();
		}
		
	}

}
