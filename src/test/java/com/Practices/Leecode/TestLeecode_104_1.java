package com.Practices.Leecode;

import com.BlackHorse.DataStructure.Tree.BinaryTree.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author: 小蔡
 * @Date: 2023/12/29 20:46
 * @description: 测试Leecode_104_1
 */
public class TestLeecode_104_1 {
    private final Leecode_104_1 lc = new Leecode_104_1();

    @Test
    public void test1() {
        TreeNode root = new TreeNode(new TreeNode(2), 1, new TreeNode(3));
        assertEquals(2, lc.maxDepth(root));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(new TreeNode(2), 1, new TreeNode(null, 3, new TreeNode(4)));
        assertEquals(3, lc.maxDepth(root));
    }

    @Test
    public void test3() {
        TreeNode root = new TreeNode(1);
        assertEquals(1, lc.maxDepth(root));
    }
}
