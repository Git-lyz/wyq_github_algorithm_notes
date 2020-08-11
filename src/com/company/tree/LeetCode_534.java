package com.company.tree;

/**
 * 543. 二叉树的直径
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/solution/hot-100-9er-cha-shu-de-zhi-jing-python3-di-gui-ye-/
 *
 * https://juejin.im/post/6844904086177841166
 */
public class LeetCode_534 {

    public static void main(String[] args) {
        TreeNode treeNode = TreeDataFactory.createInOrderTreeNode3();
        System.out.println(diameterOfBinaryTree(treeNode));
    }

    static int res = 0;

    /**
     * 直径, 不一定root节点就是最大直径, 如果root有一个左右树, 节点少,他的直径就小; 所以每个节点的直径求出来,计算最大值; 如33行
     *
     * root的直径 = root左子树高度 + root右子树高度
     * root的高度 = max {root左子树高度, root右子树高度} + 1
     */
    public static int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return res;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        res = Math.max(res, leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
