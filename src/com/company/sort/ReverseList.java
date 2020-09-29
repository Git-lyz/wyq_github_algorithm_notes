package com.company.sort;

/**
 * 翻转链表
 */
public class ReverseList {

    public static void main(String[] args) {
        ReverseListNode head = new ReverseListNode(5);
        ReverseListNode node2 = new ReverseListNode(4);
        head.after(node2);
        ReverseListNode node3 = new ReverseListNode(3);
        node2.after(node3);
        ReverseListNode node4 = new ReverseListNode(2);
        node3.after(node4);
        ReverseListNode node5 = new ReverseListNode(1);
        node4.after(node5);
        head.sequenceShow();

        ReverseListNode newRoot = reverseList4(head);
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
            if (end == null) break;

            ReverseListNode start = pre.next;//反转链表方法 入参是开始节点
            ReverseListNode next = end.next;
            end.next = null;

            pre.next = reverseList1(start);
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

    /**
     * 从索引 from 2 to 4  head->5->4->3->2->1
     * <p>
     * head->5->2->3->4->1
     * <p>
     * from-1, from, to, to+1 四个结点
     */
    private static ReverseListNode reverseList4(ReverseListNode head) {
        int fromIndex = 2;
        int toIndex = 4;

        ReverseListNode dummy = new ReverseListNode(0);
        dummy.next = head;
        //0head.prev = node;

        ReverseListNode fromPre = null;//5
        ReverseListNode from = null;//4
        ReverseListNode to = null;//2
        ReverseListNode toNext = null;//1


        ReverseListNode temp = head;
        int index = 1;
        //找到4个节点
        while (temp != null) {
            if (index == fromIndex - 1) {
                fromPre = temp;
            } else if (index == fromIndex) {
                from = temp;
            } else if (index == toIndex) {
                to = temp;
            } else if (index == toIndex + 1) {
                toNext = temp;
            }
            index++;
            temp = temp.next;
        }

        //翻转 from到to
        ReverseListNode prev = from;
        ReverseListNode curr = prev.next;
        while (curr != toNext) {
            ReverseListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //把 fromPre -> to , from -> toNext

        fromPre.next = to;
        from.next = toNext;

        return dummy.next;
    }
}
