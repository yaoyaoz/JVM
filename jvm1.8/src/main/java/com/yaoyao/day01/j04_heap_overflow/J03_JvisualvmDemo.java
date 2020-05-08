package com.yaoyao.day01.j04_heap_overflow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 演示查看对象个数
 *
 * 视化工具：jvisualvm【点了垃圾回收之后，还是有200多兆】
 * =>监视->堆dump=>查看到ArrayList里面有200多个Student
 *
 * Created by yaoyao on 2020-05-08.
 */
public class J03_JvisualvmDemo {
    public static void main(String[] args) throws InterruptedException {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            students.add(new Student());
        }
        TimeUnit.SECONDS.sleep(100);
    }
}

class Student {
    private byte[] big = new byte[1024 * 1024]; // 1MB
}
