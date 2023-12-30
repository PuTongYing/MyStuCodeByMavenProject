package com.Practices.Leecode;

import com.BlackHorse.DataStructure.Tree.BinaryTree.TreeNode;

/**
 * @Author: 小蔡
 * @Date: 2023/12/29 21:52
 * @description: 二叉树最小深度 - 后序遍历实现
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 * <p>
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 * <p>
 * 提示：
 *      树中节点数的范围在 [0, 10⁵] 内
 *      -1000 <= Node.val <= 1000
 */
public class Leecode_111_1 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int d1 = minDepth(root.left); // 1
        int d2 = minDepth(root.right); // 0
        if (d2 == 0) { // 当右子树为null
            return d1 + 1; // 返回左子树深度+1
        }
        if (d1 == 0) { // 当左子树为null
            return d2 + 1; // 返回右子树深度+1
        }
        return Integer.min(d1, d2) + 1;
    }
}
