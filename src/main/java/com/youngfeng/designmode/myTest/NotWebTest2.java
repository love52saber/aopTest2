package com.youngfeng.designmode.myTest;

import com.youngfeng.designmode.proxy.Driver;
import org.junit.Test;

import java.io.*;

public class NotWebTest2 {

    public static void main(String[] args) {
        final Driver driver = new Driver();
//        driver = new Driver();
        String str = "124";

    }

    @Test
    public void test() {
        String str2 = new String("str") + new String("01");
        String str1 = "str01";
        String intern = str2.intern();
        System.out.println(str2 == str1); // false
        System.out.println(intern == str1);
    }

    @Test
    public void test2() {
        int h;
        String i = "12";
        int key = (i == null) ? 0 : (h = 2) ^ (h >>> 16);
        System.out.println(key);
    }

    @Test
    public void test3() throws IOException {
        File file = new File("D:\\home\\test.txt");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Parent parent = new Parent();
        oos.writeObject(parent);
        oos.flush();
    }

}
