/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: AbstractProducer
 * Author:   coderlong
 * Date:     2019/4/14 19:22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.coderlong.kafka.producer;

import java.util.LinkedList;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author coderlong
 * @create 2019/4/14
 * @since 1.0.0
 */
public class AbstractProducer<T, U> {
    public static void main(String[] args) {
        String s = "()()()";
        //((()))
        LinkedList<Character> linkedList = new LinkedList<>();
        int count = 0;
        StringBuilder builder = new StringBuilder();
        String res = "";
        for (char c : s.toCharArray()) {
            if (c == '(') {
//                linkedList.add(c);
                builder.append("(");
                count++;
            } else {
                builder.append(")");
                count--;
                if (count == 0) {
                    if (builder.length() > 2) {
                        res += builder.toString().substring(1, builder.length() - 1);
                    }
                    builder = new StringBuilder();
                }
            }
        }
        System.out.println(res);
    }
}