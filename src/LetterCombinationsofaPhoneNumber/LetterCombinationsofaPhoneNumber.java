package LetterCombinationsofaPhoneNumber;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by hjy on 2017/6/7.
 * 觉得可以使用DFS或者BFS（这个需要接着看算法这本书）
 */
public class LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        //结果list
        List<String> result = new LinkedList<>();
        if (digits.length() == 0) {
            return result;
        }
        //准备映射
        String[] letter = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");
        //准备传入字符串
        for (int i = 0; i < digits.length(); i++) {
            //每次都要更新结果list
            result = combine(result, letter[digits.charAt(i) - '0']);
        }
        return result;
    }

    //这个方法返回结果list
    public List<String> combine(List<String> l, String letter) {
        List<String> result = new LinkedList<>();
        for (int i = 0; i < letter.length(); i++) {
            for (String x : l) {
                result.add(x + letter.charAt(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {

        String number = "";

        LetterCombinationsofaPhoneNumber lcp = new LetterCombinationsofaPhoneNumber();

        List<String> result = lcp.letterCombinations(number);

        for (String x : result) {
            System.out.println(x);
        }

    }
}
