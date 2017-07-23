package com.hit.java.UDPSocket2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerThread extends Thread {
	DatagramSocket socket = null;
	DatagramPacket packet = null;
	public ServerThread(DatagramSocket socket,DatagramPacket packet){
		super();
		this.socket = socket;
		this.packet = packet;
	}
	public void run(){
		/*
		 * 接受客户端信息
		 */
		byte[] data = packet.getData();
		String info = new String(data);
		System.out.println("我是服务器，客户端说："+info);
		/*
		 * 响应客户端
		 */
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		byte[] data2 = "欢迎您~".getBytes();
		DatagramPacket  packet2 = new DatagramPacket(data2,data2.length,address,port);
		try {
			socket.send(packet2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
