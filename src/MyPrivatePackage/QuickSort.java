package MyPrivatePackage;

/**
 * Created by hjy on 2017/8/9.
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {2, 6, 1, 45, 23};
        quick(a, 0, a.length - 1);
        for (int x : a) {
            System.out.println(x);
        }
    }


    //快排的逻辑
    public static void quick(int[] num, int start, int end) {
        if (start >= end) {
            return;
        }
        //头指针
        int i = start;
        //尾指针
        int j = end;
        //确定标准值（一般用第一个数）
        int key = num[start];
        while (i < j) {
            while (i < j && num[j] > key) {
                j--;
            }
            if (i < j) {
                num[i] = num[j];
            }
            while (i < j && num[i] < key) {
                i++;
            }
            if (i < j) {
                num[j] = num[i];
            }
        }
        num[i] = key;
        quick(num, start, j - 1);
        quick(num, i + 1, end);
    }
}
