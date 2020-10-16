package com.ming.exercise.leetcode.array;

/**
 * @Description RotationMatrix
 * @Author Administrator
 * @Date 2020/8/6 22:45 2020
 *
 * 面试题 01.07 旋转矩阵
 *
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 *
 *  不占用额外内存空间能否做到？
 *
 *
 *
 *  示例 1:
 *
 *  给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 *
 *  示例 2:
 *
 *  给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 *
 */
public class RotationMatrix {

    // 先进性上下进行翻转
    // 在进行主对角线 \ 翻转（\中间的不动）
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length < 0) {
            return;
        }

        int temp;
        int len = matrix.length;
        // 先进行对角线上下翻转
        for (int i = 0; i < len / 2; i++) {
            for (int j = 0; j < len; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[len - i - 1][j];
                matrix[len - i - 1][j] = temp;
            }
        }

        // 主对角线翻转
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
