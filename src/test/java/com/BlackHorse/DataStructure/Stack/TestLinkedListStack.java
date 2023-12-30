package com.BlackHorse.DataStructure.Stack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: 小蔡
 * @Date: 2023/12/29 1:17
 * @description: 测试链表形式实现栈
 */
public class TestLinkedListStack {
    @Test
    public void push() {
        LinkedListStack<Object> stack = new LinkedListStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertFalse(stack.push(4));

        assertIterableEquals(List.of(3, 2, 1), stack);
    }

    @Test
    public void pop() {
        LinkedListStack<Object> stack = new LinkedListStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        // 3, 2, 1
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertNull(stack.pop());
    }
}
