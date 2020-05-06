package com.yaoyao.day01.j03_thread_analysis;

import java.util.concurrent.TimeUnit;

/**
 * 案例2：程序运行很长时间没有结果（分析发现死锁了）
 *
 * linux：
 * 1、后台运行
 *  javac -d . J02_Deadlock.java
 *  nohup java com.yaoyao.day01.j03_thread_analysis.J02_Deadlock &
 * 2、jstack pid
 *  jstack 12505
 *  =>
 *  Java stack information for the threads listed above:
 * ===================================================
 * "Thread-1":
 * 	at com.yaoyao.day01.j03_thread_analysis.J02_Deadlock.lambda$main$1(J02_Deadlock.java:56)
 * 	- waiting to lock <0x000000068645b6f0> (a com.yaoyao.day01.j03_thread_analysis.A)
 * 	- locked <0x000000068645cc58> (a com.yaoyao.day01.j03_thread_analysis.B)
 * 	at com.yaoyao.day01.j03_thread_analysis.J02_Deadlock$$Lambda$2/834600351.run(Unknown Source)
 * 	at java.lang.Thread.run(Thread.java:745)
 * "Thread-0":
 * 	at com.yaoyao.day01.j03_thread_analysis.J02_Deadlock.lambda$main$0(J02_Deadlock.java:47)
 * 	- waiting to lock <0x000000068645cc58> (a com.yaoyao.day01.j03_thread_analysis.B)
 * 	- locked <0x000000068645b6f0> (a com.yaoyao.day01.j03_thread_analysis.A)
 * 	at com.yaoyao.day01.j03_thread_analysis.J02_Deadlock$$Lambda$1/424058530.run(Unknown Source)
 * 	at java.lang.Thread.run(Thread.java:745)
 *
 * Created by yaoyao on 2020-05-06.
 */
public class J02_Deadlock {

    static A a = new A();
    static B b = new B();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (a) {
                System.out.println("====>a");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b) {
                    System.out.println("我获得了a和b");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (b) {
                System.out.println("====>b");
                synchronized (a) {
                    System.out.println("我获得了b和a");
                }
            }
        }).start();
    }
}

class A {}
class B {}