package com.BlackHorse.DataStructure.Sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.BlackHorse.DataStructure.Sort.BubbleSort.bubble;

/**
 * @Author: 小蔡
 * @Date: 2023/12/30 12:08
 * @description: 测试冒泡排序
 */
public class TestBubbleSort {
    @Test
    public void testBubbleSort(){
        int[] a = {6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(a));
        bubble(a);
        System.out.println(Arrays.toString(a));
    }
}
