package main.java.longestpalindromicsubstring;

/**
 * @program: LeetCode
 * @description: 解答
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * @author: hejy
 * @create: 2019-04-02
 **/
public class Solution {
    /**
     * 如果不记录长度，改为记录字符串下标呢？
     * 记录回文子串长度
     * public static final COUNT = 0;
     * 频繁操作，提高效率
     */
    private StringBuilder longest = new StringBuilder();

    /**
     * 考虑用递归（不能单纯用，需要结合循环使用）
     * 递归终止条件是什么？
     * 如何从中间开始划分？
     * 如何减小递归问题规模？
     * 去看了解答……来回答上面问题。
     * （1）利用多重循环嵌套实现，把每个字符作为中心对称点来判断是否为回文串
     * （2）区分奇数和偶数时通过下标重合区分（这个是为什么）
     * （3）回答上面的问题：因为如果是奇数类似于aba，这时是关于b中心对称，所以判断的是b左右两边的
     * 如果是偶数类似于abba，这时候是没有中心对称数的，所以第一次就需要判断中间两个是否相等
     */
    public String longestPalindrome(String s) {
        /*
        字符串起始位置
         */
        int i = 0;
        if (s.length() <= 1) {
            return s;
        }
        while (i < s.length()) {
            //偶数
            calculate( i, i + 1, longest, s );
            //奇数
            calculate( i, i, longest, s );
            i++;
        }
        return longest.toString();
    }

    /**
     * 判断是否为回文字符串，并记录最大子串
     * @param begin 字符起始位置
     * @param end 字符结束位置
     * @param longest 最长子串
     * @param s 输入字符串
     */
    private void calculate(int begin, int end, StringBuilder longest, String s) {
        while (begin >= 0 && end < s.length()) {
            if (s.charAt( begin ) == s.charAt( end )) {
                if (end - begin + 1 > longest.length()) {
                    longest.delete( 0, longest.length() );
                    longest.append( s.substring( begin, end + 1 ) );
                }
                begin--;
                end++;
            } else {
                break;
            }
        }
    }
}
