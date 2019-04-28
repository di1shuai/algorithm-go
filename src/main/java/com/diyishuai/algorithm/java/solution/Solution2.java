package com.diyishuai.algorithm.java.solution;

import java.math.BigDecimal;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author Bruce
 * @since 2019-04-26
 *
 */


//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return val + "->" + next;
    }

}

public class Solution2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 同时判定两个链表
        // 记录是否需要进1
        // 如果其中一个链表已经为空，则直接将另一个链表剩余部分叠加至此链表
        ListNode l1Current = l1;
        ListNode l2Current = l2;
        ListNode result = null;
        //init
        int currentSum = l1Current.val + l2Current.val ;
        int add = 0;
        result = new ListNode((currentSum + add)%10);
        ListNode currentResult = result;
        add = (currentSum+add)/10;
        l1Current = l1Current.next;
        l2Current = l2Current.next;
        //l1 l2 都有值
        while ( l1Current!=null && l2Current!=null) {
            currentSum = l1Current.val + l2Current.val ;
            currentResult.next = new ListNode((currentSum+add)%10);
            add = (currentSum+add)/10;
            l1Current = l1Current.next;
            l2Current = l2Current.next;
            currentResult = currentResult.next;
        }
        // 其中一个没有值
        if (l1Current==null){
            currentResult.next = l2Current;
        }else if (l2Current == null){
            currentResult.next = l1Current;

        }else {
            currentResult.next = null;
        }
        //解决终位+1问题
        ListNode preResult = currentResult;
        currentResult = currentResult.next;

        if (add==1 && currentResult==null){
            preResult.next = new ListNode(1);
            add = 0;
        }else if (add == 1 && currentResult!=null){
            while (add==1){
                if (currentResult == null){
                    preResult.next = new ListNode(1);
                    add = 0;
                    break;
                }
                currentSum = currentResult.val + 1;
                add = currentSum/10;
                currentResult.val = currentSum%10;
                currentResult = currentResult.next;
                preResult = preResult.next;
            }
        }

        return result;
    }


    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

//        ListNode l1 = new ListNode(9);
//        l1.next = new ListNode(9);
//
//        ListNode l2 = new ListNode(1);

//        ListNode l1 = new ListNode(5);
//
//        ListNode l2 = new ListNode(5);

        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(7);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(2);

//        int[] l1Array = new int[] {2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,9};
//        int[] l2Array = new int[] {5,6,4,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,9,9,9,9};

//        int[] l1Array = new int[] {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
//        int[] l2Array = new int[] {5,6,4};

//        ListNode l1 = getListNodeFromArray(l1Array);
//        ListNode l2 = getListNodeFromArray(l2Array);

//        ListNode l1 = new ListNode(9);
//
//        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(9);
//        l2.next.next.next = new ListNode(9);
//        l2.next.next.next.next = new ListNode(9);
//        l2.next.next.next.next.next = new ListNode(9);
//        l2.next.next.next.next.next.next = new ListNode(9);
//        l2.next.next.next.next.next.next.next = new ListNode(9);
//        l2.next.next.next.next.next.next.next.next= new ListNode(9);
//        l2.next.next.next.next.next.next.next.next.next= new ListNode(9);

        System.out.println("l1 : " + l1);
        System.out.println("l2 : " + l2);


        System.out.println(addTwoNumbers(l1,l2));
    }

    private static ListNode getListNodeFromArray(int[] intArray) {
        ListNode listNode = new ListNode(intArray[0]);
        ListNode current = listNode;
        for (int i = 1; i < intArray.length; i++) {
            current.next = new ListNode(intArray[i]);
            current = current.next;
        }
        return listNode;
    }

}
