package main.java.palindromepairs;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 解答
 * 给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词，
 * words[i] + words[j] ，可拼接成回文串。
 *
 * 示例 1:
 *
 * 输入: ["abcd","dcba","lls","s","sssll"]
 * 输出: [[0,1],[1,0],[3,2],[2,4]]
 * 解释: 可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
 * 示例 2:
 *
 * 输入: ["bat","tab","cat"]
 * 输出: [[0,1],[1,0]]
 * 解释: 可拼接成的回文串为 ["battab","tabbat"]
 * @author: hejy
 * @create: 2019-04-11
 **/
public class Solution {
    /**
     * 336. 回文对
     * 2019-04-11
     * 首先遍历所有的数组
     * 其次判断当前数组是否是自己，不是的话就拼接
     * 判断拼接的字符串是否为回文串
     * 92 / 134 个通过测试用例（该思路超时）
     *
     * 之后更新思路
     *
     * @param words 输入数组
     * @return 返回结果
     */
    public ArrayList palindromePairs(String[] words) {

        ArrayList result = new ArrayList();


        StringBuilder tempString = new StringBuilder();

        boolean flag;

        if(words.length <= 1){
            return result;
        }

        for(int i = 0 ; i < words.length ; i++){
            for(int j = 0; j < words.length; j++){
                //判断是否是自己
                if(i == j){
                    continue;
                }
                //判断合并后是否为回文串
                tempString.append(words[i]);
                tempString.append(words[j]);
                flag = calculate(tempString);
                if(flag){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    result.add(temp);
                }
                tempString.setLength( 0 );
            }
        }
        return result;
    }

    /**
     * 判断是否是回文串
     */
    private boolean calculate(StringBuilder s){
        int i;
        int j;
        if(s.length() <= 1){
            return true;
        }
        //判断奇偶
        if(s.length() % 2 ==0){
            i = s.length() / 2;
            j = i - 1;
        }else{
            i = s.length() / 2;
            j = i;
        }

        while(j >= 0 && i < s.length()){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else {
                break;
            }
        }

        return j == -1 && i == s.length();

    }
}
