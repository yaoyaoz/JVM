package com.yaoyao.day01.j07_direct_memory;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * 演示直接内存-内存溢出
 *
 * 疑问：视频里面报的异常是Direct buffer memory，
 * 但是我这边报的是java.lang.OutOfMemoryError: Java heap space
 *
 * Created by yaoyao on 2020-05-27.
 */
public class J02_ByteBuffer {

    static int _100Mb = 1024 * 1024 * 100;

    public static void main(String[] args) {
        List<ByteBuffer> list = new ArrayList<>();
        int i = 0;
        try {
            while (true) {
                ByteBuffer byteBuffer = ByteBuffer.allocate(_100Mb);
                list.add(byteBuffer);
                i++;
            }
        } finally {
            System.out.println(i);
        }
    }

}
