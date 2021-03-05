package com.youngfeng.designmode.myTest;

public class Son extends Parent{

    String s1 = "2";

    public static void main(String[] args) {
        Parent parent = new Son();
        System.out.println(parent.s1);
    }
}
