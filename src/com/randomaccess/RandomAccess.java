package com.randomaccess;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

public class RandomAccess {
	final static int DOUBLE_SIZE = 8; //定义常量，double型数据字节数
	
	void randomFileTest(String filename) throws IOException {
		RandomAccessFile rf = new RandomAccessFile(filename, "rw"); //打开随机文件
		for (int i = 0; i < 5; i++)
			rf.writeDouble(i * 10.0); //写入5个数据;randomAccessFile类实现了接口DaraI/O
		rf.seek(2 * DOUBLE_SIZE); //文件读写指针移至距文件开始16字节处，即第3个数据开始处
		rf.writeDouble(110.0001); //在文件读写指针处写入新的数据，覆盖了原来的第3个数据20.0
		rf.seek(0); //移动文件读写指针至文件开始
		for (int i = 0; i < 5; i++)
			System.out.println("Value " + i + "：" + rf.readDouble());
		rf.close();
	}
	public static void main(String[] args) {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String fileName = null;
		RandomAccess obj = null;
		try {
			//程序运行后会在当前目录（项目）中生成一个名为random.dat的文件
			System.out.print("输入一个文件名：");
			fileName = stdin.readLine(); //从键盘输入文件名
			obj = new RandomAccess();
			obj.randomFileTest(fileName); //测试随机文件读写
		} catch (IOException e) {
			System.out.println("文件找不到：" + e);
			e.printStackTrace();
		}
	}

}
