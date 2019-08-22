package main.java.permutations;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: LeetCode
 * @description: 全排列
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * @author: hejy
 * @create: 2019-08-21
 **/
public class Solution {
    /**
     * 思路，回溯法
     * 每次选择一个元素后问题规模都缩小，所以可以使用递归
     * 需要注意回溯的时候还原状态
     *
     * @param nums 数组
     * @return 结果
     */
    private List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        this.permutation( nums, result, new Stack<>(), new boolean[nums.length] );
        return result;
    }

    /**
     * 回溯法
     *
     * @param nums      数组
     * @param result    结果
     * @param tempStack 临时栈
     * @param isUsed    状态数组
     */
    private void permutation(int[] nums, List<List<Integer>> result, Stack<Integer> tempStack, boolean[] isUsed) {
        //遍历到叶子结点返回
        if (tempStack.size() == nums.length) {
            List<Integer> tempList = new ArrayList<>( tempStack );
            result.add( tempList );
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //这个位置被使用没
            if (!isUsed[i]) {
                //记录当前位置被使用
                isUsed[i] = true;
                //把使用的位置的值放入临时的栈
                tempStack.push( nums[i] );
                //递归使用下一个位置
                permutation( nums, result, tempStack, isUsed );
                //把上一个位置的状态还原
                isUsed[i] = false;
                //把上一个位置的值弹出栈
                tempStack.pop();
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result;
        result = solution.permute( nums );
        assert result != null;
        for (List list : result) {
            System.out.println( list );
        }
    }
}
