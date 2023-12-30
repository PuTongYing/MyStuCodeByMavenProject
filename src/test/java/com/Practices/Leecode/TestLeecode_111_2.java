package com.Practices.Leecode;

import com.BlackHorse.DataStructure.Tree.BinaryTree.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author: 小蔡
 * @Date: 2023/12/29 22:06
 * @description: 测试
 */
public class TestLeecode_111_2 {
    @Test
    public void test1() {
        TreeNode root = new TreeNode(new TreeNode(2), 1, new TreeNode(3));
        assertEquals(2, new Leecode_111_2().minDepth(root));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(new TreeNode(2), 1, new TreeNode(null, 3, new TreeNode(4)));
        assertEquals(2, new Leecode_111_2().minDepth(root));
    }

    @Test
    public void test3() {
        TreeNode root = new TreeNode(1);
        assertEquals(1, new Leecode_111_2().minDepth(root));
    }

    @Test
    public void test4() {
        TreeNode root = new TreeNode(new TreeNode(2), 1, null);
        assertEquals(2, new Leecode_111_2().minDepth(root));
    }
}
