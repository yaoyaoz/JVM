package com.yaoyao.day01.j01_string_table;

/**
 * 在命令行执行：javap -v J01_Demo01.class
 * =>
 * Code:
 *       stack=1, locals=4, args_size=1
 *          0: ldc           #2                  // String a
 *          2: astore_1
 *          3: ldc           #3                  // String b
 *          5: astore_2
 *          6: ldc           #4                  // String ab
 *          8: astore_3
 *          9: return
 *
 * Constant pool:
 *    #2 = String             #25            // a
 *    #3 = String             #26            // b
 *    #4 = String             #27            // ab
 *    #25 = Utf8               a
 *    #26 = Utf8               b
 *    #27 = Utf8               ab
 *
 *
 * 串池：StringTable[]     hashtable结构，不能扩容
 * 常量池中的信息，都会被加载到运行时常量池中，这时a、b、ab都是常量池中的符号，还没有变为java字符串对象
 * ldc #2 会把a符号变为“a”字符串对象
 * ldc #3 会把b符号变为“b”字符串对象
 * ldc #4 会把ab符号变为“ab”字符串对象
 *
 * Created by yaoyao on 2020-05-05.
 */
public class J01_Demo01 {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2;// new StringBuilder().append("a").append("b").toString()   new String("ab")
        String s5 = "a" + "b";

        /*
        s3在串池里面
        s4是new出来的，所以是false
         */
        System.out.println("s3 == s4: " + (s3 == s4));

        /*
        javac在编译器的优化，结果已经在编译器确定为ab，都是取的常量池里面的ab，所以为true
         */
        System.out.println("s3 == s5: " + (s3 == s5));
    }
}
