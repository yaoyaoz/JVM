package com.yaoyao.day01.j02_stack_overflow;

/**
 * 演示栈内存溢出：java.lang.StackOverflowError
 *
 * 可以把栈内存设置小一点，看method1被调用的次数是不是会减少
 * -Xss256k
 *
 * Created by yaoyao on 2020-05-05.
 */
public class J01_StackOverflowErrorDemo {

    private static int count;

    public static void main(String[] args) {
        try {
            method1();
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println(count);
        }
    }

    private static void method1() {
        count++;
        method1();
    }
}
