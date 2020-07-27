package com.company.tree;

/**
 * 3, 9, 20, 2, 8, 15, 7
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * 3, 9, 20, 2, 8, 15, 7
 */
public class TreeDataFactory {



    public static TreeNode createTreeNode() {
        Integer[] tree = new Integer[]{3, 9, 20, 2, 8, 15, 7};
        TreeNode treeNode = new TreeNode(tree[0]);

        TreeNode left1 = new TreeNode(tree[1]); //第一个left
        treeNode.left = left1;

        TreeNode right1 = new TreeNode(tree[2]);//第一right
        treeNode.right = right1;

        TreeNode left2 = new TreeNode(tree[3]);
        left1.left = left2;//第一个left节点的left
        right1.left =  new TreeNode(tree[4]);//第一个right节点的left

        left2.left = new TreeNode(tree[5]);
        left2.right = new TreeNode(tree[6]);

        return treeNode;
    }

}
