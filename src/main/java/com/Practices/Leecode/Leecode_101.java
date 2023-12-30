package com.Practices.Leecode;

import com.BlackHorse.DataStructure.Tree.BinaryTree.TreeNode;

/**
 * @Author: 小蔡
 * @Date: 2023/12/29 20:16
 * @description: 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * <p>
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * <p>
 * 提示：
 *      树中节点数目在范围 [1, 1000] 内
 *      -100 <= Node.val <= 100
 */
public class Leecode_101 {
    public boolean isSymmetric(TreeNode root){
        return check(root.left, root.right);
    }

    public boolean check(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }
        // left 和 right 不能同时为null
        if (right == null || left == null){
            return false;
        }
        if (left.val != right.val){
            return false;
        }
        return check(left.left, right.right) && check(left.right, right.left);
    }
}
