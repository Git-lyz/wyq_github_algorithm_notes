package com.company.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 前序序遍历
 */
public class LeetCode_144 {


    public static void main(String[] args) {
        TreeNode treeNode = TreeDataFactory.createPreTreeNode();
        System.out.println(frontOrderTraversal(treeNode));
    }

    private static List<Integer> frontOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root,list);
        return list;
    }

    private static void helper(TreeNode root, List<Integer> list) {
        if (root==null)return;
        list.add(root.val);
        helper(root.left,list);
        helper(root.right,list);
    }

}
