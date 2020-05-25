package com.ming.search;

/**
 *  二分查找
 * @author whmAdmin
 *  在10个元素中查询  大概需要4步
 *  在100个元素中查询  大概需要7步
 *  在1000个元素中查询  大概需要10步
 *
 *  因为  2^4 = 16   2^7 = 128  2^10 = 1024
 *  可知  log以2为底的log2(100) = 2
 *         log 以10为底的log10(100) = 2 * 3.22 即 6.44 约等于 7
 *         与2^7 大概相等
 */
public class BinarySearch {
	/**
	 * 二分查找有序数组 时间复杂度O(logN)
	 * @param searchKey
	 * @return
	 */
	public static long binarySearch(long[] arr, long searchKey) {
		// 下坐标
		int lowerBound = 0;
		// 上坐标
		int upperBound = arr.length - 1;
		// 中间坐标
		int curIn;
		
		while(true) {
			// 获取中间坐标 防止数据量大的时候内存溢出
			curIn = lowerBound + (upperBound - lowerBound) /2;
			// 中间坐标位置元素与查找元素相等
			if(arr[curIn] == searchKey) {
				// 返回下坐标
				return curIn;
			// 上坐标大于下坐标
			} else if(lowerBound > upperBound){
				// 返回总位置数
				return arr.length;
			} else{
				// 中间位置元素小于查找元素
				if(arr[curIn] < searchKey) {
					// 下坐标等于中间坐标后一位坐标上
					lowerBound = curIn+1;
				}else {
					// 否则 上坐标等于中间坐标前一位坐标上
					upperBound = curIn -1;
				}
			}
		}
	}
	
}
