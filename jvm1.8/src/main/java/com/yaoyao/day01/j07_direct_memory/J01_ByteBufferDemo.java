package com.yaoyao.day01.j07_direct_memory;

import java.io.CharArrayReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 演示ByteBuffer作用
 *
 * directBuffer比io耗时少（但是我本地运行时间相差并不多）
 *
 * Created by yaoyao on 2020-05-25.
 */
public class J01_ByteBufferDemo {

    static final String FROM = "D:\\JVM视频.mp4";//一个有800多兆的文件
    static final String TO = "D:\\directBuffer.mp4";
    static final int _1Mb = 1024 * 1024;

    public static void main(String[] args) {
        io();
        directBuffer();
    }

    private static void directBuffer() {
        long start = System.nanoTime();
        try (FileChannel from = new FileInputStream(FROM).getChannel();
            FileChannel to = new FileOutputStream(TO).getChannel()) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(_1Mb);
            while (true) {
                int len = from.read(byteBuffer);
                if (len == -1) {
                    break;
                }
                byteBuffer.flip();
                to.write(byteBuffer);
                byteBuffer.clear();
            }
            long end = System.nanoTime();
            System.out.println("directBuffer用时：" + (end - start) / 1000_000.0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void io() {
        long start = System.nanoTime();
        try (FileInputStream from = new FileInputStream(FROM);
             FileOutputStream to = new FileOutputStream(TO)) {
            byte[] buf = new byte[_1Mb];
            while (true) {
                int len = from.read(buf);
                if (len == -1) {
                    break;
                }
                to.write(buf, 0, len);
            }
            long end = System.nanoTime();
            System.out.println("io用时：" + (end - start) / 1000_000.0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
