package com.youngfeng.designmode.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTalkServer02 {

    public void talk() {
        try {
            ServerSocket ss = new ServerSocket(9000);
            System.out.println("聊天服务器开启···");
            Socket s = null;
            while ((s = ss.accept()) != null) {
                System.out.println(s.getInetAddress()+"朋友来访中-----");
                ThreadTalk tt = new ThreadTalk(s);
                tt.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TCPTalkServer02 talk = new TCPTalkServer02();
        talk.talk();
    }

}
