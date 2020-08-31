package com.cmh.newcoder;

import org.junit.jupiter.api.Test;

/**
 * @Author: hmc
 * @Date: 2020/8/31 下午3:52
 */
public class OpCastTest {

    /**
     * 知识点：Java运算符：数值类型转换
     * 题目：
     * 第一题：short s1 = 1; s1 = s1 + 1;有什么错？
     * 第二题：short s1 = 1; s1 += 1;有什么错？
     * 第三题：第三题：short s1=1,s2=1;short s3=s1+s2;有什么错？
     */

    @Test
    public void testAutoBoxingDeboxing() {
        short s1 = 1;
//        s1 = s1 +1;//Required Type:short ;Provied type = int
        s1 = (short) (s1 + 1);//1默认是int类型，和short类型运算，自动会把short向上转型为int，相加后的值也为int,想要赋值给short，需要强制向下转型
        s1 += 1;
        short s2 = 1;
        short s3 = 1;
        s3 = (short) (s1 + s2);//不转换也会报错:Required Type:short ;Provied type = int 理由：存在溢出可能，所以确保安全，要手动强制向下转型

        //上面s3，如果结果超出shor的Max的值呢？

        /**
         * 验证溢出时候如何计算
         *  short   MIN_VALUE = -32768 (-2^15)
         *  MAX_VALUE = 32767 (2^15 -1)
         */
        short s4, s5, s6;
        s4 = 32767;
        s5 = 32767;
        //s6 = s4 + s5;//报错：Required short,Provied int(因为自动向上转型了)
        s6 = (short) (s4 + s5);
        System.out.println("两个short类型相加，需要强制转换，如果超出short范围后的值是：s6:\t" + s6);//结果是-2?why?
        System.out.println(s4 + s5);//65534
    }

    /**
     * 总结：
     * 1、数值类型之间的合法转换。
     *     1）E1 op E2 (op标识operation，运算符的意思)，存在一个范围较大的，会自动向上转型；
     *     2）byte->short ->int > long
     *        float -> double
     *        char -> int 这三组不会出现数字丢失现象。(见图一)
     *
     *        int -> float
     *        long -> double 表示可能有精度损失的转换。
     *
     * 2、复合赋值表达式中会自动地将所有执行结果转型为其左侧变量的类型。
     * eg:复合赋值(E1 op = E2)等价于简单赋值(E1 = (T)(E1) op (E2))，具体到s1 += 1就是程序内部会默认按照s1的类型转换一下，所以不会报错。
     *
     * 3、如果试图将一个数值从一种类型强制转换为另一种类型，而且又超出了目标类型的标识范围，结果
     * 就会截断成一个完全不同的值。类似 s6 = (short)(s4+s5)
     *
     *
     */
}
