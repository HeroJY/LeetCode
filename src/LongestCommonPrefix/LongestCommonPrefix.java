package LongestCommonPrefix;

/**
 * Created by hjy on 2017/5/27.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0 || strs == null) {
            return "";
        }

        String result = strs[0];

        int i = 1;

        while (i < strs.length) {
            if (strs[i].indexOf(result) != 0) {
                result = result.substring(0, result.length() - 1);
            } else {
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();

        String[] strs = {"c", "acc","caa"};

        System.out.println(lcp.longestCommonPrefix(strs));
    }
}
