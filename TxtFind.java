package com.heima.work;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.Scanner;

 interface CallBack {
		public abstract void print(String str);
 }
 
 
 public class TxtFind implements CallBack{

		/**
		 * ��һ���̣߳����ļ������ֶΣ������ڴ棬�Թؼ��ֽ���ƥ�䣬����ӡ����Ӧ�к��кš�Ȼ����Щ����ͨ���ص����������߳��д�ӡ������
		 * Ȼ�������߳����н����ʱͨ���޸�flag����ֹ���̡߳�
		 * 
		 */
		
		public static void main(String[] args) {
			sonThread st = new sonThread(new TxtFind());
			st.start();
		}
		
		@Override
		public void print(String str) {
			System.out.println(str);
		}
 }
 
 
 class sonThread extends Thread {
	 private static CallBack cb;
	 
	 public sonThread(CallBack cb){
		 this.cb = cb;
	 }
	 
	 public void run() {
		 //���ļ���ȡ���ļ���·��
		 File file = getFile();
		 try {
			//��ȡ�ı����ݣ�������ƥ��
			readTxt(file);
		 } catch (Exception e) {
			 
		 }				
	}
	 
	 public static File getFile() {
			Scanner sc = new Scanner(System.in);
			System.out.println("������һ��txt�ļ�·�������ƣ�");
			while(true) {
				String line = sc.nextLine();
				File file = new File(line);
				if(!file.exists()) {
					System.out.println("���ļ�·�������ڣ����������룺");
				}else if (file.isDirectory()) {
					System.out.println("��·��Ϊ�ļ���·�������������룺");
				}else if (file.isFile() && file.getName().endsWith(".txt")) {
					return file;
				}else {
					System.out.println("���ļ������ı��ļ�������������");
				}
			}
		}
	 
	 public static void readTxt(File file) throws Exception {
		 Scanner sc = new Scanner(System.in);
		 System.out.println("������һ���ؼ��֣�");
		 String str = sc.nextLine();
		 LineNumberReader lnr = new LineNumberReader(new FileReader(file));	 
		 String line;
		 while((line = lnr.readLine()) != null) {
			 Thread.sleep(10);
			 if(line.contains(str)){				 
				 cb.print(line + " " + lnr.getLineNumber());
			 }
		 }
		 lnr.close();
	}
 }


 
