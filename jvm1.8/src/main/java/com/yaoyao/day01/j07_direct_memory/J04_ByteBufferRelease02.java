package com.yaoyao.day01.j07_direct_memory;

import sun.misc.Unsafe;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 * 直接内存通过Unsafe来回收的
 *
 * Unsafe一般是jdk来调用的
 *
 * 直接内存java.nio.ByteBuffer#allocateDirect(int)点进去，就可以看到调用了unsafe
 *
 *
 * Created by yaoyao on 2020-06-08.
 */
public class J04_ByteBufferRelease02 {
    static int _1Gb = 1024 * 1024 * 1024;

    public static void main(String[] args) throws IOException {
        Unsafe unsafe = getUnsafe();
        System.out.println("分配内存...");
        long base = unsafe.allocateMemory(_1Gb);
        unsafe.setMemory(base, _1Gb, (byte) 0);

        System.in.read();

        System.out.println("释放内存...");
        unsafe.freeMemory(base);

        System.in.read();
    }

    public static Unsafe getUnsafe() {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            Unsafe unsafe = (Unsafe) f.get(null);
            return unsafe;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
