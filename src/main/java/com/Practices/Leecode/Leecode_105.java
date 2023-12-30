package com.Practices.Leecode;

import com.BlackHorse.DataStructure.Tree.BinaryTree.TreeNode;

import java.util.Arrays;

/**
 * @Author: 小蔡
 * @Date: 2023/12/29 23:35
 * @description: 从前序与中序遍历序构造二叉树
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
 * 返回其根节点。
 * <p>
 * 示例 1:
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * 示例 2:
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 * <p>
 * 提示:
 *      1 <= preorder.length <= 3000
 *      inorder.length == preorder.length
 *      -3000 <= preorder[i], inorder[i] <= 3000
 *      preorder 和 inorder 均 无重复 元素
 *      inorder 均出现在 preorder
 *      preorder 保证 为二叉树的前序遍历序列
 *      inorder 保证 为二叉树的中序遍历序列
 */
public class Leecode_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        // 创建根节点
        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);
        // 区分左右子树
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                // 0 ~ i-1 左子树
                // i+1 ~ inOrder.length -1 右子树
                int[] inLeft = Arrays.copyOfRange(inorder, 0, i); // [4,2]
                int[] inRight = Arrays.copyOfRange(inorder, i + 1, inorder.length); // [6,3,7]

                int[] preLeft = Arrays.copyOfRange(preorder, 1, i + 1); // [2,4]
                int[] preRight = Arrays.copyOfRange(preorder, i + 1, inorder.length); // [3,6,7]

                root.left = buildTree(preLeft, inLeft); // 2
                root.right = buildTree(preRight, inRight); // 3
                break;
            }
        }
        return root;
    }
}
