package sort;

/**
 * 冒泡排序 时间复杂度O(N^2)，额外空间复杂度O(1)，实现可以做到稳定性
 * 
 * @author whmAdmin
 * 
 */
public class BubbleSort {

	public static void bubbleSort(int[] arr) {
		if (null == arr || arr.length < 2) {
			return;
		}
		for (int j = arr.length - 1; j > 0; j--) {
			for (int i = 0; i < j; i++) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
				}
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
	}

}
