package main.java.AddTwoNumbers;

import main.java.ListNode;

/**
 * @program: LeetCode
 * @description: 解答
 * 给出两个 非空 的链表用来表示两个非负的整数。
 * 其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * @author: hejy
 * @create: 2019-03-27
 **/
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * 进位数
         */
        int m = 0;
        /**
         * 初始化头节点
         */
        ListNode result = new ListNode(0);
        /**
         * 临时链表节点
         */
        ListNode tempList = result;
        /**
         * 临时节点1
         */
        int temp1 = 0;
        /**
         * 临时节点2
         */
        int temp2 = 0;
        //同步前移
        while(true){
            temp1 = l1.val + l2.val + m;
            m = temp1/10;
            temp2 = temp1%10;
            tempList.next = new ListNode(temp2);
            tempList = tempList.next;
            if(l1.next == null && l2.next == null){
                break;
            }else{
                if(l1.next != null){
                    l1 = l1.next;
                }else{
                    l1.val = 0;
                }
                if(l2.next != null){
                    l2 = l2.next;
                }else{
                    l2.val = 0;
                }
            }
        }
        //处理进位数
        if(m != 0){
            tempList.next = new ListNode(m);
        }
        return result.next;
    }
}
