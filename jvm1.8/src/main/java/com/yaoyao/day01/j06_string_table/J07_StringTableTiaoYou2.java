package com.yaoyao.day01.j06_string_table;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * StringTable性能调优2
 *
 * jvisualvm：抽样器->内存->占用字节那里有个百分比
 * 分别观察
 *  address.add(line);
 *  address.add(line.intern());
 *
 * Created by yaoyao on 2020-05-25.
 */
public class J07_StringTableTiaoYou2 {
    public static void main(String[] args) {
        List<String> address = new ArrayList<>();
        BufferedReader bufr = null;
        for (int i = 0; i < 10; i++) {
            try {
                String line = null;
                long start = System.currentTimeMillis();
                FileReader fr = new FileReader("demo.txt");
                bufr = new BufferedReader(fr);
                while ((line = bufr.readLine()) != null) {//bufr.readLine() 不包含任何行终止符
                    if (line == null) {
                        break;
                    }
//                    address.add(line);
                    address.add(line.intern()); //没看出什么效果样
                }
                System.out.println("cost: " + (System.currentTimeMillis() - start) + "毫秒");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
