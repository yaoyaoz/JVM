package com.yaoyao.day01.j06_string_table;

/**
 * StringTable面试题
 *
 * Created by yaoyao on 2020-05-04.
 */
public class J04_StringTableDemo {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        String s3 = "a" + "b";  //ab
        String s4 = s1 + s2;    //new String("ab")
        String s5 = "ab";
        String s6 = s4.intern();

        //问
        System.out.println(s3 == s4); //false
        System.out.println(s3 == s5); //true
        System.out.println(s3 == s6); //true

        String x2 = new String("c") + new String("d");  //new String("cd")
        String x1 = "cd";   //"cd"
        x2.intern();

        //问：如果调换了【最后两行代码】的位置呢，如果是jdk1.6呢
        System.out.println(x1 == x2); //false
    }
}
