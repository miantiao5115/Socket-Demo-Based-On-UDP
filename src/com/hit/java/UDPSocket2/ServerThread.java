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
		 * ���ܿͻ�����Ϣ
		 */
		byte[] data = packet.getData();
		String info = new String(data);
		System.out.println("���Ƿ��������ͻ���˵��"+info);
		/*
		 * ��Ӧ�ͻ���
		 */
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		byte[] data2 = "��ӭ��~".getBytes();
		DatagramPacket  packet2 = new DatagramPacket(data2,data2.length,address,port);
		try {
			socket.send(packet2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
