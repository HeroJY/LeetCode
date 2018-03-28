package TwoSum;

/**
 * Created by hjy on 2018/3/28.
 * 在数组中计算是否包含目标数字
 * 思路：使用两重循环遍历求和
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length-1; i++)
        {
            for(int j = i+1; j < nums.length; j++)
            {
                if(nums[i] + nums[j] == target){
                    return new int [] {i,j};
                }
            }
        }
        return new int[] {0,0};
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] a = {2, 7, 11, 15};
        int[] result = twoSum.twoSum( a,9 );
        for(int x : result){
            System.out.println(x);
        }
    }
}
