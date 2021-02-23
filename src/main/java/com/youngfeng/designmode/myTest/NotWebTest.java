package com.youngfeng.designmode.myTest;

public class NotWebTest {

    public static void main(String[] args) {
        final String s1 = "123";
        System.out.println(s1.hashCode());
        changeStr(s1);
        System.out.println(s1.hashCode());
    }

    private static void changeStr(String temp) {
        System.out.println(temp.hashCode());
        temp = "456";
        System.out.println(temp.hashCode());
    }
}
