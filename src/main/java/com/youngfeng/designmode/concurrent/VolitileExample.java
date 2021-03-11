package com.youngfeng.designmode.concurrent;

public class VolitileExample {
    int  a = 0;
    volatile boolean flag = false;
    public void writer() {
        a = 1; // 1
        flag = true; // 2
    }
    public void reader() {
        if (flag) { // 3
            int i = a; // 4
//               ……
        }
    }
}
