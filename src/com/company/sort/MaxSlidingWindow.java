package com.company.sort;

import java.util.Arrays;

public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] nums = {5, 6, 4, 7};
        int k = 3;
        int[] output = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(output));
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n - (k - 1)];
        for (int i = 0; i < n - (k - 1); i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) { //1+k 同步移动
                max = Math.max(max, nums[j]);
            }
            output[i] = max;
        }
        return output;
    }

}
