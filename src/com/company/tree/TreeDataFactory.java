package com.company.tree;

public class TreeDataFactory {


    public static TreeNode createTreeNode() {
        Integer[] tree = new Integer[]{6, 4, 9, 2, 7, 1, 3, 5, 0, 10};
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

    /**
     *          5
     *
 *          3       4
*
*        1    2
     *
     * @return
     */
    public static TreeNode createPostTreeNode() {
        Integer[] tree = new Integer[]{5, 3, 4, 1, 2};
        TreeNode treeNode = new TreeNode(tree[0]);
        TreeNode left1 = new TreeNode(tree[1]);//3
        treeNode.left = left1;
        treeNode.right = new TreeNode(tree[2]);//44

        left1.left = new TreeNode(tree[3]);
        left1.right = new TreeNode(tree[4]);
        return treeNode;
    }

    /**
     *             1
     *
     *      2           5
     *
     *   3     4
     *
     */
    public static TreeNode createPreTreeNode() {
        Integer[] tree = new Integer[]{1, 2, 5, 3, 4};
        TreeNode root = new TreeNode(tree[0]);
        root.right = new TreeNode(tree[2]);

        TreeNode leftNode = new TreeNode(tree[1]);
        root.left = leftNode;
        leftNode.left = new TreeNode(tree[3]);//2
        leftNode.right = new TreeNode(tree[4]);//7

        return root;
    }

    public static TreeNode createInOrderTreeNode() {
        Integer[] tree = new Integer[]{4, 2, 5, 1, 3, 1, 3, 5, 0, 10};
        TreeNode treeNode = new TreeNode(tree[0]);//6
        TreeNode left1 = new TreeNode(tree[1]); //4
        treeNode.left = left1;
        treeNode.right = new TreeNode(tree[2]);

        left1.left = new TreeNode(tree[3]);//2
        left1.right = new TreeNode(tree[4]);//7

        return treeNode;
    }

}
