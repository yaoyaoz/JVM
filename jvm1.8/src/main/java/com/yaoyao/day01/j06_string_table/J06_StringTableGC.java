package com.yaoyao.day01.j06_string_table;

/**
 * 演示StringTable垃圾回收
 * -Xmx10m -XX:+PrintStringTableStatistics -XX:+PrintGCDetails -verbose:gc
 * 加了这个设置会打印垃圾回收的信息
 *
 * Created by yaoyao on 2020-05-24.
 */
public class J06_StringTableGC {
    public static void main(String[] args) {
        int i = 0;
        try {

            //没加for循环的时候：StringTable statistics:   Number of entries:1740

            //加了for循环的时候：StringTable statistics:   Number of entries:1840
//            for (int j = 0; j < 100; j++) {
//                String.valueOf(j).intern();
//                i++;
//            }

            //[GC (Allocation Failure) [PSYoungGen: 2048K->488K(2560K)] 2048K->656K(9728K), 0.0007972 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
            for (int j = 0; j < 10000; j++) {
                String.valueOf(j).intern();
                i++;
            }

        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println(i);
        }
    }
}
