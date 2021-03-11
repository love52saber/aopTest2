package com.youngfeng.designmode.concurrent;

public class VolatileEx2 {

    int x = 0 ;
    boolean v = false;
    public void writer(){
        x = 42;
        v = true;
    }

    public void reader(){
        if (v == true){//此行如果判断v==false 则线程不安全
            // 这里x会是多少呢
            System.out.println("x is : " + x+"v is :"+ v);
        }
    }

    /**
     * jdk1.5之前，线程B读到的变量x的值可能是0，也可能是42，jdk1.5之后，变量x的值就是42了。
     * 原因是jdk1.5中，对volatile的语义进行了增强。来看一下happens-before规则在这段代码中的体现。
     *
     * 不可能是0，因为v==false  0无法输出
     * @param args
     */
    public static void main(String[] args) {
        while (true) {
            VolatileEx2 volatileExample = new VolatileEx2();
            int qw = 2;
            Runnable r2 = () -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                volatileExample.reader();
            };
            Thread th2 = new Thread(r2);
            Runnable r1 = () -> {
                //线程start()规则
                //主线程A启动线程B，线程B中可以看到主线程启动B之前的操作。
                // 也就是start() happens before 线程B中的操作。
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                volatileExample.writer();
            };
            Thread th1 = new Thread(r1);
            th1.start();
            th2.start();
//            th2.start();
//            th1.start();
        }
    }



}
