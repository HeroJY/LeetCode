package main.java.binarytreelevelordertraversal;

import main.java.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 二叉树的层次遍历
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * @author: hejy
 * @create: 2019-09-03
 **/
public class Solution {
    List<List<Integer>> result = new LinkedList<>();

    /**
     * 思路1：采用DFS，但是加入了层级的概念，这样在递归的时候巧妙的把队列中的list位置作为层级判断
     * 所以本质上是DFS，只不过多了一个层级的限制
     *
     * @param root 根节点
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        this.searchNode( root, result, 0 );
        return result;
    }

    /**
     * 递归（DFS）
     *
     * @param root   当前节点
     * @param result 结果集
     * @param level  层级标示
     */
    public void searchNode(TreeNode root, List<List<Integer>> result, int level) {
        //判断根节点是否为空
        if (root == null) {
            return;
        }
        //判断当前层级是否有队列，如果没有就新建一个队列(队列的位置就是层级)
        if (result.size() <= level) {
            result.add( new LinkedList<>() );
        }
        //将当前的节点放入层级队列
        result.get( level ).add( root.val );
        //判断左节点，并且层级+1
        if (root.left != null) {
            searchNode( root.left, result, level + 1 );
        }
        //判断右节点，并且层级+1
        if (root.right != null) {
            searchNode( root.right, result, level + 1 );
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode( 3 );
        treeNode.left = new TreeNode( 9 );
        treeNode.right = new TreeNode( 20 );
        treeNode.right.left = new TreeNode( 15 );
        treeNode.left.right = new TreeNode( 7 );
        Solution solution = new Solution();
        List<List<Integer>> result = solution.levelOrder( treeNode );
        result.forEach( integer -> System.out.println( integer ) );
    }
}
