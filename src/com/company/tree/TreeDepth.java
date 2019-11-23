package com.company.tree;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树最大深度
 * @author liuyuzhe
 */
public class TreeDepth {


    public static void main(String[] args) {
        Integer[] tree = new Integer[]{3, 9, 20, 2, null, 15, 7};
        TreeNode treeNode = new TreeNode(tree[0]);
        TreeNode left2 = new TreeNode(tree[1]);
        treeNode.left = left2;
        treeNode.right = new TreeNode(tree[2]);
        left2.left = new TreeNode(tree[3]);

        System.out.println(maxDepth2(treeNode));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    //Stack<String> s = new Stack();
    //s.push()
    //s.pop() 后进先出
    public static int maxDepth2(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root != null) {
            stack.add(new Pair<>(root, 1));
        }
        int depth = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.poll();
            root = current.getKey();
            Integer current_depth = current.getValue();
            if (root != null) {
                depth = Math.max(depth, current_depth);
                stack.add(new Pair<>(root.left, current_depth+1));
                stack.add(new Pair<>(root.right, current_depth+1));
            }
        }
        return depth;
    }


}
