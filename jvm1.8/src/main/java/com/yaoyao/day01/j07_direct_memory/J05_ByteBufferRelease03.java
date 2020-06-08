package com.yaoyao.day01.j07_direct_memory;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * -XX:+DisableExplicitGC 禁用显示回收直接内存。
 * 加上之后，执行System.gc()之后，直接内存不会被释放
 *
 * 执行到"开始释放..."的时候，直接内存也不会释放
 *
 * Created by yaoyao on 2020-06-08.
 */
public class J05_ByteBufferRelease03 {
    static int _1Gb = 1024 * 1024 * 1024;

    public static void main(String[] args) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_1Gb);
        System.out.println("分配完毕...");
        System.in.read();
        System.out.println("开始释放...");
        byteBuffer = null;
        System.gc(); //显示的垃圾回收，Full GC
        System.in.read();
    }
}
