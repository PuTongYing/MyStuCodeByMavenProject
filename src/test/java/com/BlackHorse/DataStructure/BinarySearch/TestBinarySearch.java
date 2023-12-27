package com.BlackHorse.DataStructure.BinarySearch;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;

import static com.BlackHorse.DataStructure.BinarySearch.BinarySearch.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: 小蔡
 * @Date: 2023/12/27 23:15
 * @description: 测试二分查找
 */
public class TestBinarySearch {
    @Test
    @DisplayName("测试 binarySearchBasic")
    public void test1() {
        int[] a = {7, 13, 21, 30, 38, 44, 52, 53};
        assertEquals(0, binarySearchBasic(a, 7));
        assertEquals(1, binarySearchBasic(a, 13));
        assertEquals(2, binarySearchBasic(a, 21));
        assertEquals(3, binarySearchBasic(a, 30));
        assertEquals(4, binarySearchBasic(a, 38));
        assertEquals(5, binarySearchBasic(a, 44));
        assertEquals(6, binarySearchBasic(a, 52));
        assertEquals(7, binarySearchBasic(a, 53));

        assertEquals(-1, binarySearchBasic(a, 0));
        assertEquals(-1, binarySearchBasic(a, 15));
        assertEquals(-1, binarySearchBasic(a, 60));
    }

    @Test
    @DisplayName("测试右移运算")
    public void test2() {
        int i = 0;
        int j = Integer.MAX_VALUE - 1;
        // 模拟第一次求中间索引
        int m = (i + j) / 2;
        // 模拟第二次求中间索引, target 在右侧
        i = m + 1;
        assertEquals(1073741824, i);
        assertEquals(2147483646, j);
        assertEquals(-1073741826, i + j);
        m = (i + j) / 2; // 有问题的情况
        assertEquals(-536870913, m);
        m = (i + j) >>> 1; // 改正后的情况
        assertEquals(1610612735, m);
        /*
        结论：同一个二进制
        1011_1111_1111_1111_1111_1111_1111_1110
        不把最高位视为符号位，代表 3221225470
        把最高位视为符号位,代表 -1073741826
         */
    }

    @Test
    @DisplayName("测试 binarySearchAlternative ")
    public void test3() {
        int[] a = {7, 13, 21, 30, 38, 44, 52, 53};
        assertEquals(0, binarySearchAlternative(a, 7));
        assertEquals(1, binarySearchAlternative(a, 13));
        assertEquals(2, binarySearchAlternative(a, 21));
        assertEquals(3, binarySearchAlternative(a, 30));
        assertEquals(4, binarySearchAlternative(a, 38));
        assertEquals(5, binarySearchAlternative(a, 44));
        assertEquals(6, binarySearchAlternative(a, 52));
        assertEquals(7, binarySearchAlternative(a, 53));

        assertEquals(-1, binarySearchAlternative(a, 0));
        assertEquals(-1, binarySearchAlternative(a, 15));
        assertEquals(-1, binarySearchAlternative(a, 60));
    }

    @Test
    @DisplayName("测试 binarySearchBalance")
    public void test4() {
        int[] a = {7, 13, 21, 30, 38, 44, 52, 53};
        assertEquals(0, binarySearchBalance(a, 7));
        assertEquals(1, binarySearchBalance(a, 13));
        assertEquals(2, binarySearchBalance(a, 21));
        assertEquals(3, binarySearchBalance(a, 30));
        assertEquals(4, binarySearchBalance(a, 38));
        assertEquals(5, binarySearchBalance(a, 44));
        assertEquals(6, binarySearchBalance(a, 52));
        assertEquals(7, binarySearchBalance(a, 53));

        assertEquals(-1, binarySearchBalance(a, 0));
        assertEquals(-1, binarySearchBalance(a, 15));
        assertEquals(-1, binarySearchBalance(a, 60));
    }

    @Test
    @DisplayName("测试 binarySearch java 版")
    public void test5() {
        /*
                ⬇
            [2, 5, 8]       a
            [2, 0, 0, 0]    b
            [2, 4, 0, 0]    b
            [2, 4, 5, 8]    b
         */
        int[] a = {2, 5, 8};
        int target = 4;
        int i = Arrays.binarySearch(a, target);
        assertTrue(i < 0);
        // i = -插入点 - 1  因此有 插入点 = abs(i+1)
        int insertIndex = Math.abs(i + 1); // 插入点索引
        int[] b = new int[a.length + 1];
        System.arraycopy(a, 0, b, 0, insertIndex);
        b[insertIndex] = target;
        System.arraycopy(a, insertIndex, b, insertIndex + 1, a.length - insertIndex);
        assertArrayEquals(new int[]{2, 4, 5, 8}, b);
    }


    @Test
    @DisplayName("测试 binarySearchLeftmost 返回 -1")
    public void test6() {
        int[] a = {1, 2, 4, 4, 4, 5, 6, 7};
        assertEquals(0, binarySearchLeftmost_1(a, 1));
        assertEquals(1, binarySearchLeftmost_1(a, 2));
        assertEquals(2, binarySearchLeftmost_1(a, 4));
        assertEquals(5, binarySearchLeftmost_1(a, 5));
        assertEquals(6, binarySearchLeftmost_1(a, 6));
        assertEquals(7, binarySearchLeftmost_1(a, 7));

        assertEquals(-1, binarySearchLeftmost_1(a, 0));
        assertEquals(-1, binarySearchLeftmost_1(a, 3));
        assertEquals(-1, binarySearchLeftmost_1(a, 8));
    }

    @Test
    @DisplayName("测试 binarySearchRightmost 返回 -1")
    public void test7() {
        int[] a = {1, 2, 4, 4, 4, 5, 6, 7};
        assertEquals(0, binarySearchRightmost_1(a, 1));
        assertEquals(1, binarySearchRightmost_1(a, 2));
        assertEquals(4, binarySearchRightmost_1(a, 4));
        assertEquals(5, binarySearchRightmost_1(a, 5));
        assertEquals(6, binarySearchRightmost_1(a, 6));
        assertEquals(7, binarySearchRightmost_1(a, 7));

        assertEquals(-1, binarySearchRightmost_1(a, 0));
        assertEquals(-1, binarySearchRightmost_1(a, 3));
        assertEquals(-1, binarySearchRightmost_1(a, 8));
    }

    @Test
    @DisplayName("测试 binarySearchLeftmost 返回 i")
    public void test8() {
        int[] a = {1, 2, 4, 4, 4, 7, 8};
        assertEquals(0, binarySearchLeftmost_2(a, 1));
        assertEquals(1, binarySearchLeftmost_2(a, 2));
        assertEquals(2, binarySearchLeftmost_2(a, 4));
        assertEquals(5, binarySearchLeftmost_2(a, 7));
        assertEquals(6, binarySearchLeftmost_2(a, 8));

        assertEquals(0, binarySearchLeftmost_2(a, 0));
        assertEquals(2, binarySearchLeftmost_2(a, 3));
        assertEquals(5, binarySearchLeftmost_2(a, 5));
        assertEquals(7, binarySearchLeftmost_2(a, 9));
    }

    @Test
    @DisplayName("测试 binarySearchRightmost 返回 i-1")
    public void test9() {
        int[] a = {1, 2, 4, 4, 4, 5, 6, 7};
        assertEquals(0, binarySearchRightmost_2(a, 1));
        assertEquals(1, binarySearchRightmost_2(a, 2));
        assertEquals(4, binarySearchRightmost_2(a, 4));
        assertEquals(5, binarySearchRightmost_2(a, 5));
        assertEquals(6, binarySearchRightmost_2(a, 6));
        assertEquals(7, binarySearchRightmost_2(a, 7));

        assertEquals(0, binarySearchRightmost_2(a, 0) + 1);
        assertEquals(2, binarySearchRightmost_2(a, 3) + 1);
        assertEquals(8, binarySearchRightmost_2(a, 8) + 1);
    }
}
