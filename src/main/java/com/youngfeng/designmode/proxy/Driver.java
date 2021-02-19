package com.youngfeng.designmode.proxy;

public class Driver implements Drivable {

    @Override
    public void drive() {
        System.out.println("I'm driving...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Drive completed...");
    }
}
