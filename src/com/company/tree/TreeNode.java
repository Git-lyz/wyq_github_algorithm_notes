package com.company.tree;

public class TreeNode {
    TreeNode left;
    TreeNode right;
    TreeNode next;

    int val;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }




    public void traversalNext(){
        if (next != null){
            System.out.println(next.val);
        }

    }
}
