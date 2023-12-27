package com.BlackHorse.DataStructure.LinkedList;

import java.util.Iterator;

import java.util.function.Consumer;

/**
 * @Author: 小蔡
 * @Date: 2023/12/10 14:28
 * @description: 单向链表
 */
public class SinglyLinkedList implements Iterable<Integer> {
    private Node head;      // 头指针

    @Override
    public Iterator<Integer> iterator() {
        // 匿名内部类 -> 带名字的内部类
        return new NodeIterator();
    }

    private class NodeIterator implements Iterator<Integer> {
        Node pointer = head;

        @Override
        public boolean hasNext() {      // 询问是否有下一个元素，是的话返回真，非的话返回假
            return pointer != null;
        }

        @Override
        public Integer next() {         // 返回当前值，并指向下一个元素
            int v = pointer.value;
            pointer = pointer.next;
            return v;
        }
    }

    // 节点类
    private static class Node {
        int value;      // 值
        Node next;      // 下一个节点指针

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    // 头插法
    public void addFirst(int value) {
        // 1-链表为空
//        head = new Node(value, null);
        // 2-链表非空
        head = new Node(value, head);
    }

    // 遍历链表
    // 实现方式-
    public void loop1(Consumer<Integer> consumer) {
        Node pointer = head;
        while (pointer != null) {
            consumer.accept(pointer.value);
            pointer = pointer.next;
        }
    }

    // 实现方式2
    public void loop2(Consumer<Integer> consumer) {
        for (Node pointer = head; pointer != null; pointer = pointer.next) {
            consumer.accept(pointer.value);
        }
    }

    // 实现方式3-递归遍历
    public void loop3(Consumer<Integer> before, Consumer<Integer> after) {
        recursion(head, before, after);
    }

    private void recursion(Node curr, Consumer<Integer> before, Consumer<Integer> after) {
        if (curr == null) {
            return;
        }
        before.accept(curr.value);
        recursion(curr.next, before, after);
        after.accept(curr.value);
    }

    private void recursion(Node curr) {      // 某个节点要进行的操作
        if (curr == null) {
            return;
        }
        System.out.println(curr.value);
        recursion(curr.next);
    }

    private SinglyLinkedList getLinkedList() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        return list;
    }

    private Node findLast() {
        if (head == null) {      // 空链表
            return null;
        }
        Node pointer;
        for (pointer = head; pointer.next != null; pointer = pointer.next) {
        }
        return pointer;
    }

    public void addLast(int value) {
        Node last = findLast();
        if (last == null) {
            addFirst(value);
            return;
        }
        last.next = new Node(value, null);
    }

//    public void test(){
//        int i = 0;
//        for (Node pointer = head; pointer != null; pointer = pointer.next, i++){
//            System.out.println(pointer);
//        }
//    }

    private Node findNode(int index) {
        int i = 0;
        for (Node pointer = head; pointer != null; pointer = pointer.next, i++) {
            if (i == index) {
                return pointer;
            }
        }
        return null;        // 没找到的情况
    }

    // 索引查找
    public int get(int index) {
        Node node = findNode(index);
        if (node == null) {
            // 抛出异常
            illegalIndex(index);
        }
        return node.value;
    }

    private IllegalArgumentException illegalIndex(int index) {
        throw new IllegalArgumentException(
                String.format("index [%d] 不合法%n", index)
        );
    }

    // 向索引位置插入
    public void insert(int index, int value) throws IllegalArgumentException {
        if (index == 0) {
            addFirst(value);
            return;
        }
        Node prev = findNode(index - 1);       //找到上一个节点
        if (prev == null) {      // 找不到
            // 抛出异常
            illegalIndex(index);
        }
        prev.next = new Node(value, prev.next);
    }

    public void removeFirst() {
        if (head == null) {
            throw illegalIndex(0);
        }
        head = head.next;
    }

    public void remove(int index) {
        if (index == 0) {
            removeFirst();
            return;
        }
        Node prev = findNode(index - 1);    // 上一个节点
        if (prev == null) {
            throw illegalIndex(index);
        }
        Node removed = prev.next;                 // 被山粗的节点
        if (removed == null) {
            throw illegalIndex(index);
        }
        prev.next = removed.next;
    }

//        // 第三种情况:删除非法索引
//        SinglyLinkedList list3 = new SinglyLinkedList();
//        list3.addLast(1);
//        list3.addLast(2);
//        list3.addLast(3);
//        list3.addLast(4);
//        list3.remove(5);
//        for (Integer value : list3){
//            System.out.println(value);
//        }

//        // 第四种情况：要删除的索引的前一个指针存在，但该索引为null
//        SinglyLinkedList list4 = new SinglyLinkedList();
//        list4.addLast(1);
//        list4.addLast(2);
//        list4.addLast(3);
//        list4.addLast(4);
//        list4.remove(4);
//        for (Integer value : list4){
//            System.out.println(value);
//        }

}


