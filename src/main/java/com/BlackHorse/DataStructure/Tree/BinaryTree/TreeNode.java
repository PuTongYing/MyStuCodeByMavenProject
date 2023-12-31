package com.BlackHorse.DataStructure.Tree.BinaryTree;

/**
 * @Author: 小蔡
 * @Date: 2023/12/29 12:05
 * @description: 数节点类
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(TreeNode left, int val, TreeNode right) {
        this.left = left;
        this.val = val;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}
