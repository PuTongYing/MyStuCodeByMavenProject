package com.BlackHorse.DataStructure.MultiRecursive;

import org.junit.Test;
import org.springframework.util.StopWatch;

import static com.BlackHorse.DataStructure.MultiRecursive.Fibonacci_op.fibonacci;
import static com.BlackHorse.DataStructure.MultiRecursive.Fibonacci_op.fibonacci2;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: 小蔡
 * @Date: 2023/12/28 0:05
 * @description: 测试斐波那契数列
 */
public class TestFibonacci {
    @Test
    public void test1() {
        assertEquals(1, fibonacci(2));
        assertEquals(2, fibonacci(3));
        assertEquals(3, fibonacci(4));
        assertEquals(5, fibonacci(5));
        assertEquals(8, fibonacci(6));
        assertEquals(13, fibonacci(7));
        assertEquals(21, fibonacci(8));
        assertEquals(34, fibonacci(9));
        assertEquals(55, fibonacci(10));
        assertEquals(89, fibonacci(11));
        assertEquals(144, fibonacci(12));
        assertEquals(233, fibonacci(13));
    }

    @Test
    public void test2() {
        StopWatch a = new StopWatch("a");
        a.start("带 cache");
        fibonacci(40);
        a.stop();

        a.start("不带 cache");
        fibonacci2(40);
        a.stop();

        System.out.println(a.prettyPrint());
    }
}
