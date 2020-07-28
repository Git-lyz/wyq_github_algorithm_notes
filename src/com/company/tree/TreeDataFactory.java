package com.company.tree;

/**
 * 3, 9, 20, 2, 8, 15, 7
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 3, 9, 20, 2, 8, 15, 7
 */
public class TreeDataFactory {


    public static TreeNode createTreeNode() {
        Integer[] tree = new Integer[]{6, 4, 9, 2, 7, 1, 3, 5, 8, 10};
        TreeNode treeNode = new TreeNode(tree[0]);//6

        TreeNode left1 = new TreeNode(tree[1]); //4
        treeNode.left = left1;
        TreeNode right1 = new TreeNode(tree[2]);//9
        treeNode.right = right1;
        TreeNode left2 = new TreeNode(tree[3]);
        left1.left = left2;//2
        left1.right = new TreeNode(tree[7]);//5
        TreeNode left7 = new TreeNode(tree[4]);
        right1.left = left7;//7
        right1.right = new TreeNode(tree[9]);
        left7.right = new TreeNode(tree[8]);//8
        left2.left = new TreeNode(tree[5]);//1
        left2.right = new TreeNode(tree[6]);

        return treeNode;
    }

}
