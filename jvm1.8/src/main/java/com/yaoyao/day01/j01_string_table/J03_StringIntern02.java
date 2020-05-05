package com.yaoyao.day01.j01_string_table;

/**
 * String的intern方法
 *
 * Created by yaoyao on 2020-05-05.
 */
public class J03_StringIntern02 {
    public static void main(String[] args) {
        String x = "ab";
        String s = new String("a") + new String("b");// new String("ab")

        /*
        此时，串池里面已经有ab了，所以s不会被放入串池，s==x为false
        返回的s2为串池里面的ab，所以s2==x为true
         */
        String s2 = s.intern();
        System.out.println(s == x);
        System.out.println(s2 == x);
    }
}
