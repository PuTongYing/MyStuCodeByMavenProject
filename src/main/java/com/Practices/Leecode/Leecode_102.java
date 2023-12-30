package com.Practices.Leecode;

import com.BlackHorse.DataStructure.Queue.LinkedListQueue;
import com.BlackHorse.DataStructure.Tree.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 小蔡
 * @Date: 2023/12/29 11:52
 * @description: 二叉树的层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * 示例 2：
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 * <p>
 * 提示：
 *      树中节点数目在范围 [0, 2000] 内
 *      -1000 <= Node.val <= 1000
 */
public class Leecode_102 {
    /*
       [
           [1]
           [2,3]
           [4,5,6,7]
       ]
    */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();
        queue.offer(root);
        int c1 = 1; // 当前层节点数
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>(); // 保存每一层结果
            int c2 = 0; // 下一层节点数
            for (int i = 0; i < c1; i++) {
                TreeNode n = queue.poll();
                level.add(n.val);
                if (n.left != null) {
                    queue.offer(n.left);
                    c2++;
                }
                if (n.right != null) {
                    queue.offer(n.right);
                    c2++;
                }
            }
            result.add(level);
            c1 = c2;
        }
        return result;
    }

    /*
                  1
                 / \
                2   3
               /\   /\
              4  5 6  7

              头 [] 尾

              1 2 3 4 5 6 7
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(
                        new TreeNode(4),
                        2,
                        new TreeNode(5)
                ),
                1,
                new TreeNode(
                        new TreeNode(6),
                        3,
                        new TreeNode(7)
                )
        );
        List<List<Integer>> lists = new Leecode_102().levelOrder(root);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
        /*
        LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();
        queue.offer(root);
        int c1 = 1; // 当前层节点数
        while (!queue.isEmpty()) {
            int c2 = 0; // 下一层节点数
            for (int i = 0; i < c1; i++) {
                TreeNode n = queue.poll();
                System.out.print(n + " ");
                if (n.left != null) {
                    queue.offer(n.left);
                    c2++;
                }
                if (n.right != null) {
                    queue.offer(n.right);
                    c2++;
                }
            }
            System.out.println();
            c1 = c2;
        }
        */
    }
}
