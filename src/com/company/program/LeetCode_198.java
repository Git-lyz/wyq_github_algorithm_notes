package com.company.program;

import java.util.Arrays;

/**
 * 强盗抢钱: 动态规划
 * https://leetcode-cn.com/problems/house-robber/solution/dong-tai-gui-hua-jie-ti-si-bu-zou-xiang-jie-cjavap/
 */
public class LeetCode_198 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob3(nums));
    }

    private static int rob1(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return rob1(nums, 0,memo);
    }

    /**
     * 计算一定要画图
     * <p>
     * 第一种解法: 备忘录, 自顶向下
     * <p>
     * 递归时, 重叠子问题可以使用备忘录优化
     */
    public static int rob1(int[] nums, int start, int[] memo) {
        if (start >= nums.length) {
            return 0;
        }
        if (memo[start] != -1) {
            return memo[start];
        }

        int res = Math.max(nums[start] + rob1(nums, start + 2, memo), rob1(nums, start + 1, memo));
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
    public static int rob2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int length = nums.length;

        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            //比大小，偷当前位置的钱 nums[i] + 前面隔一个的值dp[i - 2]
            // 与 不偷当前位置 前一个位置的值 dp[i - 1]
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        //获取数组最后一个索引存的值
        return dp[length - 1];
    }

    /**
     * dp数组 房间n 只和 n-1 和 n-2有关 , 最近2个房间有关
     */
    public static int rob3(int[] nums) {
//        每次循环计算当前房子能偷到的最大金额
        int prev = 0, curr = 0;
        for (int i : nums) {
//        循环开始curr表示dp[k-1] , prev表示dp[k-2] ，i表示当前房间的钱
            int temp = Math.max(curr, prev + i);
            prev = curr;
            curr = temp;
        }
//        循环完事curr表示dp[k] 整个数组能偷到的最多钱, prev 表示数组循环前一次的状态值dp[k-1]
        return curr;
    }
}
