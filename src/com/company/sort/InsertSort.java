package com.company.sort;

import java.util.Arrays;

/**
 * 选择排序
 * @author liuyuzhe
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void insertSort(int[] nums) {
        for (int i = 1, j, current; i < nums.length; i++) {
            current = nums[i];
            for (j = i - 1; j >= 0 && nums[j] > current; j--) { //每次跟current这个基准比, 大的就往后放
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = current;
        }
    }
}
