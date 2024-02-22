package com.company.math;

public class LeetCode_11 {

    // 底面积乘以高，左右2个指针往中间靠，来寻找最大的面积。
    // 每次我们都移动最低的value（短板），这样一直保留高的数，面积永远求的都是最大值
    public static void main(String[] args) {
        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr)+"");
    }
    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int ans = 0;
        while (i < j) {
            final int curr = Math.min(height[j], height[i]) * (j - i);
            ans = Math.max(curr,ans);
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }

        }
        return ans;
    }
}
