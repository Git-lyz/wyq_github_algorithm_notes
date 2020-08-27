package com.company.program;

import java.util.Arrays;

/**
 * 强盗抢钱
 * https://leetcode-cn.com/problems/house-robber/solution/dong-tai-gui-hua-jie-ti-si-bu-zou-xiang-jie-cjavap/
 */
public class LeetCode_198 {

    static int memo[] = null;

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        System.out.println(rob(nums));
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

    /**
     * dp 数组
     * <p>
     * 🏡 1 2 3 1
     * <p>
     * s 表示 钱
     * h 表示 房子
     * <p>
     * 第一个房子: S0 = h0 = 1
     * 第二个房子: S1 = max(s0,h1) = 2
     * 第三个房子: S2 = max(s1,h2+s0) = 4 //不偷就是s1的值, 偷只能第一个房子和当前房子的和
     * 第四个房子: S3 = max(s2,h3+s1) = 4
     * <p>
     * 推导出公式: Sn = max(Sn-1,hn+Sn-2)
     */
    public static int rob(int[] nums) {
        if (nums.length==0){
            return 0;
        }

        if (nums.length==1){
            return nums[0];
        }

        int length = nums.length;

        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[length - 1];
    }
}
