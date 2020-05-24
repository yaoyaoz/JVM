package com.yaoyao.day01.j06_string_table;

/**
 * String的intern方法
 *
 * Created by yaoyao on 2020-05-05.
 */
public class J03_StringIntern01 {
    public static void main(String[] args) {
        String s = new String("a") + new String("b");// new String("ab")
        /*
        此时：
        堆     new String("a")     new String("b")     new String("ab")
        串池里面：["a", "b"]
         */

        /*
        将这个字符串对象尝试放入串池，如果有则不会放入，如果没有则放入串池，
        会把串池中的对象返回
         */
        String s2 = s.intern();
        /*
        此时串池里面没有ab，所有会被放入串池并返回，所有s=="ab"为true，返回的s2也是串池里面的ab，所以也为true
         */
        System.out.println(s == "ab");//jdk1.6为false，因为如果串池中没有，则会把此对象复制一份，放入串池，所以s=="ab"为false
        System.out.println(s2 == "ab");
    }
}
