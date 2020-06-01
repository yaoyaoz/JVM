package com.yaoyao.day01.j07_direct_memory;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * 直接内存：释放
 *
 * 运行main方法之后，打开任务管理器，按内存大小排序，观察
 *
 * 执行到了“分配完毕...”之后，就有一个占用1G内存的java进程，
 * 回车之后执行释放，1G的java进程会被释放调。
 *
 * 直接内存点释放原理见后面
 *
 * Created by yaoyao on 2020-06-01.
 */
public class J03_ByteBufferRelease01 {

    static int _1Gb = 1024 * 1024 * 1024;

    public static void main(String[] args) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_1Gb);
        System.out.println("分配完毕...");
        System.in.read();
        System.out.println("开始释放...");
        byteBuffer = null;
        System.gc();
        System.in.read();
    }
}
