package com.hit.java.UDPSocket2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/*
 * 基于UDP编程的Socket通信
 * 客户端：
 * 向服务器端发送数据步骤
 * 1、定义发送信息
 * 2、创建数据包DategramPacket，包含将要发送的信息
 * 3、创建DategramSocket对象，用来实现数据的发送
 * 4、发送数据
 * 接受服务器端的响应
 * 1、创建数据报，用于接受服务器发送的数据
 * 2、接受服务器发送的数据
 * 3、读取接收到的数据
 * 关闭资源
 */
public class Client {

	public static void main(String[] args) throws IOException {
		/*
		 * 向服务器端发送数据
		 */
		InetAddress address = InetAddress.getByName("localHost");
		int port = 8800;
		byte[] data = "用户名：respon ； 密码：123".getBytes();
		DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
		DatagramSocket socket = new DatagramSocket();
		socket.send(packet);
		/*
		 * 接受服务器端的响应
		 */
		byte[] data2 = new byte[1024];
		DatagramPacket packet2 = new DatagramPacket(data2, data.length);
		socket.receive(packet2);
		String reply = new String(data2,0,packet2.getLength());
		System.out.println("我是客户端，服务器端说：" + reply);
		socket.close();
	}

}
