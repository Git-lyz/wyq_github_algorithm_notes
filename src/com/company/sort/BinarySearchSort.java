package com.company.sort;

import java.util.LinkedList;

/**
 * 二分查找排序
 *
 * @author liuyuzhe
 */
public class BinarySearchSort {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int[] nums = {1, 2, 5,6};
        System.out.println(binarySearchSort2(nums, 0));
    }

//    leetcode 25
    private static int binarySearchSort3(int[] nums, int target) {
        int l = 0;
        if (nums.length == 0) {
            return -1;
        }
        int r = nums.length - 1;
        if (nums[r] < target) {
            return r + 1;
        }
        if (nums[0] >= target) {
            return 0;
        }
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[r] < target) {
                return r + 1;
            } else if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    //    当你剩2个元素由于下取整，所以永远mid取的是左边元素l
    private static int binarySearchSort2(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
//        while (l < r) {
//            int mid = l + (r - l) / 2;
//            if (nums[mid] > target) {
//                r = mid - 1;
//            } else {
//                //如 mid 10 l 10 ； （10+11)/2 还是10 ,区间不会被缩小，永远也走不出循环了
//                l = mid;
//            }
//        }

        while (l < r) {
            int mid = l + (r - l) / 2;//下取整 获取中位数 4个数就是第二个，5个数就第三个（中间）
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
//        直到l = r 退出，l是不大于target的最小元素的下标（因为l被赋值一定是在小于target时）

//        if (nums[l] == target) {
//            return l;
//        }
        return l;
    }

    private static int binarySearchSort(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }

}
