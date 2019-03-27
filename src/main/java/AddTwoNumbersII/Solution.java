package main.java.AddTwoNumbersII;

import java.util.Stack;

import main.java.ListNode;

/**
 * @program: LeetCode
 * @description: 解答
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。
 * 它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 进阶:
 * <p>
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 * 示例:
 * <p>
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 * @author: hejy
 * @create: 2019-03-27
 **/
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //采用转换int相加会出现越界情况 2018-03-26
        //采用栈来模拟保证位数对齐问题
        Stack<Integer> temp1 = new Stack<Integer>();
        Stack<Integer> temp2 = new Stack<Integer>();
        Stack<Integer> resultStack = new Stack<Integer>();
        int sum;
        int rem = 0;
        int temp;
        int x = 0;
        int y = 0;
        ListNode result = new ListNode( 0 );
        ListNode tempListNode = result;
        //先将单链表转化为队列
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                temp1.push( l1.val );
                l1 = l1.next;
            }
            if (l2 != null) {
                temp2.push( l2.val );
                l2 = l2.next;
            }
        }
        //利用栈计算
        while (temp1.size() != 0 || temp2.size() != 0) {
            if (temp1.size() != 0) {
                x = temp1.pop();
            }
            if (temp2.size() != 0) {
                y = temp2.pop();
            }
            sum = x + y + rem;
            rem = sum / 10;
            temp = sum % 10;
            resultStack.push( temp );
            x = 0;
            y = 0;
        }
        //处理余数
        if (rem != 0) {
            resultStack.push( rem );
        }
        //将栈转化为链表
        while (resultStack.size() != 0) {
            tempListNode.next = new ListNode( resultStack.pop() );
            tempListNode = tempListNode.next;
        }
        return result.next;
    }
}
