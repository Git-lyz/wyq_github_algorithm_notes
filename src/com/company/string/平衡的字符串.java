package com.company.string;

import java.util.*;


//3144. 分割字符频率相等的最少子字符串
//每个字母都切割那么就是字母length，分割的分数，但我们求的是分割平衡串后，他的元素个数最少为最好。
public class 平衡的字符串 {

    public static void main(String[] args) {
        List<Integer> data = new ArrayList<Integer>();
        data.add(1);
        List<Integer> data2 = new ArrayList<Integer>();
        data2.add(3);
        data2.add(4);

//        data.addAll(0, data2);
        data.add(0,4);
        data.add(0,3);


        String s = "fabccddg";
        System.out.println(minimumSubstringsInPartition2(s));
    }


    /**
     * class Solution {
     * static final int INF = 0x3f3f3f3f;
     * <p>
     * public int minimumSubstringsInPartition(String s) {
     * int n = s.length();
     * int[] d = new int[n + 1];
     * Arrays.fill(d, INF);
     * d[0] = 0;
     * for (int i = 1; i <= n; i++) {
     * Map<Character, Integer> occCnt = new HashMap<Character, Integer>();
     * int maxCnt = 0;
     * for (int j = i; j >= 1; j--) {
     * occCnt.put(s.charAt(j - 1), occCnt.getOrDefault(s.charAt(j - 1), 0) + 1);
     * maxCnt = Math.max(maxCnt, occCnt.get(s.charAt(j - 1)));
     * if (maxCnt * occCnt.size() == (i - j + 1) && d[j - 1] != INF) {
     * d[i] = Math.min(d[i], d[j - 1] + 1);
     * }
     * }
     * }
     * return d[n];
     * }
     * }
     * 所有字符出现的次数相等： max_cnt×len(occ_cnt)=i−j+1
     */
    static final int INF = 0x3f3f3f3f;

    public static int solution(String s) {
        int n = s.length();
        int[] d = new int[n + 1];
        Arrays.fill(d, INF);
        d[0] = 0;
        for (int i = 1; i <= n; i++) {
            Map<Character, Integer> occCnt = new HashMap<Character, Integer>();
            int max_cnt = 0;
            for (int j = i; j >= 1; j--) {
                occCnt.put(s.charAt(j - 1), occCnt.getOrDefault(s.charAt(j - 1), 0) + 1);
                max_cnt = Math.max(max_cnt, occCnt.get(s.charAt(j - 1)));
                if (max_cnt * occCnt.size() == (i - j + 1) && d[j - 1] != INF) {
                    d[i] = Math.min(d[i], d[j - 1] + 1);
                }
            }
        }

        return d[n];
    }

    private static char[] ss;
    private static int n;

    public static int minimumSubstringsInPartition2(String s) {
        ss = s.toCharArray();
        n = ss.length;
        return dfs(0);
    }

    //dfs(i) 表示剩余i~n-1字符时最少分割的平衡子串的数量
//    一个子字符串 字母出现的最大次数 maxCnt
    private static int dfs(int i) {
        if (i >= n) return 0;

        int res = Integer.MAX_VALUE;
        int[] cnt = new int[26]; //计数
        int diff = 0; //不同字母的个数
        int maxCnt = 0; //最大数量
        for (int j = i; j < n; j++) { // 枚举下一个切割点
            int num = cnt[ss[j] - 'a'];
            if (num == 0) { //为0是说明不存在 是新的。
                diff++;
            }
            cnt[ss[j] - 'a']++; //让这个位置不为0了，下次取出不为0就是存在过
            if (num + 1 > maxCnt) { //更新最大次数
                maxCnt = num + 1;
            }
            if (j - i + 1 == diff * maxCnt) { //[i,j]  == 如果当前字母次数 * 不同的数量 ，那么就是平衡的子串
                int subRes = dfs(j + 1);//分割一下，递归判断剩余子串； 得出子问题的结果后，我们加1求出最终结果，并取最小值
                if (subRes != Integer.MAX_VALUE) {
                    res = Math.min(res, subRes + 1);
                }
            }
        }
        return res;
    }


    public static int minimumSubstringsInPartition(String s) {
        int n = s.length();
        int[] d = new int[n + 1];
        Arrays.fill(d, INF);
        d[0] = 0;
        for (int i = 1; i <= n; i++) {
            Map<Character, Integer> occCnt = new HashMap<Character, Integer>();
            int maxCnt = 0;
            for (int j = i; j >= 1; j--) {
                occCnt.put(s.charAt(j - 1), occCnt.getOrDefault(s.charAt(j - 1), 0) + 1);
                maxCnt = Math.max(maxCnt, occCnt.get(s.charAt(j - 1)));
                if (maxCnt * occCnt.size() == (i - j + 1) && d[j - 1] != INF) {
                    d[i] = Math.min(d[i], d[j - 1] + 1);
                }
            }
        }
        return d[n];
    }
}
