package com.company.math;

import java.util.Arrays;
import java.util.HashMap;


public class LeetCode_1 {

    public static void main(String[] args) {
        int arr[] = {3,2,4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum2(arr, target)));
    }

    public static int[] twoSum2(int[] nums, int target) {
        int[] ans = new int[2];
        final HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            int other = nums[i];
            if (hashMap.containsKey(target - other)) {
                return new int[]{hashMap.get(target - other), i};
            }
            hashMap.put(other,i);
        }
        return ans;
    }

    private static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans;
    }
}
