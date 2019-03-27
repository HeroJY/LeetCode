package main.java.interview;

/**
 * Created by hjy on 2018/3/22.
 *
 * @author hjy
 *         利用遍历字符串+kmp求最长公共子串
 *         <p>
 *         如输入：
 *         xabaxx
 *         abacxadxfaixfa
 *         输出：aba
 *         <p>
 */
public class Lcs {
    /**
     * 求两个字符串的最长公共子串
     * @param strOne 第一个字符串
     * @param strTwo 第二个字符串
     * @return
     */
    public static String maxSubstring(String strOne, String strTwo) {
        // 参数检查，防止空字符串
        if (strOne == null || strTwo == null) {
            return null;
        }
        if ("".equals( strOne ) || "".equals( strTwo )) {
            return null;
        }
        // 二者中较长的字符串
        String max;
        // 二者中较短的字符串
        String min;
        if (strOne.length() < strTwo.length()) {
            max = strTwo;
            min = strOne;
        } else {
            max = strTwo;
            min = strOne;
        }
        String current;
        // 遍历较短的字符串，并依次减少短字符串的字符数量，判断长字符是否包含该子串
        for (int i = 0; i < min.length(); i++) {
            for (int begin = 0, end = min.length() - i; end <= min.length(); begin++, end++) {
                current = min.substring( begin, end );
                //这里使用kmp代替indexOf方法
                if (Lcs.kmp( max, current ) >= 0) {
                    return current;
                }
            }
        }
        return null;
    }

    /**
     * 获取匹配字符串的next数组（原模式串子串对应的各个前缀后缀的公共元素的最大长度表右移一位）
     * 根据已知的前j位推测第j+1位
     *
     * @param pattern 匹配子串
     * @param next    next数组
     */
    public static void getNext(String pattern, int[] next) {
        int k = -1;
        int len = pattern.length();
        next[0] = -1;
        int j = 0;
        while (j < len - 1) {
            //next[k]表示前缀，next[j]表示后缀
            if (k == -1 || next[j] == next[k]) {
                ++k;
                ++j;
                next[j] = k;
            } else {
                k = next[k];
            }
        }

    }

    /**
     * 判断长字符串中是否包含匹配字符串的起始位数
     *
     * @param s       长字符串
     * @param pattern 匹配字符串
     * @return 长字符串中包含匹配字符串的起始位数，-1表示未匹配上
     */
    public static int kmp(String s, String pattern) {
        int i = 0;
        int j = 0;
        int slen = s.length();
        int plen = pattern.length();

        int[] next = new int[plen];

        //计算next数组
        getNext( pattern, next );

        //匹配时如果遇到失配就根据next数组值向左移动位数，规则为：失配字符所在位置-失配字符对应的next值
        while (i < slen && j < plen) {
            //当j=-1，或者当前字符匹配成功，则i和j都+1
            if (j == -1 || s.charAt( i ) == pattern.charAt( j )) {
                i++;
                j++;
            } else {
                //当j！=-1，且当匹配字符失配时，i不变，j=next[j]，即为j所对应的next值
                j = next[j];
            }
            if (j == plen) {
                return i - j;
            }
        }
        return -1;
    }

    /**
     * 测试主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        String strOne = "issip";
        String strTwo = "mississippi";
        String result = Lcs.maxSubstring( strOne, strTwo );
        System.out.println( result );
    }
}
