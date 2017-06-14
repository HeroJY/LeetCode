package ValidParentheses;
import java.util.Stack;

/**
 * Created by hjy on 2017/6/14.
 * 主要利用栈的思想来匹配
 * 当出现左括号的时候进栈（当匹配的字符全部都匹配完，栈不为空则错误）
 * 出现右括号的时候出栈（判断栈内是否为空，如果为空则错误）
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        //初始化一个栈
        Stack<Character> sk = new Stack<>();
        //一个一个字符判断
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                //进栈
                sk.push(s.charAt(i));
            }
            if(s.charAt(i) == '{'){
                //进栈
                sk.push(s.charAt(i));
            }
            if(s.charAt(i) == '['){
                //进栈
                sk.push(s.charAt(i));
            }
            if (s.charAt(i) == ')') {
                //判断是否栈为空
                if (sk.empty() || !sk.peek().equals('(')) {
                    return false;
                }
                //出栈
                sk.pop();
            }
            if (s.charAt(i) == '}') {
                //判断是否栈为空
                if (sk.empty() || !sk.peek().equals('{')) {
                    return false;
                }else{
                    //出栈
                    sk.pop();
                }
            }
            if (s.charAt(i) == ']') {
                //判断是否栈为空
                if (sk.empty() || !sk.peek().equals('[')) {
                    return false;
                }
                //出栈
                sk.pop();
            }
        }
        //循环结束后判断栈是否为空
        if (sk.empty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        String s = "()";
        System.out.println(vp.isValid(s));
    }
}
