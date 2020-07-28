package com.company.tree;

/**
 * 二叉树剪枝
 * https://leetcode-cn.com/problems/binary-tree-pruning/solution/java-hou-xu-bian-li-by-zxy0917/
 */
public class LeetCode_814 {

    public static void main(String[] args) {
        TreeNode treeNode = TreeDataFactory.createTreeNode();
        System.out.println(LeetCode_91_middle_traversal.inordertraversal(treeNode));

        System.out.println(LeetCode_91_middle_traversal.inordertraversal(pruneTree(treeNode)));
    }

    private static TreeNode pruneTree(TreeNode root) {
        if (root==null)return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.val==0 && root.left ==null && root.right == null){
            return null;
        }
        return root;
    }

}
