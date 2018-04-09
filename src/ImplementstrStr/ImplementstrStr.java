package ImplementstrStr;

import interview.Lcs;

/**
 * Created by hjy on 2018/4/8.
 *
 * @author hjy
 *         实现 strStr()。
 *         返回蕴含在 haystack 中的 needle 的第一个字符的索引，如果 needle 不是 haystack 的一部分则返回 -1 。
 *         例 1:
 *         输入: haystack = "hello", needle = "ll"
 *         输出: 2
 *         <p>
 *         例 2:
 *         输入: haystack = "aaaaa", needle = "bba"
 *         输出: -1
 *         <p>
 *         思路kmp算法
 *         kmp算法主要是可以跳过已匹配过的字符，利用next数组来进行跳过（即被匹配的字符串（hello）不回退，匹配的字符串回退（ll））。
 *         核心在于关注匹配串自身的next数组
 *         具体步骤：
 *         1.求字符串前缀后缀最长公共元素长度表
 *         2.根据字符串前缀后缀最长公共元素长度表求出next数组，把长度表整体向右移一位，然后初值设为-1即可
 *         3.根据next数组进行匹配：匹配时如果遇到失配就根据next数组值向左移动位数，
 *         因为每次失配的时候只需要关注失配字符的前一个字符的前缀后缀最长公共元素长度
 *         规则为：失配字符所在位置减去失配字符对应的next值。
 */
public class ImplementstrStr {
    public static void getNext(String s, int[] next) {
        int len = s.length();
        char[] str = s.toCharArray();
        int i = 0;
        int j = -1;
        //默认next数组第一位为-1
        next[0] = -1;
        while (i < len - 1) {
            if (j == -1 || str[i] == str[j]) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
    }

    public static int strStr(String haystack, String needle) {
        if (haystack.equals( "" ) && needle.equals( "" )) {
            return 0;
        }
        if (haystack.equals( "" )) {
            return -1;
        }
        if (needle.equals( "" )) {
            return 0;
        }

        int i = 0;
        int j = 0;
        int slen = haystack.length();
        int plen = needle.length();

        int[] next = new int[plen];

        getNext( needle, next );

        while (i < slen && j < plen) {
            if (j == -1 || haystack.charAt( i ) == needle.charAt( j )) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j >= plen) {
            return i - j;
        }
        return -1;
    }


    public static void main(String[] args) {
        String a = "mississippi";
        String b = "issip";
        String c = "aba";
        String d = "baba";
        String e = "abcdabd";
        int next[] = new int[e.length()];
//        ImplementstrStr.getNext( c,next);
        System.out.println( next.toString() );
        System.out.println( ImplementstrStr.strStr( d, c ) );
    }
}
