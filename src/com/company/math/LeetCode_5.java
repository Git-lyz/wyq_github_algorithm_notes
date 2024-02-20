package com.company.math;

public class LeetCode_5 {


    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    private static String longestPalindrome(String s) {
        final int len = s.length();
        if (len < 2) {
            return s;
        }
        int begin = 0;
        //字符串大于2，所以默认回文字符串len是1
        int maxLen = 1;

        final char[] charArray = s.toCharArray();
        //枚举所有长度大于1的子串
        //只有最长的回文
        //从第一个元素开始和第二元素每一个进行判断是不是回文字符串;最后一个没有下一个所以不用判断
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                //为什么加1因为i和j都是索引，我要求的是这个2个索引中元素的个数所以加1.比如0，1 前2个元素是回文，那么他们个数是2
                if (j - i + 1 > maxLen && validPalindrome(charArray, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


    private static boolean validPalindrome(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


}
