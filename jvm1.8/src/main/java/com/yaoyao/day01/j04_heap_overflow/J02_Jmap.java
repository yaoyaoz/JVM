package com.yaoyao.day01.j04_heap_overflow;

import java.util.concurrent.TimeUnit;

/**
 * jmap：查看堆内存占用情况（只能查看某一个时刻）
 *  jmap -heap pid【可以通过jps命令查看pid】
 *
 * Created by yaoyao on 2020-05-06.
 */
public class J02_Jmap {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("1...");//控制台打印1...之后，执行jmap -heap pid，可以看到堆内存【Heap Usage:Eden Space:used】用了5MB
        TimeUnit.SECONDS.sleep(30);
        byte[] array = new byte[1024 * 1024 * 10];//10Mb
        System.out.println("2...");//控制台打印2...之后，执行jmap -heap pid，可以看到堆内存【Heap Usage:Eden Space:used】用了15MB
        TimeUnit.SECONDS.sleep(30);
        array = null;
        System.gc();//显示执行垃圾回收
        System.out.println("3...");//控制台打印3...之后，执行jmap -heap pid，可以看到堆内存【Heap Usage:Eden Space:used】用了0.6MB
        TimeUnit.SECONDS.sleep(30);
    }
}
