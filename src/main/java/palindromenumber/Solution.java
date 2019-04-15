package main.java.palindromenumber;

/**
 * @program: LeetCode
 * @description: 解答
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * @author: hejy
 * @create: 2019-04-15
 **/
public class Solution {
    /**
     * 思路：
     * (1)首先判断正负，负数一定不是回文数
     * (2)正数时，将正数逆序之后判断与原数是否相等
     */
    public boolean isPalindrome(int x) {
        /*
        记录当前位数
         */
        int temp;
        /*
        逆序数
         */
        int temp1 = 0;
        /*
        原数
         */
        int temp2 = x;
        //判断正负
        if (x >= 0) {
            //判断每一位
            while (x > 0) {
                temp = x % 10;
                x = x / 10;
                temp1 = temp1 * 10 + temp;
            }
            //判断是否为回文数
            return temp1 == temp2;
        } else {
            return false;
        }
    }
}
