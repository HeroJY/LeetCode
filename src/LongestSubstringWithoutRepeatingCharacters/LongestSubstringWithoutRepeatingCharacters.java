package LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hjy on 2017/5/17.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        int max=0;

        int j=0;

        Set<Character> comparison = new HashSet<Character>();//利用hashset来进行存储

        for(int i=0 ;i<s.length();i++){

            char char1 = s.charAt(i);

            if(!comparison.contains(char1)){
                comparison.add(char1);
                max= Math.max(max,comparison.size());//比较是否为最大值
            }else {
                i--;
                comparison.remove(s.charAt(j++));//删除第一个字符然后接着判断
            }

        }
        return max;

    }
}
