package MyPrivatePackage;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by hjy on 2017/8/9.
 * 二维数组排序(冒泡排序)
 */
public class DoubleDimensionalArray {
    public static void main(String[] args) {
        int[][] num = {{5, 7, 1, 9, 3}, {7, 9, 1, 5, 79}, {15, 34, 29, 57}, {11, 42, 74, 34}};
        List<LinkedList<Integer>> result = new LinkedList<>();
        sort(num);
        for (int i = 0; i < num.length; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < num[i].length; j++) {
                list.add(num[i][j]);
            }
            result.add(list);
        }
        System.out.println(result);
    }

    public static void sort(int[][] num) {
        for (int i = 0; i < num.length; i++) {
            //使用冒泡法排序
            for (int j = 0; j < num[i].length; j++) {
                for (int k = 0; k < num[i].length - j - 1; k++) {
                    if (num[i][k] > num[i][k + 1]) {
                        int temp = num[i][k];
                        num[i][k] = num[i][k + 1];
                        num[i][k + 1] = temp;
                    }
                }
            }
        }
    }
}
