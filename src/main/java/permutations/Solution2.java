package main.java.permutations;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @program: LeetCode
 * @description: 全排列，不包含重复
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * @author: hejy
 * @create: 2019-08-29
 **/
public class Solution2 {
    /**
     * 思路：
     * 回溯法+剪枝
     * 剪枝的核心在于首先需要对对象进行排序，这样在递归的时候方便判断
     * 判断当前元素和前一个元素是否相同，且前一个元素是否已经使用过
     *
     * @param nums 数组
     * @return 结果
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        //剪枝的话需要先将数组排序
        Arrays.sort( nums );
        this.permuteUnique2( nums, new Stack<>(), new boolean[nums.length], result );
        return result;
    }

    /**
     * 回溯法+剪枝
     *
     * @param nums      数组
     * @param tempStack 临时栈
     * @param isUsed    状态数组
     * @param result    结果集
     */
    private void permuteUnique2(int[] nums, Stack<Integer> tempStack, boolean[] isUsed, List<List<Integer>> result) {
        //判断是否到叶子结点
        if (tempStack.size() == nums.length) {
            result.add( new LinkedList<>( tempStack ) );
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!isUsed[i]) {
                //判断是否要剪枝，前一个元素是否一样且被用过
                if (i > 0 && nums[i] == nums[i - 1] && isUsed[i - 1]) {
                    continue;
                }
                isUsed[i] = true;
                tempStack.add( nums[i] );
                permuteUnique2( nums, tempStack, isUsed, result );
                tempStack.pop();
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result;
        int[] nums = {1, 1, 2};
        Solution2 solution2 = new Solution2();
        result = solution2.permuteUnique( nums );
        result.forEach( list -> System.out.println( list ) );
    }
}
