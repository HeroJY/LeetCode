package MedianofTwoSortedArrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by hjy on 2017/5/18.
 */
public class MedianofTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        double result = 0.0;

        ArrayList<Integer> nums = new ArrayList<Integer>();

        int i = 0;

        int j = 0;

        int m;

        int aNums1 = nums1.length;

        int aNums2 = nums2.length;

        //合并两个有序数组
        while(i<aNums1){
            nums.add(nums1[i++]);
        }
        while(j<aNums2){
            nums.add(nums2[j++]);
        }
        Collections.sort (nums);



        //求数组的中位数
        int num = nums.size() % 2;
        if (num == 0) {//如果数组长度为偶数
            m = nums.size() / 2;
            result = (nums.get(m-1) + nums.get(m)) / 2.0;
        } else {
            m = nums.size() / 2;
            result = nums.get(m);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] a = {1,2};

        int[] b = {3,4};

        double c;

        MedianofTwoSortedArrays mtsa = new MedianofTwoSortedArrays();

        c = mtsa.findMedianSortedArrays(a, b);
        System.out.println(c);

    }
}
