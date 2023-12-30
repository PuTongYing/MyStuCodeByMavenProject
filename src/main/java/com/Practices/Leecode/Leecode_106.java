package com.Practices.Leecode;

import com.BlackHorse.DataStructure.Tree.BinaryTree.TreeNode;

import java.util.Arrays;

/**
 * @Author: 小蔡
 * @Date: 2023/12/30 11:44
 * @description: 从中序与后序遍历序列构造二叉树
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
 * 返回这颗 二叉树 。
 * <p>
 * 示例 1:
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 * 示例 2:
 * 输入：inorder = [-1], postorder = [-1]
 * 输出：[-1]
 * <p>
 * 提示:
 *      1 <= inorder.length <= 3000
 *      postorder.length == inorder.length
 *      -3000 <= inorder[i], postorder[i] <= 3000
 *      inorder 和 postorder 都由 不同 的值组成
 *      postorder 中每一个值都在 inorder 中
 *      inorder 保证是树的中序遍历
 *      postorder 保证是树的后序遍历
 */
public class Leecode_106 {
    /*
        inOrder = {4,2,1,6,3,7}
        postOrder = {4,2,6,7,3,1}

        根 1
           in        post
        左 4,2       4,2
        右 6,3,7     6,7,3
     */

    public TreeNode buildTree(int[] inOrder, int[] postOrder) {
        if (inOrder.length == 0) {
            return null;
        }
        // 根
        int rootValue = postOrder[postOrder.length - 1];
        TreeNode root = new TreeNode(rootValue);
        // 切分左右子树
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == rootValue) {
                int[] inLeft = Arrays.copyOfRange(inOrder, 0, i);
                int[] inRight = Arrays.copyOfRange(inOrder, i + 1, inOrder.length);

                int[] postLeft = Arrays.copyOfRange(postOrder, 0, i);
                int[] postRight = Arrays.copyOfRange(postOrder, i, postOrder.length - 1);

                root.left = buildTree(inLeft, postLeft);
                root.right = buildTree(inRight, postRight);
                break;
            }
        }
        return root;
    }
}
