package RemoveDuplicatesFromSortedArray;

/**
 * Created by hjy on 2018/4/3.
 *
 * @author hjy
 *         给定一个有序数组，你需要原地删除其中的重复内容，使每个元素只出现一次,并返回新的长度。
 *         不要另外定义一个数组，您必须通过用 O(1) 额外内存原地修改输入的数组来做到这一点。
 *         <p>
 *         示例：
 *         给定数组: nums = [1,1,2],
 *         你的函数应该返回新长度 2, 并且原数组nums的前两个元素必须是1和2
 *         不需要理会新的数组长度后面的元素
 *
 *         思路：因为不需要管理数组后面的元素，因此只需要把数组中不重复的元素放在前面即可
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int i = 0;
        for (int n : nums) {
            //如果
            if (i == 0 || n > nums[i - 1]) {
                nums[i++] = n;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] test = {1, 1, 2};
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        int result = removeDuplicatesFromSortedArray.removeDuplicates( test );
        System.out.println( result );
    }
}
