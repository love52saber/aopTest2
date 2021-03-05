package com.youngfeng.designmode.socket2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPTalkClient02 {

    private Socket s;
    private BufferedReader consBr; //控制台输入流
    private PrintStream ps;    //网络输出流
    private BufferedReader br;

    public void conn(){
        try {
            s = new Socket("localhost",9000);
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            ps = new PrintStream(s.getOutputStream()); //写给服务端
            consBr = new BufferedReader(new InputStreamReader
                    (System.in));       //从控制台读取数据
            TalkThred4 tt = new TalkThred4(consBr,ps);
            tt.start();
            String temp1 = "";
            try {
                while ((temp1 = br.readLine())!= null) {
                    if (temp1.equalsIgnoreCase("quit2")) {
                        s.close();
                        System.out.println("服务端与你断开连接！");
    //                    break;
                    }
                    System.out.println("服务端传话：" +temp1);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(1);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                br.close();
                ps.close();
//                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TCPTalkClient02 tc = new TCPTalkClient02();
        System.out.println("客户端连接中·········");
        tc.conn();
    }
}
