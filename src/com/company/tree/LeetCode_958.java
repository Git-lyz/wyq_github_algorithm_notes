package com.company.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  二叉树的完全性检验
 */
public class LeetCode_958 {



    public static void main(String[] args) {
        TreeNode treeNode = TreeDataFactory.createPreTreeNode();
        Boolean isComplete = isCompleteTree(treeNode);
        System.out.println(isComplete);
    }

    public static Boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        TreeNode prev = root;

        while (!queue.isEmpty()){
            TreeNode node = queue.remove();
            if (prev == null && node!=null){
                return false;
            }
            if (node !=null){
                queue.add(node.left);
                queue.add(node.right);
            }
            prev = node;
        }
        return true;
    }


}
