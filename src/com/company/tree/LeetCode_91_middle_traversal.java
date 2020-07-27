package com.company.tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树中序遍历
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/er-cha-shu-de-zhong-xu-bian-li-by-leetcode/
 */
public class LeetCode_91_middle_traversal {


    public static void main(String[] args) {
        TreeNode treeNode = TreeDataFactory.createTreeNode();
        System.out.println(inordertraversal(treeNode));
    }

    /**
     * 莫里斯遍历,改变树的结构变链表
     * 将树的右边整体的都挂在树的左边的右节点上, 然后遍历
     */
    public static List<Integer> inordertraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode pre;
        while (root != null) {

            if (root.left != null) {
                pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root;

                TreeNode tmp = root;
                root = root.left;
                tmp.left = null;
            } else {
                //没有左节点,就遍历有边
                res.add(root.val);
                root = root.right;

            }
        }
        return res;
    }

    public static List<Integer> inordertraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private static void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }

            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }


    public static List<Integer> inordertraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            //入栈左子节点, 到左叶子
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            //栈后进先出, pop出栈顶的元素
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }

        return res;
    }

}
