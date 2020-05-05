package com.yaoyao.day01.j01_thread_safe;

/**
 * 线程不安全
 *
 * Created by yaoyao on 2020-05-05.
 */
public class J01_Demo {
    /*
    m1方法是线程不安全的：因为StringBuilder sb变量可以从外面传入，
    运行main方法，得到的sb的值，aaa的个数可能会小于100000*2
     */
    public static void main(String[] args) throws InterruptedException {
        StringBuilder sb = new StringBuilder();
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
        System.out.println("StringBuilder: " + sb.toString() + ",end");
    }

    public static void m1(StringBuilder sb) {
        for (int i = 1; i <= 100000; i++) {
            sb.append("aaa,");
        }
    }
}
