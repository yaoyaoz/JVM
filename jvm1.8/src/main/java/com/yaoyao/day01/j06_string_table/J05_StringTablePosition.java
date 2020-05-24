package com.yaoyao.day01.j06_string_table;

import java.util.ArrayList;
import java.util.List;

/**
 * 演示StringTable位置
 *
 * 在jdk8下设置：
 * -Xmx10m      java.lang.OutOfMemoryError: GC overhead limit exceeded
 * -Xmx10m -XX:-UseGCOverheadLimit【+UseGCOverheadLimit：+代表开，-代码关】      java.lang.OutOfMemoryError: Java heap space
 *
 * 在jdk6下设置：
 * -XX:MaxPermSize=10m  java.lang.OutOfMemoryError: PermGen space【老年代】
 *
 * Created by yaoyao on 2020-05-24.
 */
public class J05_StringTablePosition {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        try {
            for (int j = 0; j < 260000; j++) {
                list.add(String.valueOf(j).intern());
                i++;
            }
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println(i);
        }
    }
}
