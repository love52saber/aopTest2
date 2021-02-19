package com.youngfeng.designmode.proxy2;

public class DriverTimeProxy2 extends Driver2 {

    private Driver2 driver2;

    public DriverTimeProxy2(Driver2 driver2) {
        this.driver2 = driver2;
    }

    @Override
    public void drive() throws InterruptedException {
        long start = System.currentTimeMillis();
        driver2.drive();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
