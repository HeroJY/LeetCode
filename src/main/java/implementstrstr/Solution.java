package main.java.implementstrstr;

/**
 * @program: LeetCode
 * @description: 解答
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 实际是实现indexOf（）这个方法
 * @author: hejy
 * @create: 2019-04-30
 **/
public class Solution {
    /**
     * 非kmp思路：
     * （1）如何记录开始位置（利用计数）
     * （2）如何确认匹配完成（当被匹配字符串剩余长度小于匹配字符串剩余长度时返回-1，或者当匹配字符串全匹配上）
     * （3）如何回溯匹配失败的位置（通过记录的位置+1来进行遍历）
     */
    public int strStr(String haystack, String needle) {
        if ("".equals( needle )) {
            return 0;
        }
        if ("".equals( haystack )) {
            return -1;
        }
        int i = 0, j = 0, result = -1, count = 0;
        //开始循环判断
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt( i ) == needle.charAt( j )) {
                i++;
                j++;
                count++;
                if (haystack.length() - i < needle.length()) {
                    return -1;
                }
                result = i - count;
            } else if (result != -1) {
                i = result + 1;
                j = 0;
                count = 0;
                result = -1;
            } else {
                i++;
                j = 0;
                count = 0;
                result = -1;
            }
        }
        return result;
    }
}
