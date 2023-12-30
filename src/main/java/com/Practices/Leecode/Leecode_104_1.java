package com.Practices.Leecode;

import com.BlackHorse.DataStructure.Tree.BinaryTree.TreeNode;

/**
 * @Author: 小蔡
 * @Date: 2023/12/29 20:40
 * @description: 二叉树的最大深度
 * 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：3
 * 示例 2：
 * 输入：root = [1,null,2]
 * 输出：2
 * <p>
 * 提示：
 *      树中节点的数量在 [0, 10⁴] 区间内。
 *      -100 <= Node.val <= 100
 */
public class Leecode_104_1 {
     /*
        思路：
        1. 得到左子树深度, 得到右子树深度, 二者最大者加一, 就是本节点深度
        2. 因为需要先得到左右子树深度, 很显然是后序遍历典型应用
        3. 关于深度的定义：从根(也可以是某节点)出发, 离根最远的节点总边数,
            注意: 力扣里的深度定义要多一

            深度2         深度3        深度1
            1            1            1
           / \          / \
          2   3        2   3
                            \
                             4
     */
     public int maxDepth(TreeNode root) {
         if (root == null) {
             return 0;
         }
        /*
        if (node.left == null && node.right == null) {
            return 1;
        }
        */
         int d1 = maxDepth(root.left);
         int d2 = maxDepth(root.right);
         return Integer.max(d1, d2) + 1;
     }

}
