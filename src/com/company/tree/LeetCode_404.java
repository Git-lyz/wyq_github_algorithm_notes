package com.company.tree;

/**
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 */
public class LeetCode_404 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeDataFactory.createTreeNode();
        System.out.println(sumOfLeftLeaves(treeNode, false));
    }

    private static int sumOfLeftLeaves(TreeNode treeNode, boolean flag) {
        if (treeNode == null)
            return 0;

//        int leaves = getAllNodeSum(treeNode);
//        int leaves = getLeftNodeSum(treeNode, flag);
        int leaves = getLeftLeavesNodeSum(treeNode, flag);

        int leftVal = sumOfLeftLeaves(treeNode.left, true);
        int rightVal = sumOfLeftLeaves(treeNode.right, false);

        return leftVal + rightVal + leaves;
    }

    /**
     * 所有左子节点的和
     */
    private static int getLeftNodeSum(TreeNode treeNode, boolean flag) {
        int leaves = 0;
        if (flag) {
            leaves += treeNode.val;
        }
        return leaves;
    }

    /**
     * 所有左叶子的和
     */
    private static int getLeftLeavesNodeSum(TreeNode treeNode, boolean flag) {
        int leaves = 0;
        if (flag && (treeNode.left == null && treeNode.right == null)) {
            leaves += treeNode.val;
        }
        return leaves;
    }

    /**
     * 所有节点的和
     * @param treeNode
     */
    private static int getAllNodeSum(TreeNode treeNode) {
        return treeNode.val;
    }
}
