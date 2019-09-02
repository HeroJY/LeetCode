package main.java.binarytreeinordertraversal;

import main.java.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * @author: hejy
 * @create: 2019-09-02
 **/
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        this.search( root, result );
        return result;
    }

    /**
     * 递归遍历：左，根，右
     *
     * @param root   当前根节点
     * @param result 结果
     */
    private void search(TreeNode root, List<Integer> result) {
        if (root != null) {
            //先判断左节点是否为空
            if (root.left != null) {
                search( root.left, result );
            }
            //再判断根节点
            result.add( root.val );
            //再判断右节点
            if (root.right != null) {
                search( root.right, result );
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode( 1 );
        treeNode.left = null;
        treeNode.right = new TreeNode( 2 );
        treeNode.right.left = new TreeNode( 3 );
        Solution solution = new Solution();
        List<Integer> result = solution.inorderTraversal( treeNode );
        result.forEach( integer -> System.out.println( integer ) );
    }
}
