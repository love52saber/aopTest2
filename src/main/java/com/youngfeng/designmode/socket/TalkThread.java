package com.youngfeng.designmode.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class TalkThread extends Thread {

    private BufferedReader brConsole;
    private PrintStream ps;

    public TalkThread( BufferedReader brConsole,PrintStream ps) {
        super();
        this.brConsole = brConsole;
        this.ps = ps;
    }

    @Override
    public void run() {
        String temp = "";
        try {
            while ((temp = brConsole.readLine())!= null) {
                ps.println(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                brConsole.close();
                ps.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
