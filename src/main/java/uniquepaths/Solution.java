package main.java.uniquepaths;

/**
 * @program: LeetCode
 * @description: 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 * @author: hejy
 * @create: 2019-09-12
 **/
public class Solution {

    /**
     * 回溯法使用变量
     */
    int result;

    /**
     * 思路：
     * （1）最开始考虑回溯法进行暴力破解，但是超时。
     * （2）然后根据图开始考虑递归，当前节点只可能从上或者左节点过来，然后递归到初始节点。依旧超时，因为同一个节点值可能计算多次
     * （3）记录每个节点的值，这样减少重复计算的次数
     *
     * @param m 行数
     * @param n 列数
     * @return 结果
     */
    public int uniquePaths(int m, int n) {
        return this.caluateNodeValue( m - 1, n - 1, new int[m][n] );
    }

    /**
     * 回溯法 （超时）暴力破解
     * m=21,n=12时超时
     *
     * @param m      总行数
     * @param n      总列数
     * @param isUsed 记录节点
     * @param i      当前行
     * @param j      当前列
     */
    public void searchRoad(int m, int n, boolean[][] isUsed, int i, int j) {
        //判断是否到达终点
        if (i == m - 1 && j == n - 1) {
            result++;
            return;
        }
        //判断是否到达边界
        if (i > m - 1 || j > n - 1) {
            return;
        }
        //判断该节点是否被使用
        if (!isUsed[i][j]) {
            isUsed[i][j] = true;
            //向右判断
            searchRoad( m, n, isUsed, i, j + 1 );
            //向下判断
            searchRoad( m, n, isUsed, i + 1, j );
            //回溯之前的节点，更改已使用的节点
            isUsed[i][j] = false;
        }
    }

    /**
     * 递归（超时）开始考虑计算节点值，但未存储
     * 类似于斐波那契数列逻辑，但是依旧没有减少计算量
     * m=51,n=9时超时
     *
     * @param m 行数
     * @param n 列数
     * @return 结果
     */
    public int caluateRoad(int m, int n) {
        //如果边界则为1
        if (m - 1 < 0 || n - 1 < 0) {
            return 1;
        }
        //如果达到边界点，改点数值为1进行计算
        return caluateRoad( m - 1, n ) + caluateRoad( m, n - 1 );
    }

    /**
     * 递归，但记录每个节点的值，不需要重复计算
     * <p>
     * m=3,n=7
     * <p>
     * 1	1	1	1	1	1	1
     * 1	2	3	4	5	6	7
     * 1	3	6	10	15	21	28
     * <p>
     * 上表为小学常见类型：左边的值加上上边的值，等于当前节点值。用于判断路径条数
     *
     * @param m         行数
     * @param n         列数
     * @param nodeValue 当前节点值数组
     * @return 结果
     */
    public int caluateNodeValue(int m, int n, int[][] nodeValue) {
        //判断当前节点是否有值
        if (nodeValue[m][n] != 0) {
            return nodeValue[m][n];
        }
        //边界节点值为1
        if (m <= 0 || n <= 0) {
            nodeValue[m][n] = 1;
        } else {
            //递归求值
            nodeValue[m][n] = caluateNodeValue( m - 1, n, nodeValue ) + caluateNodeValue( m, n - 1, nodeValue );
        }

        return nodeValue[m][n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println( solution.uniquePaths( 23, 12 ) );
    }
}
