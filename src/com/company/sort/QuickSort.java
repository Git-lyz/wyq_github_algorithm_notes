package com.company.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {6, 4, 3, 2, 7, 9, 1, 8, 5};
        quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    private static void quickSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int p = partition(nums, lo, hi);
        quickSort(nums, lo, p);
        quickSort(nums, p + 1, hi);
    }

    private static int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        while (lo < hi) {
            while (lo < hi && nums[hi] >= pivot) {
                hi--;
            }
            nums[lo] = nums[hi];
            while (lo < hi && nums[lo] <= pivot) {
                lo++;
            }
            nums[hi] = nums[lo];
        }
        nums[lo] = pivot;
        return lo;
    }


}
