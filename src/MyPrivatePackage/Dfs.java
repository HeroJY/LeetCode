package MyPrivatePackage;

import java.util.Stack;

/**
 * Created by hjy on 2017/7/26.
 * 输入n个字符，实现全组合
 */
public class Dfs {
    public static void main(String[] args) {
        char[] num = {'A', 'B', 'C'};
        combiantion(num);

    }

    public static void combiantion(char chs[]) {
        if (chs.length == 0) return;

        Stack<Character> stack = new Stack<Character>();
        for (int i = 1; i <= chs.length; i++) {
            combine(chs, 0, i, stack);
        }
    }

    //从字符数组中第begin个字符开始挑选number个字符加入list中
    public static void combine(char[] chs, int begin, int number, Stack<Character> stack) {
        //终结条件为两个
        //第一个：组合的数达到要求时，打印组合
        if (number == 0) {
            System.out.println(stack.toString());
            return;
        }
        //第二个：当取的数为最后一个时，就算没有达到组合数的个数也依旧返回
        if (begin == chs.length) {
            return;
        }
        //把这个字符放进组合中
        stack.push(chs[begin]);
        combine(chs, begin + 1, number - 1, stack);
        //把这个字符不放进组合中
        stack.pop();
        //在剩下的字符中继续选择组合
        combine(chs, begin + 1, number, stack);
    }
}
