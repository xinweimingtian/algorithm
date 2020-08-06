package com.ming.exercise.leetcode.array;

/**
 * @Description ZeroMatrix
 * @Author Administrator
 * @Date 2020/8/6 22:54 2020
 *
 * 面试题 01.08 零矩阵
 *
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 *
 *  示例 1：
 *
 *  输入：
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出：
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 *
 *
 *  示例 2：
 *
 *  输入：
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出：
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 *
 */
public class ZeroMatrix {

    public void setZeroes(int[][] matrix) {
        // 将行列信息存放在原数组的第一行和第一列
        // 标记行和列是否需要清零
        boolean shu = false;
        boolean hang = false;
        // 循环标记 查询行列的0值
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) { // 行为0  标记
                        hang = true;
                    }
                    if (j == 0) { // 竖为0  标记
                        shu = true;
                    }
                    // 标记当前行列的开头为0  进行记录重置依据
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 从下坐标开始遍历 找到所有列开头是0的 重置为0
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) { // 重置当前行
                for (int j = 1; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 重置行
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        // 重置第一行 第一列
        if (shu) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if (hang) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
    }

}
