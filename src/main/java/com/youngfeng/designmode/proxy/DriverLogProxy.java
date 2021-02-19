package com.youngfeng.designmode.proxy;

public class DriverLogProxy implements Drivable{

    private Drivable drivable;

    public DriverLogProxy(Drivable drivable) {
        this.drivable = drivable;
    }

    @Override
    public void drive() throws InterruptedException {
        System.out.println("Drive start...");
        drivable.drive();
        System.out.println("Drive complete...");
    }
}
