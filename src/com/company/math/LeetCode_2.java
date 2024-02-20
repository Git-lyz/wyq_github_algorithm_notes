package com.company.math;

import com.company.sort.ListNode;

public class LeetCode_2 {


    //    遍历两个链表，同时对它们的对应节点进行相加，并考虑进位。
//    创建一个新的链表来存储相加的结果。
//    在遍历的过程中，如果其中一个链表遍历完毕，但另一个链表还有剩余节点，需要继续遍历剩余节点，并考虑进位。
//    最后，如果最高位有进位，需要在结果链表中添加一个新节点来存储进位。
    public static void main(String[] args) {
//        对于数字 342，其在链表中的表示方式是 2 -> 4 -> 3
//        564 , 4->6->5
//        ans 807,   7->0->8
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
        addTwoNumbers(l1, l2).sequenceShow();
//        l1.sequenceShow();
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        final ListNode ans = new ListNode(0); //假头当前值永远为0，从下一个节点
        ListNode current = ans;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10; // e.g 2/10=0 12/10=1 19/10=1
            current.next = new ListNode(sum % 10);//把二数之和保存到下一个节点上
            current = current.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry>0){
            current.next = new ListNode(carry);
        }

        //返回保存二数之和的开始节点
        return ans.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public void sequenceShow() {
            ListNode next = this;
            while (next != null) {
                System.out.print(next.val + " ");
                next = next.next;
            }
        }
    }


    /**
     * 递归
     */
    public static int climbStairs(int n) {
        if (n == 1 || n == 0)
            return 1;
        if (n == 2)
            return 2;

        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 动态规划
     */
    public static int climbStairs2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
