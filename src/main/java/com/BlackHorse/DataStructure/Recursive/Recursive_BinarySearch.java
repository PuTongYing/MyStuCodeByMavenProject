package com.BlackHorse.DataStructure.Recursive;

/**
 * @Author: 小蔡
 * @Date: 2023/12/11 23:05
 * @description: 递归-二分查找
 */
public class Recursive_BinarySearch {
    public static int search(int[] a, int target){
        return f(a, target, 0, a.length-1);
    }

    // a-数组， target-待查找值， i-起始索引（包含）, j-结束索引（包含）
    private static int f(int[] a, int target, int i, int j){
        if (i > j){
            return -1;
        }
        int m = (i + j) >>> 1;
        if (target < a[m]){
            return f(a, target, i, m-1);
        } else if (a[m] < target) {
            return f(a, target, m+1, j);
        } else {
            return m;
        }
    }
}
