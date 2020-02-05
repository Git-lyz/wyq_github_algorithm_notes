package com.company.math;

import java.util.Arrays;

/**
 * LeetCode 62 不同路径
 */
public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }

    public static int uniquePaths(int m, int n) {
        int[] memo = new int[n];
        Arrays.fill(memo, 1);
        //System.out.println(Arrays.toString(memo));

        for (int i = 1; i < m; i++) {//1,2
            for (int j = 1; j < n; j++) {//1,2,3,4,5,6
                memo[j] += memo[j - 1];//j-1: 0,1,2,3,4,5; 每次memo[j]都加上上一次索引的值(上一次索引的值也是计算过的)
                System.out.println("内循环的值: "+memo[j - 1]);
            }
            System.out.println("i: "+i+"===>"+Arrays.toString(memo));
        }
        return memo[n - 1];
    }
}
