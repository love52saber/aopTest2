package com.youngfeng.designmode.myTest;

public class DeadLockDemo implements Runnable {
    public boolean flag = false;
    public void run() {
        if (!flag) {
            while (true) {
                synchronized (this) {
                    synchronized (DeadLockDemo.class) {
                        System.out.println("true");
                    }
                }
            }
        } else {
            while (true) {
                synchronized (DeadLockDemo.class) {
                    synchronized (this) {
                        System.out.println("false");
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        DeadLockDemo dld = new DeadLockDemo();
        Thread t1 = new Thread(dld);
        Thread t2 = new Thread(dld);
        t1.start();
        try{
            Thread.sleep(10);
        }catch(InterruptedException e){

        }
        dld.flag=true;
        t2.start();
    }
}