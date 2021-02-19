package com.youngfeng.designmode.proxy;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import com.youngfeng.designmode.proxy.Drivable;

import javax.lang.model.element.Modifier;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;

public class Proxy {
    // 这里需要修改为你自己期望的源码生成路径
    private static String PATH = "D:\\home";

    public static Object newProxyInstance(Drivable drivable) {
        try {
            MethodSpec drive = MethodSpec.methodBuilder("drive")
                    .addModifiers(Modifier.PUBLIC)
                    .addAnnotation(Override.class)
                    .addException(InterruptedException.class)
                    .addStatement("long start = $T.currentTimeMillis()", System.class)
                    .addStatement("drivable.drive()")
                    .addStatement("long end = $T.currentTimeMillis()", System.class)
                    .addStatement("$T.out.println(end - start)", System.class)
                    .build();

            FieldSpec fieldSpec = FieldSpec.builder(Drivable.class, "drivable")
                    .addModifiers(Modifier.PRIVATE)
                    .build();

            MethodSpec constructor = MethodSpec.constructorBuilder()
                    .addModifiers(Modifier.PUBLIC)
                    .addParameter(Drivable.class, "drivable")
                    .addStatement("this.$N = $N", "drivable", "drivable")
                    .build();

            TypeSpec driverTimeProxy = TypeSpec.classBuilder("DriverTimeProxy")
                    .addModifiers(Modifier.PUBLIC)
                    .addSuperinterface(Drivable.class)
                    .addMethod(drive)
                    .addMethod(constructor)
                    .addField(fieldSpec)
                    .build();

            JavaFile javaFile = JavaFile.builder("com.youngfeng.designmode.proxy", driverTimeProxy).build();

            File sourceFile = new File(PATH);
            javaFile.writeTo(sourceFile);

            // 编译生成的Java源码
            javax.tools.JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager fileManager = javaCompiler.getStandardFileManager(null, null, null);
            Iterable iterable = fileManager.getJavaFileObjects(PATH + "/com/youngfeng/designmode/proxy/DriverTimeProxy.java");
            javax.tools.JavaCompiler.CompilationTask task = javaCompiler.getTask(null, fileManager, null, null, null, iterable);
            task.call();
            fileManager.close();

            // 通过反射将源码加载到内存中
            URL[] urls = new URL[] {new URL("file:" + PATH)};
            URLClassLoader classLoader = new URLClassLoader(urls);
            Class cls = classLoader.loadClass("com.youngfeng.designmode.proxy.DriverTimeProxy");
            Constructor constr = cls.getConstructor(Drivable.class);
            Object obj = constr.newInstance(drivable);

            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
