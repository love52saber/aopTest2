package com.youngfeng.designmode.proxy;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException {
        Driver driver = new Driver();
//
//        DriverTimeProxy driverTimeProxy = new DriverTimeProxy(driver);
//        DriverLogProxy driverLogProxy = new DriverLogProxy(driverTimeProxy);
//
//        driverLogProxy.drive();
        Drivable drivable = (Drivable) Proxy.newProxyInstance(driver);
        drivable.drive();
    }
}
