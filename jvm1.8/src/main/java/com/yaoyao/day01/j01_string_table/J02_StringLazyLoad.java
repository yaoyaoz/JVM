package com.yaoyao.day01.j01_string_table;

/**
 * 延迟字符串字面量也是【延迟】成为对象的
 *
 * 通过idea的memory工具可以查询字符串个数
 *
 * Created by yaoyao on 2020-05-05.
 */
public class J02_StringLazyLoad {
    public static void main(String[] args) {
        int x = args.length;
        System.out.println();

        System.out.println("1");    //字符串个数：2185
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        System.out.println("7");
        System.out.println("8");
        System.out.println("9");
        System.out.println("0");

        System.out.println("1");    //字符串个数：2195
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        System.out.println("7");
        System.out.println("8");
        System.out.println("9");
        System.out.println("0");    //字符串个数：2195

        System.out.println(x);
    }
}
