package MyPrivatePackage;

/**
 * Created by hjy on 2017/8/9.
 * 逆序输出一句英文句子
 */
public class ReverseSentence {
    public static void main(String[] args) {
        String s = "I have an apple";
        reverse(s);
        System.out.println(s);
    }

    public static void reverse(String s) {
        String result = "";
        int i = 0;
        //先获取每个单词
        String[] str = s.split(" ");
        //逆序输出单词
        while (i < str.length) {
            result = result + str[str.length - 1 - i] + " ";
            i++;
        }
        System.out.println(result);
    }
}
