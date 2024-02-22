package com.company.math;

public class LeetCode_7 {


    public static void main(String[] args) {
        long s = 123;
        System.out.println(reverse2(s) + "");
    }

    private static int reverse2(long x) {
        if (x > Integer.MAX_VALUE) {
            return 0;
        }
        //判断是否 小于 最小32位整数
        if (x < Integer.MIN_VALUE) {
            return 0;
        }
        int t = (int) x;
        int res = 0;
        while (t != 0) {
            int temp = t % 10;
            if (res > Integer.MAX_VALUE) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (res < Integer.MIN_VALUE) {
                return 0;
            }
            res = res*10+temp;
            t = t/10;
        }

        return res;
    }


    private static int reverse(long x) {
        if (x > Integer.MAX_VALUE) {
            return 0;
        }
        //判断是否 小于 最小32位整数
        if (x < Integer.MIN_VALUE) {
            return 0;
        }
        try {
            if (x >= 0) {
                return Integer.parseInt(reverse(String.valueOf(x)));
            } else {
                x = Math.abs(x);
                return -Integer.parseInt(reverse(String.valueOf(x)));
            }
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static String reverse(String x) {
        final char[] chars = x.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }


}
