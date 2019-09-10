package main.java.flattenbinarytreetolinkedlist;

import main.java.TreeNode;


/**
 * @program: LeetCode
 * @description: 二叉树展开为链表
 * 给定一个二叉树，原地将它展开为链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 * @author: hejy
 * @create: 2019-09-09
 **/
public class Solution {
    /**
     * 思路：
     * 如果左节点不为空，拷贝右节点，把左节点放入右节点
     * 把左节点置为空
     * 找到新的右节点的最右节点
     * 把拷贝节点放入最右节点
     * 把根节点换成右节点
     *
     * @param root 根节点
     */
    private void flatten(TreeNode root) {
        this.preSearch( root );
    }

    /**
     * 展开二叉树
     *
     * @param root 根节点
     */
    public void preSearch(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
                continue;
            } else {
                TreeNode tempNode = root.right;
                root.right = root.left;
                root.left = null;
                TreeNode rightNode = root.right;
                while (rightNode.right != null) {
                    rightNode = rightNode.right;
                }
                rightNode.right = tempNode;
                root = root.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode( 1 );
        treeNode.left = new TreeNode( 2 );
        treeNode.left.left = new TreeNode( 3 );
        treeNode.left.right = new TreeNode( 4 );
        treeNode.right = new TreeNode( 5 );
        treeNode.right.right = new TreeNode( 6 );
        Solution solution = new Solution();
        solution.flatten( treeNode );
    }
}
