package com.diyishuai.algorithm.java;

/**
 * @author Bruce
 * @since 2019-03-31
 */
public class DLinkedNode {

    public Long value;

    public DLinkedNode prev;

    public DLinkedNode next;

    public DLinkedNode() {
    }

    public DLinkedNode(Long value, DLinkedNode prev, DLinkedNode next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    @Override
    public String toString() {
        return value + "->" +next;
    }


    public static void main(String[] args) {
        DLinkedNode n1 = new DLinkedNode(1l,null,null);
        DLinkedNode n2 = new DLinkedNode(2l,n1,null);
        DLinkedNode n3 = new DLinkedNode(3l,n2,null);
        DLinkedNode n4 = new DLinkedNode(4l,n3,null);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        System.out.println(n1);
        System.out.println(reverse(n1));


    }

    public static DLinkedNode reverse(DLinkedNode head){
        DLinkedNode prev = null;
        DLinkedNode current = head;
        DLinkedNode next = head.next;
        while (current!=null){
            current.prev = next;
            current.next = prev;

            prev = current;
            current = next;
            if (next!=null)
                next = current.next;
        }
        return prev;
    }

}
