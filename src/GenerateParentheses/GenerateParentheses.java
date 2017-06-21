package GenerateParentheses;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by hjy on 2017/6/21.
 * 使用DFS算法，未使用栈（先进先出），使用函数递归
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        //使用dfs
        dfs(result, n, n, "");
        return result;
    }

    /**
     * @param result 结果集
     * @param left   左括号个数
     * @param right  右括号个数
     * @param out    一个结果的字符串
     */
    public void dfs(List<String> result, int left, int right, String out) {
        //如果左括号小于0，或者右括号小于0，或者左括号大于右括号则退出
        if (left < 0 || right < 0 || left > right) {
            return;
        }
        //如果左右括号都用完，那就记录下这个结果,并退出
        if (left == 0 && right == 0) {
            result.add(out);
            return;
        }
        //这里使用DFS算法，采用递归，首先穷尽左括号
        dfs(result, left - 1, right, out + "(");
        //再添加右括号
        dfs(result, left , right-1, out + ")");
    }

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        List<String> result = gp.generateParenthesis(0);
        for(String a : result){
            System.out.println(a);
        }
    }
}
