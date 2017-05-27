package IntegertoChinese;

/**
 * Created by hjy on 2017/5/27.
 */
public class IntegertoChinese {
    public String convert(int num) {
        String result = "";
        int i = 0;
        int j = 0;
        int tNum;
        String[] number = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        String[] unit = {"", "十", "百", "千", "万", "亿"};
        while (num != 0) {
            tNum = num % 10;
            //判断是否到亿
            if (j > 0 && i > 3) {
                i = 5;
                result = number[tNum] + unit[i++] + result;
                i = 1;
                j = 0;
            } else {
                //判断是否到万
                if (i >= 5) {
                    i = 1;
                    result = number[tNum] + unit[i++] + result;
                    j++;
                } else {
                    result = number[tNum] + unit[i++] + result;
                }
            }
            num = num / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        IntegertoChinese t = new IntegertoChinese();
        int a = 1234567891;
        String result = t.convert(a);
        System.out.println(result);
    }
}
