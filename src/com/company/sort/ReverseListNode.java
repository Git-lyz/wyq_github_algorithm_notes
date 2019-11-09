package com.company.sort;

class ReverseListNode {
        ReverseListNode next;
        ReverseListNode prev;
        int data;

        ReverseListNode(int data) {
            this.data = data;
        }

        ReverseListNode after(ReverseListNode node) {
            ReverseListNode nextNode = next;
            this.next = node;
            node.prev = this;
            if (nextNode != null) {
                node.next = nextNode;
                nextNode.prev = node;
            }
            return this;
        }

        public int getData() {
            return data;
        }

        void sequenceShow() {
            ReverseListNode next = this;
            while (next != null) {
                System.out.print(next.getData() + " ");
                next = next.next;
            }
        }

        void reverseShow(){
            ReverseListNode curr = this;
            while (curr != null) {
                System.out.print(curr.getData() + " ");
                curr = curr.prev;
            }
        }
    }