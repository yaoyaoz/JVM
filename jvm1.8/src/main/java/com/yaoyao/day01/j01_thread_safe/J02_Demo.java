package com.yaoyao.day01.j01_thread_safe;

/**
 * StringBuffer是线程安全的
 *
 * Created by yaoyao on 2020-05-05.
 */
public class J02_Demo {
    public static void main(String[] args) throws InterruptedException {
        StringBuffer sb = new StringBuffer();
        Thread t1 = new Thread(() -> {
            m1(sb);
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            m1(sb);
        });
        t2.start();

        t1.join();
        t2.join();
        System.out.println("StringBuffer: " + sb.toString() + ",end");
    }

    public static void m1(StringBuffer sb) {
        for (int i = 1; i <= 100000; i++) {
            sb.append("aaa,");
        }
    }
}
