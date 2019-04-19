package main.java.palindromelinkedlist;

import main.java.ListNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @program: LeetCode
 * @description: 解答
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * @author: hejy
 * @create: 2019-04-16
 **/
public class Solution {
    /**
     * 遍历链表后拼接为数字，然后判断数字是否为回文数字（错误的思想）
     * 需要逐个判断数字是否相同，从链表中取出时分别入队列和栈，然后逐个比较(时间复杂度过高)
     * <p>
     * 查看回答后思路：先找到中点，然后将后半段反转，再和前半段进行比较。这样空间复杂度为O(n)
     * 时间复杂度为O(1)
     * (1)如何找到中点（利用快慢指针找到链表中位数，如果为偶数则找到下中位数）
     * (2)如何将后半段反转（利用头插法反转链表)
     */
    public boolean isPalindrome(ListNode head) {
        /*
        临时栈
         */
        Stack tempStack = new Stack();
        /*
        临时队列
         */
        ArrayDeque tempQueue = new ArrayDeque();
        /*
        分别入栈和入队
         */
        while (head != null) {
            tempStack.push( head.val );
            tempQueue.add( head.val );
            head = head.next;
        }
        return checkNum( tempStack, tempQueue );
    }

    /**
     * 判断是否为回文链表
     *
     * @param stack 需要判断的栈
     * @param queue 需要判断的队列
     * @return
     */
    private boolean checkNum(Stack<Integer> stack, Queue<Integer> queue) {
        while (!stack.isEmpty() || !queue.isEmpty()) {
            if (stack.pop().equals( queue.poll() )) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
