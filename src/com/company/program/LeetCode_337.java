package com.company.program;

import com.company.tree.TreeDataFactory;
import com.company.tree.TreeNode;

import java.util.HashMap;

/**
 * 强盗抢钱3: 动态规划
 * https://leetcode-cn.com/problems/house-robber-iii/
 */
public class LeetCode_337 {

    static HashMap<TreeNode, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        TreeNode root = TreeDataFactory.createPostTreeNode();
        System.out.println(rob3(root));
    }

    static HashMap<TreeNode, Integer> f = new HashMap<>();
    static HashMap<TreeNode, Integer> g = new HashMap<>();

    /**
     * 深度优先搜索递归, root的f,g最大值就是结果
     */
    public static int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    private static void dfs(TreeNode note) {
        if (note == null)
            return;
        dfs(note.left);
        dfs(note.right);
        //节点o选中, 子节点不可选
        f.put(note, note.val + g.getOrDefault(note.left, 0) + g.getOrDefault(note.right, 0));
        //节点o未选中
        int leftNote = Math.max(f.getOrDefault(note.left, 0), g.getOrDefault(note.left, 0));
        int rightNote = Math.max(f.getOrDefault(note.right, 0), g.getOrDefault(note.right, 0));

        g.put(note, leftNote + rightNote);
    }


    /**
     * 房间改为二叉树了
     */
    public static int rob3(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (memo.containsKey(root)) {
            return memo.get(root);
        }

        //抢
        int do_it = root.val +
                (root.left == null ? 0 : rob3(root.left.left) + rob3(root.left.right)) +
                (root.right == null ? 0 : rob3(root.right.left) + rob3(root.right.right));

        //不抢
        int not_it = rob3(root.left) + rob3(root.right);

        int res = Math.max(do_it, not_it);
        memo.put(root, res);
        return res;
    }

    public static int rob3(int[] nums, int start, int end) {
        int prev = 0, curr = 0;
        for (int i = start; i <= end; i++) {
            int temp = Math.max(curr, prev + nums[i]);
            prev = curr;
            curr = temp;
        }
        return curr;
    }

    /**
     * 优化版本
     * 数组索引 0表选中, 1未选中
     * <p>
     * l, r 左右孩子
     */
    public static int rob2(TreeNode root) {
        int[] rootStatus = dfs2(root);
        return Math.max(rootStatus[0], rootStatus[1]);
    }

    private static int[] dfs2(TreeNode node) {
        if (node == null)
            return new int[]{0, 0};

        int[] l = dfs2(node.left);
        int[] r = dfs2(node.right);

        int selected = node.val + l[1] + r[1];

        int notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{selected, notSelected};
    }
}
