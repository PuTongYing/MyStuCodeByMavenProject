package com.BlackHorse.DataStructure.Sort;

import java.util.Arrays;

/**
 * @Author: 小蔡
 * @Date: 2023/12/30 12:06
 * @description: 冒泡排序
 */
public class BubbleSort {
    public static void bubble(int[] a) {
        int j = a.length - 1;
        do {
            int x = 0;
            for (int i = 0; i < j; i++) {
                if (a[i] > a[i + 1]) {
                    int t = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = t;
                    x = i;
                }
            }
            j = x;
        } while (j != 0);
    }
}
