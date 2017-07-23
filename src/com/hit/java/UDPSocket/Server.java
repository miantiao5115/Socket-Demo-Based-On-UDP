package com.hit.java.UDPSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * ����UDP��̵�Socketͨ��
 * �������ˣ�
 * ���ܿͻ�����Ϣ����
 * 1������DategramSocket,ָ���˿ں�
 * 2���������ݰ�DategramPacket���������տͻ��˷���������
 * 3�����տͻ��˷��͵�����
 * 4����ȡ����
 * ��Ӧ�ͻ��˲���
 * 1������ͻ��˵ĵ�ַ���˿ںš�����
 * 2���������ݱ���������Ӧ��������Ϣ
 * 3����Ӧ�ͻ���
 * �ر���Դ
 */
public class Server {

	public static void main(String[] args) throws IOException {
		/*
		 * ���տͻ�����Ϣ
		 */
		DatagramSocket socket = new DatagramSocket(8889);
		System.out.println("~~~~~~~~~~~~~~~�������Ѿ��������ȴ����ܿͻ�����Ϣ~~~~~~~~~~~~~~~");
		byte[] data = new byte[1024];
		DatagramPacket packet = new DatagramPacket(data, data.length);
		socket.receive(packet);
		String info = new String(data);
		System.out.println("���Ƿ������ˣ��ͻ���˵��" + info);
		/*
		 * ��Ӧ�ͻ���
		 */
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		byte[] data2 = "��ӭ����".getBytes();
		DatagramPacket packet2 = new DatagramPacket(data2,data2.length,address,port);
		socket.send(packet2);
		socket.close();
	}

}
