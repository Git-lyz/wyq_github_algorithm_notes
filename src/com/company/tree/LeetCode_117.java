package com.company.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 填充每个节点的下一个右侧节点指针 II
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
public class LeetCode_117 {


    public static void main(String[] args) {
        TreeNode treeNode = TreeDataFactory.createTreeNode();
        TreeNode node = connect1(treeNode);
        System.out.println(LeetCode_102_层序遍历.postOrderTraversal(node));
    }

    public static TreeNode connect(TreeNode root) {
        if (root == null || (root.right == null && root.left == null)) {
            return root;
        }
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
            root.right.next = getNextNoNullChild(root);
        }
        if (root.left == null) {
            root.right.next = getNextNoNullChild(root);
        }
        if (root.right == null) {
            root.left.next = getNextNoNullChild(root);
        }

        //这里要注意：先递归右子树，否则右子树根节点next关系没建立好，左子树到右子树子节点无法正确挂载
        root.right = connect(root.right);
        root.left = connect(root.left);

        return root;
    }

    /**
     * 一路向右找到有子节点的根节点
     */
    private static TreeNode getNextNoNullChild(TreeNode root) {
        while (root.next != null) {
            if (root.next.left != null) {
                return root.next.left;
            }
            if (root.next.right != null) {
                return root.next.right;
            }
            root = root.next;
        }
        return null;
    }


    /**
     * 采用队列将下一层的节点保存起来
     */
    public static TreeNode connect1(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode pre = null;
            for (int i = 0; i < size; i++) { //层序遍历, 来赋值
                TreeNode cur = queue.poll();
                //从第二个节点开始，将前一个节点的 pre 指向当前节点
                if (i > 0) {
                    pre.next = cur; //这里不断利用临时变量, 对root树里的节点做赋值操作
                }
                pre = cur;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }

            }
        }
        return root;
    }


}
