package com.Practices.Leecode;

import com.BlackHorse.DataStructure.Tree.BinaryTree.TreeNode;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Author: 小蔡
 * @Date: 2023/12/29 20:26
 * @description: 测试
 */
public class TestLeecode_101 {
    @Test
    public void test_1(){
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(3), 2, new TreeNode(4)),
                1,
                new TreeNode(new TreeNode(4), 2, new TreeNode(3))
        );
        assertTrue(new Leecode_101().isSymmetric(root));
    }

    @Test
    public void test_2(){
        TreeNode root = new TreeNode(
                new TreeNode(null, 2, new TreeNode(3)),
                1,
                new TreeNode(null, 2, new TreeNode(3))
        );
        assertFalse(new Leecode_101().isSymmetric(root));
    }
}
