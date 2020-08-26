package com.company.program;

import java.util.Arrays;

/**
 * 强盗抢钱
 * https://leetcode-cn.com/problems/house-robber/solution/dong-tai-gui-hua-jie-ti-si-bu-zou-xiang-jie-cjavap/
 */
public class LeetCode_198 {

    static int memo[] = null;

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        System.out.println(rob(nums, 0));
    }

    /**
     * 计算一定要画图
     * <p>
     * 第一种解法: 备忘录, 自顶向下
     */
    public static int rob(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }
        if (memo[start] != -1) {
            return memo[start];
        }

        int res = Math.max(nums[start] + rob(nums, start + 2), rob(nums, start + 1));
        memo[start] = res;
        return res;
    }
}
