package com.ming.exercise.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Description MergeInterval
 * @Author Administrator
 * @Date 2020/8/6 22:17 2020
 *
 * 56. 合并区间
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 *  示例 1:
 *
 *  输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 *
 *  示例 2:
 *
 *  输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 */
public class MergeInterval {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }

        // 按照起点顺序进行排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // 也可以使用Stack存储， 只关心结果集的最后一个区间
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        // 遍历循环
        for (int i = 1; i < intervals.length; i++) {
            int[] curIntervals = intervals[i]; // 获取当前二维数组中的数组元素

            // 每次新遍历的数组元素和当前结果集中最后一个数组元素的区间末尾段进行比较
            int[] peek = res.get(res.size() - 1);
            // 获取当前二维数组的头元素值和结果集元素的第二位比较
            if (curIntervals[0] > peek[1]) { // 如果大于 那就证明两个不没有交集
                res.add(curIntervals); // 加入结果集
            } else {
                // 获取最大的值 修改结果集
                peek[1] = Math.max(curIntervals[1], peek[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

}
