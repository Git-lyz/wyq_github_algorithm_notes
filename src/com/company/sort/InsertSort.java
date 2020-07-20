package com.company.sort;

import java.util.Arrays;

/**
 * 插入排序
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
            current = nums[i];//放到一个临时变量
            for (j = i - 1; j >= 0 && nums[j] > current; j--) { //每次跟current这个基准比, 大的就往后放
                nums[j + 1] = nums[j]; // FIXME: 06/05/2020 比较一轮, 如果大于current就把数放后面赋值一次
            }
            nums[j + 1] = current;//把current放入左边排好序的位置
        }
    }
}
