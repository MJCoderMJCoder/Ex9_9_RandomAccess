package com.randomaccess;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

public class RandomAccess {
	final static int DOUBLE_SIZE = 8; //���峣����double�������ֽ���
	
	void randomFileTest(String filename) throws IOException {
		RandomAccessFile rf = new RandomAccessFile(filename, "rw"); //������ļ�
		for (int i = 0; i < 5; i++)
			rf.writeDouble(i * 10.0); //д��5������;randomAccessFile��ʵ���˽ӿ�DaraI/O
		rf.seek(2 * DOUBLE_SIZE); //�ļ���дָ���������ļ���ʼ16�ֽڴ�������3�����ݿ�ʼ��
		rf.writeDouble(110.0001); //���ļ���дָ�봦д���µ����ݣ�������ԭ���ĵ�3������20.0
		rf.seek(0); //�ƶ��ļ���дָ�����ļ���ʼ
		for (int i = 0; i < 5; i++)
			System.out.println("Value " + i + "��" + rf.readDouble());
		rf.close();
	}
	public static void main(String[] args) {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String fileName = null;
		RandomAccess obj = null;
		try {
			//�������к���ڵ�ǰĿ¼����Ŀ��������һ����Ϊrandom.dat���ļ�
			System.out.print("����һ���ļ�����");
			fileName = stdin.readLine(); //�Ӽ��������ļ���
			obj = new RandomAccess();
			obj.randomFileTest(fileName); //��������ļ���д
		} catch (IOException e) {
			System.out.println("�ļ��Ҳ�����" + e);
			e.printStackTrace();
		}
	}

}
