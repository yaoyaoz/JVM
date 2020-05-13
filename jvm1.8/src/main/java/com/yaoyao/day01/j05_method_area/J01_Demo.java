package com.yaoyao.day01.j05_method_area;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * 方法区：
 *
 * jdk1.8:
 * 演示元空间内存溢出：java.lang.OutOfMemoryError: Metaspace
 * 元空间默认使用的是系统内存，而且默认情况下没有设置上限
 * -XX:MaxMetaspaceSize=8m
 *
 * jdk1.6:
 * 演示永久代内存溢出：java.lang.OutOfMemoryError: PermGen space
 * -XX:MaxPermSize=8m
 *
 * 实际的方法区内存溢出的例子：
 * spring、mybatis动态加载类
 *
 * Created by yaoyao on 2020-05-13.
 */
public class J01_Demo extends ClassLoader {//可以用来加载类的二进制字节码
    public static void main(String[] args) {
        int j = 0;
        try {
            J01_Demo demo = new J01_Demo();
            for (int i = 0; i < 10000; i++, j++) {
                //ClassWriter作用是生成类的二进制字节码
                ClassWriter cw = new ClassWriter(0);
                //版本号，public，类名，包名，父类，接口
                cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Class" + i, null, "java/lang/Object", null);
                //返回byte[]
                byte[] code = cw.toByteArray();
                //执行了类的加载
                demo.defineClass("Class" + i, code, 0, code.length);//Class对象
            }
        } finally {
            System.out.println(j);
        }
    }
}
