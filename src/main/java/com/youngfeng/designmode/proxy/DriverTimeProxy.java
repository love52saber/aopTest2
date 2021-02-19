package com.youngfeng.designmode.proxy;

public class DriverTimeProxy implements Drivable{

    private Drivable drivable;

    public DriverTimeProxy(Drivable drivable) {
        this.drivable = drivable;
    }

    @Override
    public void drive() throws InterruptedException {
        long start = System.currentTimeMillis();
        drivable.drive();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
