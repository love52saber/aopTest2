package com.youngfeng.designmode.proxy2;

import com.youngfeng.designmode.proxy.Drivable;

public class Driver2 {

    public void drive() throws InterruptedException {
        System.out.println("I'm driving...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Drive completed...");
    }
}
