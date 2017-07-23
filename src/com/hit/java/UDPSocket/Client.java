package com.hit.java.UDPSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/*
 * ����UDP��̵�Socketͨ��
 * �ͻ��ˣ�
 * ��������˷������ݲ���
 * 1�����巢����Ϣ
 * 2���������ݰ�DategramPacket��������Ҫ���͵���Ϣ
 * 3������DategramSocket��������ʵ�����ݵķ���
 * 4����������
 * ���ܷ������˵���Ӧ
 * 1���������ݱ������ڽ��ܷ��������͵�����
 * 2�����ܷ��������͵�����
 * 3����ȡ���յ�������
 * �ر���Դ
 */
public class Client {

	public static void main(String[] args) throws IOException {
		/*
		 * ��������˷�����Ϣ
		 */
		byte[] data = "�û�����respon �� ���룺123".getBytes();
		InetAddress address = InetAddress.getByName("localHost");
		int port =8889;
		DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
		DatagramSocket socket = new DatagramSocket();
		socket.send(packet);
		/*
		 * ���շ���������Ӧ
		 */
		byte[] data2 = new byte[1024];
		DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
		socket.receive(packet2);
		String info = new String(data2);
		System.out.println("���ǿͻ��ˣ���������˵�� " + info);
		socket.close();
	}

}
