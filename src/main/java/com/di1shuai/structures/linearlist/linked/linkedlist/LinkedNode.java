package com.di1shuai.structures.linearlist.linked.linkedlist;

/**
 * @author Bruce
 * @since 2019-03-30
 */
public class LinkedNode {

    public Long value;

    public LinkedNode next;

    public LinkedNode() {
    }

    public LinkedNode(Long value, LinkedNode next) {
        this.value = value;
        this.next = next;
    }


    @Override
    public String toString() {
        return  value +"->"+next;
    }

    public static void main(String[] args) {
        // 1 -> 2 -> 3 -> null
        LinkedNode n1 = new LinkedNode(1l,new LinkedNode(2l,new LinkedNode(3l,new LinkedNode(4l,null))));
        System.out.println(n1);
        //翻转 即  3 -> 2 -> 1 -> null
        System.out.println((reverse(n1)));


    }


    public static LinkedNode reverse(LinkedNode head){
        LinkedNode current = head;
        LinkedNode next = head.next;
        LinkedNode prev = null;

        while (current!=null){
            current.next = prev;
            prev = current;
            current = next;
            if (next!=null) {
                next = next.next;
            }
        }

        return prev;
    }


}
