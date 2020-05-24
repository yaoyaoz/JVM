package com.yaoyao.day01.j06_string_table;

import org.junit.Test;

import java.io.*;

/**
 * StringTable性能调优
 * -XX:StringTableSize=200000 -XX:+PrintStringTableStatistics
 *
 * 如果系统的常量个数特别多的话，可以适当把StringTableSize这个个数调得特别大
 *
 * Created by yaoyao on 2020-05-24.
 */
public class J07_StringTableTiaoYou {
    public static void main(String[] args) {
        BufferedReader bufr = null;
        try {
            String line = null;
            long start = System.currentTimeMillis();
            FileReader fr = new FileReader("demo.txt");
            bufr = new BufferedReader(fr);
            while ((line = bufr.readLine()) != null) {//bufr.readLine() 不包含任何行终止符
                if (line == null) {
                    break;
                }
                line.intern(); //放到串池里面
            }
            System.out.println("cost: " + (System.currentTimeMillis() - start) + "毫秒");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void writeToFile() {
        try {
            FileWriter fw = new FileWriter("demo.txt");
            for (int i = 0; i < 4800000; i++) {
                fw.write(i + " abcde\r\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
