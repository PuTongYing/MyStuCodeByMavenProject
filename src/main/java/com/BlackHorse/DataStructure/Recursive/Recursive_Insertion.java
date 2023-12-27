package com.BlackHorse.DataStructure.Recursive;

/**
 * @Author: 小蔡
 * @Date: 2023/12/12 22:10
 * @description: 递归-插入排序
 *      将数组分为两部分 [0 .. low-1]  [low .. a.length-1]
 *      左边 [0 .. low-1] 是已排序部分
 *      右边 [low .. a.length-1] 是未排序部分
 *      每次从未排序区域取出 low 位置的元素, 插入到已排序区域
 */
public class Recursive_Insertion {
    public static void sort(int[] a){
        insertion(a, 1);
    }

    public static void insertion(int[] a, int low){
        if (low == a.length){
            return;
        }
        int t = a[low];
        int i = low - 1;          // 已排序区域指针
        while (i>=0 && a[i] > t) {      // 没有找到插入位置
            a[i + 1] = a[i];    // 空出插入位置
            i--;
        }
        a[i + 1] = t;
        insertion(a, low+1);
    }

    // 另一种插入排序的实现,缺点: 赋值次数较多
    private static void insertion2(int[] a, int low) {
        if (low == a.length) {
            return;
        }
        int i = low - 1;
        while (i >= 0 && a[i] > a[i + 1]) {
            int t = a[i];
            a[i] = a[i + 1];
            a[i + 1] = t;

            i--;
        }
        insertion(a, low + 1);
    }
}
