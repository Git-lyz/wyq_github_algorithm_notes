package com.company.array;

/**
 * leetcode 26 删除排序数组的重复项
 *
 * @author liuyuzhe
 */
public class deleteDuplicateArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3};
        System.out.println(deleteDuplicate(nums));
    }

    /**
     * 2个指针 i 为慢指针 j 为快指针; i记录结果不重复元素个数
     *
     *
     * @return 无重复数组的length
     */
    private static int deleteDuplicate(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];//数组前面都是不重复的
            }
        }

        return i+1;
    }
}
