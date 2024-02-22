package com.company.math;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_6 {

    /**
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     */
    public static void main(String[] args) {
        int numRows = 3;
        String s = "ABC";
        System.out.println(convert(s, 1));//PAHNAPLSIIGYIR
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        //行数
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        final char[] charArray = s.toCharArray();
        int i = 0;
        int flag = -1;
        for (char c : charArray) {
            System.out.println("i: "+i);
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                // 取反
                flag = -flag;
                System.out.println("flag: "+flag);
            }
            i+=flag;
        }
        final StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) res.append(row);
        return res.toString();
    }


}
