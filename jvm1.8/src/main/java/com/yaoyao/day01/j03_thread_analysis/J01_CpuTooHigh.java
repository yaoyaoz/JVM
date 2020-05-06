package com.yaoyao.day01.j03_thread_analysis;

/**
 * 案例1：cpu占用过高诊断
 *
 * linux:
 * 1、后台运行
 *  javac -d . J01_CpuTooHigh.java
 *  nohup java com.yaoyao.day01.j03_thread_analysis.J01_CpuTooHigh &    （不加nohup，只在最后加一个&，好像也会在后台运行）
 * 2、用top定位哪个进程对cpu的占用过高：pid 20445
 * 3、用ps命令进一步定位是哪个线程引起的cpu占用过高，pid-进程，tid-线程：ps H -eo pid,tid,%cpu | grep 进程id
 *  ps H -eo pid,tid,%cpu | grep 20445  =>tid为20452(10进制)->4FE4(16进制)
 * 4、根据线程id[10进制 20452]定位到有问题的线程[16进制 4FE4]，进一步定位到问题代码的源码行号：jstack pid
 *  jstack 20445
 *  =>
 *  "main" #1 prio=5 os_prio=0 tid=0x00007f07ac008800 nid=0x4fe4 runnable [0x00007f07b56fc000]
 *    java.lang.Thread.State: RUNNABLE  【RUNNABLE表示正在占用时间片】
 * 	at com.yaoyao.day01.j03_thread_analysis.J01_CpuTooHigh.main(J01_CpuTooHigh.java:10)
 *
 * Created by yaoyao on 2020-05-06.
 */
public class J01_CpuTooHigh {
    public static void main(String[] args) {
        while (true) {

        }
    }
}
