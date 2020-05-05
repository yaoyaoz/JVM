package com.yaoyao.day01.j01_thread_safe;

/**
 * Created by yaoyao on 2020-05-05.
 */
public class J03_Demo {

    public static void main(String[] args) {

    }

    /*
    线程安全
     */
    public static void m1() {
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append(2);
        sb.append(3);
        System.out.println(sb.toString());
    }

    /*
    线程不安全
    因为返回的sb可能会被其他线程修改
     */
    public static StringBuilder m2() {
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append(2);
        sb.append(3);
        return sb;
    }

}
