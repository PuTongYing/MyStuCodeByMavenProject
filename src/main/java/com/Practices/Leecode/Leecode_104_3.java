package com.Practices.Leecode;

import com.BlackHorse.DataStructure.Tree.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: 小蔡
 * @Date: 2023/12/29 21:12
 * @description: 二叉树最大深度 - 使用层序遍历
 */
public class Leecode_104_3 {
    /*
        思路：
        1. 使用层序遍历, 层数即最大深度
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
//                System.out.print(poll.val + "\t");
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
//            System.out.println();
            depth ++;
        }
        return depth;
    }
}
