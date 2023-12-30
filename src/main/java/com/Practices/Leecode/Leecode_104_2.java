package com.Practices.Leecode;

import com.BlackHorse.DataStructure.Tree.BinaryTree.TreeNode;

import java.util.LinkedList;

/**
 * @Author: 小蔡
 * @Date: 2023/12/29 20:49
 * @description: 二叉树最大深度 - 使用后序遍历(非递归)求解
 */
public class Leecode_104_2 {
    public int maxDepth(TreeNode root) {
        TreeNode curr = root;
        TreeNode pop = null;
        LinkedList<TreeNode> stack = new LinkedList<>();
        int max = 0; // 栈的最大高度
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                int size = stack.size();
                if (size > max) {
                    max = size;
                }
                curr = curr.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right == null || peek.right == pop) {
                    pop = stack.pop();
                } else {
                    curr = peek.right;
                }
            }
        }
        return max;
    }
}
