package FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hjy on 2017/6/9.
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length == 0) {
            return result;
        }
        //第一步：对数组排序，为了后面遍历时不出错
        Arrays.sort(nums);
        //第一层循环，确定第一个指针位置
        for (int i = 0; i < nums.length - 3; i++) {
            int a = nums[i];
            //第二层循环也确认一个指针位置
            for (int j = i + 1; j < nums.length - 2; j++) {
                int b = nums[j];
                //第三层开始确认两个指针开始进行计算
                for (int k = j + 1, l = nums.length - 1; k < l; k++) {
                    int c = nums[k], d = nums[l];
                    //开始计算
                    while (k < l && a + b + c + (d = nums[l]) > target) {
                        l--;
                    }
                    if (a + b + c + d == target) {
                        result.add(Arrays.asList(a, b, c, d));
                    }
                    //排除k重复的
                    while (k < nums.length - 1 && nums[k] == nums[k + 1]) {
                        k++;
                    }
                }
                //排除j重复的
                while (j < nums.length - 2 && nums[j] == nums[j + 1]) {
                    j++;
                }
            }
            //排除i重复的
            while (i < nums.length - 3 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FourSum fs = new FourSum();

//        int[] a = {1, 0, -1, 0, -2, 2};

//        int[] a = {-3, -2, -1, 0, 0, 1, 2, 3};

        int[] a = {0, 0, 0, 0};
        int target = 0;

        List<List<Integer>> result = fs.fourSum(a, target);

        for (List<Integer> x : result) {
            System.out.println(x);
        }
    }
}
