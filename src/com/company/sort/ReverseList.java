package com.company.sort;

public class ReverseList {

    public static void main(String[] args) {
        ReverseListNode head = new ReverseListNode(1);
        ReverseListNode node2 = new ReverseListNode(2);
        head.after(node2);
        ReverseListNode node3 = new ReverseListNode(3);
        node2.after(node3);
        head.sequenceShow();
        ReverseListNode newRoot = reverseList2(head);
        System.out.println();
        newRoot.sequenceShow();
    }

    private static ReverseListNode reverseList1(ReverseListNode head) {
        ReverseListNode prev = null; // 从头节点一直走到了尾节点
        ReverseListNode curr = head;
        while (curr != null) {
            ReverseListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static ReverseListNode reverseList2(ReverseListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ReverseListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;//清理正序链表的引用
        return p;
    }
}
