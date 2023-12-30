package com.Practices.Leecode;

import com.BlackHorse.DataStructure.Tree.BinaryTree.TreeNode;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author: 小蔡
 * @Date: 2023/12/29 21:42
 * @description: 测试
 */
public class TestLeecode_104_3 {
    private final Leecode_104_3 lc = new Leecode_104_3();

    @Test
    public void test(){
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4),
                        2,
                        new TreeNode(new TreeNode(7), 5, null)
                ),
                1,
                new TreeNode(null, 3, new TreeNode(6))
        );
        assertEquals(4, lc.maxDepth(root));
    }

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
