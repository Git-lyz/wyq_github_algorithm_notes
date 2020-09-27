package com.company.sort;

/**
 * 翻转链表
 */
public class ReverseList {

    public static void main(String[] args) {
        ReverseListNode head = new ReverseListNode(1);
        ReverseListNode node2 = new ReverseListNode(2);
        head.after(node2);
        ReverseListNode node3 = new ReverseListNode(3);
        node2.after(node3);
        ReverseListNode node4 = new ReverseListNode(4);
        node3.after(node4);
        head.sequenceShow();

        ReverseListNode newRoot = reverseList3(head);
        System.out.println();
        newRoot.sequenceShow();
    }

    /**
     * 1 2 3 4 5 -> 3 2 1 4 5
     * <p>
     * 给定这个链表：1->2->3->4->5
     * <p>
     * 当 k = 2 时，应当返回: 2->1->4->3->5
     * 当 k = 3 时，应当返回: 3->2->1->4->5
     *
     * @param head
     * @return
     */
    private static ReverseListNode reverseList3(ReverseListNode head) {
        ReverseListNode dummy = new ReverseListNode(0);
        dummy.next = head;
        ReverseListNode pre = dummy;
        ReverseListNode end = dummy;
        int k = 3;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end==null)break;

            ReverseListNode start = pre.next;//反转链表方法 入参是开始节点
            ReverseListNode next = end.next;
            end.next = null;

            pre.next =  reverseList1(start);
            start.next = next;
            //合并链表
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    private static ReverseListNode reverseList1(ReverseListNode head) {
        ReverseListNode prev = null; // 从头节点一直走到了尾节点
        ReverseListNode curr = head;
        while (curr != null) {
            ReverseListNode next = curr.next;
            curr.next = prev; //链表反转, 当前元素反指向
            prev = curr;//指针向下走一步
            curr = next;
        }
        return prev;
    }

    private static ReverseListNode reverseList2(ReverseListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ReverseListNode p = reverseList2(head.next);
        head.next.next = head;//链表反转
        head.next = null;//清理 当前节点 正序链表的引用
        return p;
    }
}
