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
		 * 开一个线程，打开文件，（分段）读入内存，对关键字进行匹配，并打印出对应行和行号。然后将这些数据通过回调操作在主线程中打印出来。
		 * 然后在子线程运行结结束时通过修改flag，终止主线程。
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
		 //打开文件，取得文件的路径
		 File file = getFile();
		 try {
			//读取文本内容，并进行匹配
			readTxt(file);
		 } catch (Exception e) {
			 
		 }				
	}
	 
	 public static File getFile() {
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入一个txt文件路径和名称：");
			while(true) {
				String line = sc.nextLine();
				File file = new File(line);
				if(!file.exists()) {
					System.out.println("该文件路径不存在，请重新输入：");
				}else if (file.isDirectory()) {
					System.out.println("该路径为文件夹路径，请重新输入：");
				}else if (file.isFile() && file.getName().endsWith(".txt")) {
					return file;
				}else {
					System.out.println("该文件不是文本文件，请重新输入");
				}
			}
		}
	 
	 public static void readTxt(File file) throws Exception {
		 Scanner sc = new Scanner(System.in);
		 System.out.println("请输入一个关键字：");
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


 
