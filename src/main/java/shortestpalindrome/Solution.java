package main.java.shortestpalindrome;

/**
 * @program: LeetCode
 * @description: 解答
 * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。
 * 找到并返回可以用这种方式转换的最短回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "aacecaaa"
 * 输出: "aaacecaaa"
 * 示例 2:
 * <p>
 * 输入: "abcd"
 * 输出: "dcbabcd"
 * @author: hejy
 * @create: 2019-04-04
 **/
public class Solution {
    /**
     * 判断当前字符串是否存在回文子串
     * 如果没有，就已第一个字符为对称中心添加前面的子串
     * 如果有，就找到回文子串的对称中心，再来一一对比
     * 使用最长回文串找到回文串（时间超时）
     * 修改为对位置的记录，减少空间复杂度
     * 如何减少时间复杂度？？（尝试把奇偶判断放入方法中的循环？）
     * 看了解答有一个很厉害的思路：
     * 把字符串反转之后与原来进行匹配，然后连接在一起。匹配可以把KMP稍微修改一下！！（可以在修改后尝试一下）
     */
    private StringBuilder result;
    private int endFlag = 0;
    private boolean flag = true;

    public Solution() {
        result = new StringBuilder();
    }

    public String shortestPalindrome(String s) {
        int i = 0;

        if (s.length() <= 1) {
            return s;
        }

        while (i < s.length()) {
            //奇数
            calculate( i, i, s );
            //偶数
            calculate( i, i + 1, s );
            i++;
        }

        if (!flag) {
            endFlag = 0;
        }

        for (int j = s.length() - 1; j > endFlag; j--) {
            result.append( s.charAt( j ) );
        }

        result.append( s );
        return result.toString();
    }

    /**
     * 计算最大回文子串的下标
     *
     * @param begin
     * @param end
     * @param s
     */
    private void calculate(int begin, int end, String s) {
        while (begin >= 0 && end < s.length()) {
            if (s.charAt( begin ) == s.charAt( end )) {
                if (begin == 0) {
                    this.endFlag = end;
                    this.flag = true;
                }
                begin--;
                end++;
            } else {
                break;
            }
        }
    }
}
