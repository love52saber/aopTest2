package com.youngfeng.designmode.socket2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class TalkThred4 extends Thread{

    private BufferedReader consBr;
    private PrintStream ps;

    public TalkThred4( BufferedReader consBr,PrintStream ps) {
        super();
        this.consBr = consBr;
        this.ps = ps;
    }

    public void run() {
        String temp = null;
        try {
            while((temp = consBr.readLine())!=null){
                ps.println(temp);
            }
            System.out.println("客户端console读完了");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                consBr.close();
                ps.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
