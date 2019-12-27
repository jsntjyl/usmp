package com.jyl.practice.usmp.leetCode;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: usmp
 * @description: 两个数字相加
 * 
 * @author: 19042501
 * @create: 2019-12-13 16:08
 */
public class AddTwoNumbers2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode headNode = null;
        ListNode nowNode = null;
        int index = 0;

        int carry = 0;
        while (l1 != null || l2 != null || carry > 0)
        {
            index ++;
            int num1 = 0;
            int num2 = 0;

            if (l1 != null)
            {
                num1 = l1.val;
                l1 = l1.next;
            }

            if (l2 != null)
            {
                num2 = l2.val;
                l2 = l2.next;
            }

            int sum = num1 + num2 + carry;
            if (sum < 10)
            {
                carry = 0;
            }
            else
            {
                sum = sum - 10;
                carry = 1;
            }

            if (index == 1)
            {
                headNode = new ListNode(sum);
                nowNode = headNode;
            }
            else
            {
                nowNode.next = new ListNode(sum);
                nowNode = nowNode.next;
            }
        }

        return headNode;
    }

    public static void main(String[] args)
    {
       /* ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(3);
        a1.next = a2;
        a2.next = a3;

        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(4);
        b1.next = b2;
        b2.next = b3;

        ListNode result = new AddTwoNumbers2().addTwoNumbers(a1, b1);
        System.out.println(result);*/

        System.out.println(Math.abs("farmauth33756425".hashCode()) % 10);
    }


    static class ListNode
    {
        int val;
        ListNode next;

        public ListNode(int x){
            val=x;
        }

    }
}
