package com.BlackHorse.DataStructure.MultiRecursive;

import java.util.Arrays;

/**
 * @Author: 小蔡
 * @Date: 2023/12/28 0:04
 * @description: Memoization（记忆法，也称作备忘录法）
 *              时间复杂度->O(n)
 */
public class Fibonacci_op {
    public static int fibonacci(int n){
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);     // [-1,-1,-1,-1,-1,-1]
        cache[0] = 0;
        cache[1] = 1;                   // [0,1,-1,-1,-1,-1]
        return f(n, cache);
    }

    // f(3) => 5
    // f(4) => 9
    // f(5) => 15
    //         2*f(n+1) - 1
    public static int f(int n, int[] cache){
        if (cache[n] != -1) {
            return cache[n];
        }
        int x = f(n-1, cache);
        int y = f(n-2, cache);
        cache[n] = x + y;
        return cache[n];
    }

    public static int fibonacci2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int x = fibonacci2(n - 1);
        int y = fibonacci2(n - 2);
        return x + y;
    }
}
