/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TestUnSafe
 * Author:   coderlong
 * Date:     2019/4/20 14:45
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.coderlong.kafka.CAS;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author coderlong
 * @create 2019/4/20
 * @since 1.0.0
 */
public class TestUnSafe {
    private static final String A = "";
    static Unsafe UNSAFE;
    static long stateOffset;
    private volatile long state = 0;
    static {
        try {
            Field field =  Unsafe.class.getDeclaredField("theUnsafe");
            // 设置为可以存取
            field.setAccessible(true);
            UNSAFE = (Unsafe) field.get(null);
            stateOffset = UNSAFE.objectFieldOffset(TestUnSafe.class.getDeclaredField("state"));

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

    }
    public static void main(String[] args) {
        TestUnSafe app = new TestUnSafe();
        System.out.println(app);
        boolean falg = UNSAFE.compareAndSwapInt(app, stateOffset, 0, 1 + 1);
        System.out.println(app + "" + falg);
        // 获取系统内存页大小
        int pageSize = UNSAFE.pageSize();
        System.out.println("内存页大小:" + pageSize);
        testStream();
    }

    private static void testStream() {
        List<Integer> list = Arrays.asList(1, 2 ,3);
        list = list.stream().map(val -> val + 1).collect(Collectors.toList());
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    @Override
    public String toString() {
        return "state : " + state;
    }
}