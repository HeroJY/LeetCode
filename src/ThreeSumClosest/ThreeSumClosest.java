package ThreeSumClosest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hjy on 2017/5/31.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int result = nums[0] + nums[1] + nums[nums.length - 1];

        int sum;

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i+1 , k = nums.length-1;
            //依旧找到比较点
            while(j<k){
                sum = nums[i] + nums[j] + nums[k];
                //找到指针移动的比较点
                if(sum > target){
                    k--;
                }else {
                    j++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSumClosest tsc = new ThreeSumClosest();

//        int[] a = {1, 1, 1, 0};
//        int[] a = {1,1,-1,-1,3};
        int[] a = {1,1,-1,-1,3};
        int target = -1;

        System.out.println(tsc.threeSumClosest(a, target));

    }
}
