package com.BlackHorse.DataStructure.LinkedList;

import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: 小蔡
 * @Date: 2023/12/27 23:45
 * @description: 测试带哨兵的环形链表
 */
public class TestCircularLinkedListSentinel {
    @Test
    public void addFirst() {
        CircularLinkedListSentinel list = new CircularLinkedListSentinel();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);

        assertIterableEquals(List.of(5, 4, 3, 2, 1), list);
    }

    @Test
    public void addLast() {
        CircularLinkedListSentinel list = new CircularLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        assertIterableEquals(List.of(1, 2, 3, 4, 5), list);
    }

    @Test
    public void removeFirst() {
        CircularLinkedListSentinel list = getList();
        list.removeFirst();
        assertIterableEquals(List.of(2, 3, 4, 5), list);
        list.removeFirst();
        assertIterableEquals(List.of(3, 4, 5), list);
        list.removeFirst();
        assertIterableEquals(List.of(4, 5), list);
        list.removeFirst();
        assertIterableEquals(List.of(5), list);
        list.removeFirst();
        assertIterableEquals(List.of(), list);
        assertThrows(IllegalArgumentException.class, list::removeFirst);
    }

    @Test
    public void removeLast() {
        CircularLinkedListSentinel list = getList();
        list.removeLast();
        assertIterableEquals(List.of(1, 2, 3, 4), list);
        list.removeLast();
        assertIterableEquals(List.of(1, 2, 3), list);
        list.removeLast();
        assertIterableEquals(List.of(1, 2), list);
        list.removeLast();
        assertIterableEquals(List.of(1), list);
        list.removeLast();
        assertIterableEquals(List.of(), list);
        assertThrows(IllegalArgumentException.class, list::removeLast);
    }

    private CircularLinkedListSentinel getList() {
        CircularLinkedListSentinel list = new CircularLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        return list;
    }

    @Test
    public void removeByValue() {
        CircularLinkedListSentinel list = getList();
        list.removeByValue(1);
        assertIterableEquals(List.of(2, 3, 4, 5), list);
        list.removeByValue(2);
        assertIterableEquals(List.of(3, 4, 5), list);
        list.removeByValue(3);
        assertIterableEquals(List.of(4, 5), list);
        list.removeByValue(4);
        assertIterableEquals(List.of(5), list);
        list.removeByValue(5);
        assertIterableEquals(List.of(), list);
    }
}
