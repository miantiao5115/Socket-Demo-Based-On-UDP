package com.hit.java.UDPSocket2;

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
		 * ��������˷�������
		 */
		InetAddress address = InetAddress.getByName("localHost");
		int port = 8800;
		byte[] data = "�û�����respon �� ���룺123".getBytes();
		DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
		DatagramSocket socket = new DatagramSocket();
		socket.send(packet);
		/*
		 * ���ܷ������˵���Ӧ
		 */
		byte[] data2 = new byte[1024];
		DatagramPacket packet2 = new DatagramPacket(data2, data.length);
		socket.receive(packet2);
		String reply = new String(data2,0,packet2.getLength());
		System.out.println("���ǿͻ��ˣ���������˵��" + reply);
		socket.close();
	}

}
