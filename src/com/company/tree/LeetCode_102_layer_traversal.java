package com.company.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/di-gui-he-die-dai-by-powcai-2/
 */
public class LeetCode_102_layer_traversal {


    public static void main(String[] args) {
        TreeNode treeNode = TreeDataFactory.createPostTreeNode();
        System.out.println(postOrderTraversal(treeNode));
    }

    public static List<List<Integer>> postOrderTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }

    private static void helper(TreeNode root, List<List<Integer>> res, int depth) {
        if (root == null) {
            return;
        }

        if (depth == res.size()) { //深度一样使用同一个集合
            res.add(new LinkedList<>());
        }
        res.get(depth).add(root.val);
        helper(root.left, res, depth + 1);
        helper(root.right, res, depth + 1);
    }

}
