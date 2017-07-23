package com.hit.java.UDPSocket2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

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
		
		DatagramSocket socket = new DatagramSocket(8800);
		byte[] data = new byte[1024];
		System.out.println("===========�������Ѿ��������ȴ��ͻ��˷�������===========");
		while(true){
			DatagramPacket packet = new DatagramPacket(data, data.length);
			socket.receive(packet);//�˷����ڽ��յ�����֮ǰ��һֱ��������״̬
			ServerThread st = new ServerThread(socket,packet);
			st.start();
		}
		
	}

}
