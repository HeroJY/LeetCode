package main.java.longestsubstringwithoutrepeatingcharacters;

import java.util.Stack;

/**
 * @program: LeetCode
 * @description: 解答
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * @author: hejy
 * @create: 2019-03-28
 **/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        /**
         * 利用栈来判断是否有重复（链表实现，不存在越界）
         */
        Stack<Character> tempStack = new Stack<Character>();
        /**
         * 计算长度
         */
        int result = 0;
        /**
         * 临时变量
         */
        char temp1;

        if(s.length() == 0){
            return result;
        }
        for(int i = 0; i<s.length(); i++){
            temp1 = s.charAt(i);
            if(tempStack.search(temp1) == -1){
                tempStack.push(temp1);
                if(result < tempStack.size()){
                    result = tempStack.size();
                }
            }else{
                /**
                 * 这里第一次考虑对栈全部清除，从第二个开始重新判断
                 * 主要耗时就在这里（219ms）
                 * i = i - tempStack.size();
                 * tempStack.clear();
                 * 这里只需要删除第一个数据，然后重新判断当前字符是否有重复
                 * 时间优化后（52ms）
                 */
                i--;
                tempStack.removeElementAt(0);
            }
        }
        return result;
    }
}
