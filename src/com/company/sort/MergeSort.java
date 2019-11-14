package com.company.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {5, 6, 4, 7};
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void mergeSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = (hi + lo) / 2; //递归拆分成0,1 ; 2,3  只有2个可直接求解的数组
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    private static void merge(int[] nums, int lo, int mid, int hi) {
        int k = lo/*从什么时候位置开始修改原来的数组*/, i = lo /*左边起始位置*/, j = mid + 1/*右边起始位置*/;
        int[] copy = nums.clone();
        while (k <= hi) {
            if (i > mid) { //左边排列完了
                nums[k++] = copy[j++];
            } else if (j > hi) { //右边排列完了
                nums[k++] = copy[i++];
            } else if (copy[j] < copy[i]) {
                nums[k++] = copy[j++];
            } else {
                nums[k++] = copy[i++];
            }
        }
    }

}
