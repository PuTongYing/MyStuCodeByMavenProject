package com.Practices.Leecode;

import com.BlackHorse.DataStructure.Tree.BinaryTree.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * @Author: 小蔡
 * @Date: 2023/12/30 11:41
 * @description: 测试
 */
public class TestLeecode_105 {
    @Test
    public void test(){
        int[] preOrder = {1, 2, 4, 3, 6, 7};
        int[] inOrder = {4, 2, 1, 6, 3, 7};
        TreeNode root = new Leecode_105().buildTree(preOrder, inOrder);
    }
}
