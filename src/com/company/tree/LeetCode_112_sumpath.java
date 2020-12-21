package com.company.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 112. 路径总和
 * https://leetcode-cn.com/problems/path-sum/
 */
public class LeetCode_112_sumpath {

    public static void main(String[] args) {
        TreeNode treeNode = TreeDataFactory.createTreeNode();
        System.out.println(hasPathSum1(treeNode, 25));
    }

    /**
     * 并不完全是需要完全版的层序遍历, 只要是从根往下遍历, 依次判断每一个节点就可以了
     */
//    public static boolean hasPathSum(TreeNode root, int sum) {
//        if (root == null) {
//            return false;
//        }
//        Queue<TreeNode> queNode = new LinkedList<TreeNode>();
//        Queue<Integer> queVal = new LinkedList<Integer>();
//        queNode.offer(root);
//        queVal.offer(root.val);
//        while (!queNode.isEmpty()) {
//            TreeNode now = queNode.poll();
//            int temp = queVal.poll();
//            if (now.left == null && now.right == null) {
//                if (temp == sum) {
//                    return true;
//                }
//                continue;
//            }
//            if (now.left != null) {
//                queNode.offer(now.left);
//                queVal.offer(now.left.val + temp);
//            }
//            if (now.right != null) {
//                queNode.offer(now.right);
//                queVal.offer(now.right.val + temp);
//            }
//        }
//        return false;
//    }
    private static boolean hasPathSum(TreeNode root, int sum) {
        Queue<TreeNode> queNode = new LinkedList<>();
        Queue<Integer> queVal = new LinkedList<>();

        queNode.offer(root);
        queVal.offer(root.val);

        while (!queNode.isEmpty()) {
            int N = queNode.size();
            for (int i = 0; i < N; i++) {
                int temp = queVal.poll();
                TreeNode now = queNode.poll();
                if (now.left == null && now.right == null) {
                    if (temp == sum) {
                        System.out.println("====");
                        return true;
                    }
                    continue;
                }

                if (now.left != null) {
                    queNode.add(now.left);
                    queVal.add(now.left.val + temp);
                }
                if (now.right != null) {
                    queNode.add(now.right);
                    queVal.add(now.right.val + temp);
                }
            }
        }
        return false;
    }

    private static boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) return false;

        if (root.left == null && root.right == null && sum - root.val == 0) {
            return true;
        }

        return hasPathSum1(root.left, sum - root.val) || hasPathSum1(root.right, sum - root.val);
    }
}