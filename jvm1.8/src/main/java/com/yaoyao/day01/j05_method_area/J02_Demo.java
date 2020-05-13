package com.yaoyao.day01.j05_method_area;

import com.sun.xml.internal.ws.org.objectweb.asm.ClassWriter;
import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

/**
 * jdk1.6:
 * 演示永久代内存溢出：java.lang.OutOfMemoryError: PermGen space
 * -XX:MaxPermSize=8m
 *
 * Created by yaoyao on 2020-05-13.
 */
public class J02_Demo extends ClassLoader {
    public static void main(String[] args) {
        int j = 0;
        try {
            J02_Demo demo = new J02_Demo();
            for (int i = 0; i < 20000; i++, j++) {
                //ClassWriter作用是生成类的二进制字节码
                ClassWriter cw = new ClassWriter(0);
                //版本号，public，类名，包名，父类，接口
                cw.visit(Opcodes.V1_6, Opcodes.ACC_PUBLIC, "Class" + i, null, "java/lang/Object", null);
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
