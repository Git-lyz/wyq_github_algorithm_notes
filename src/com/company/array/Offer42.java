package com.company.array;

/**
 * 长度为n的字符串:
 * 子串(必须连续挨着)有n(n+1)/2个
 * <p>
 * 子序列有2的n次方
 * <p>
 * 遇到不重复的首先想到Set
 */
public class Offer42 {

    /**
     * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
     * -2,1,-3,4,-1,2,1,-5,4
     *
     * [-2,1,-3,4,-1,2,1,-5,4] 他的连续子串, 相加为6
     */
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(arr));
    }

    private static int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);//取遍历列表前一个数与当前数相加
            res = Math.max(nums[i], res);
        }
        return res;
    }
}
