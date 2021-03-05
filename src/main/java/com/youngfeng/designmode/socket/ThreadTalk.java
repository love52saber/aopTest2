package com.youngfeng.designmode.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

public class ThreadTalk extends Thread {

    private Socket s;
    private BufferedReader br;
    private BufferedReader brConsole;
    private PrintStream ps;
    private InetAddress ip;

    public ThreadTalk(Socket s) {
        this.s = s;
    }

    public void run() {
        try {
            br = new BufferedReader(new InputStreamReader(s
                    .getInputStream()));// 从客户端读取数据
            brConsole = new BufferedReader(
                    new InputStreamReader(System.in)); // 从服务端读取数据
            ps = new PrintStream(s.getOutputStream()); // 向客户端输入数据
            //获得客户端ip地址
            ip = s.getInetAddress();
            ps.println("服务端传话：欢迎访问聊天服务器！");
            TalkThread tat = new TalkThread(brConsole, ps);
            tat.start(); // 这里用到多线程 实现双方互相对话
            String temp = "";
            while ((temp = br.readLine()) != null) {
                if (temp.equalsIgnoreCase("quit")) {
                    System.out.println("与第" + ip+ "断开连接！");
                    ps.println("断开连接，欢迎下次访问！");
                    break;
                }
                System.out.println( ip+"说：" + temp);
            }
            System.out.println(1);
        } catch (IOException e) {
            if("Connection reset".equals(e.getMessage())){
                System.out.println("客户端异常退出！");
            }
        }finally {
            try {
                br.close();
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(ip+"已断开链接！");
        }
    }
}
