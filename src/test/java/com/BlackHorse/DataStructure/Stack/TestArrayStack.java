package com.BlackHorse.DataStructure.Stack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: 小蔡
 * @Date: 2023/12/29 1:25
 * @description: 测试数组形式实现栈
 */
public class TestArrayStack {
    @Test
    public void push() {
        ArrayStack<Object> stack = new ArrayStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertFalse(stack.push(4));

        assertIterableEquals(List.of(3, 2, 1), stack);
    }

    @Test
    public void pop() {
        ArrayStack<Object> stack = new ArrayStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertNull(stack.pop());
    }

    @Test
    public void pop2() {
        ArrayStack<Object> stack = new ArrayStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        stack.push(4);
        assertIterableEquals(List.of(4, 2, 1), stack);
    }
}
