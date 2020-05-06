package com.yaoyao.day01.j04_heap_overflow;

import java.util.ArrayList;
import java.util.List;

/**
 * 演示堆内存溢出：java.lang.OutOfMemoryError: Java heap space
 * -Xmx8m
 *
 * Created by yaoyao on 2020-05-06.
 */
public class J01_OutOfMemoryErrorDemo {
    public static void main(String[] args) {
        int i = 0;
        try {
            List<String> list = new ArrayList<>();
            String a = "hello";
            while (true) {
                list.add(a);//hello, hellohello, hellohellohello, ...
                a += a; //hellohellohellohello
                i++;
            }
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println(i);
        }
    }
}
