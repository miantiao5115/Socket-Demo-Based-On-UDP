package com.hit.java.UDPSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

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
		/*
		 * 接收客户端信息
		 */
		DatagramSocket socket = new DatagramSocket(8889);
		System.out.println("~~~~~~~~~~~~~~~服务器已经启动，等待接受客户端信息~~~~~~~~~~~~~~~");
		byte[] data = new byte[1024];
		DatagramPacket packet = new DatagramPacket(data, data.length);
		socket.receive(packet);
		String info = new String(data);
		System.out.println("我是服务器端，客户端说：" + info);
		/*
		 * 响应客户端
		 */
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		byte[] data2 = "欢迎您！".getBytes();
		DatagramPacket packet2 = new DatagramPacket(data2,data2.length,address,port);
		socket.send(packet2);
		socket.close();
	}

}
