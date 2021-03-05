package com.youngfeng.designmode.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IoTest {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(
                new InputStreamReader(System.in));
        while (bf.read() != -1) {
            System.out.println("11111");
        }
    }

    @Test
    public void test() throws IOException {

    }
}
