package sort;

/**
 * 选择排序 时间复杂度O(N^2)，额外空间复杂度O(1)，实现可以做到稳定性
 * @author whmAdmin
 *
 */
public class SelectionSort {

	public static void selectionSort(int[] arr){
		if(null == arr || arr.length < 2){
			return;
		}
		
		for (int i = 0; i < arr.length-1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				min = arr[j] < arr[min]?j:min;
			}
			swap(arr,i,min);
		}
	}

	
	public static void swap(int[] arr, int i, int j) {
		// 使用位运算交换就有问题 使用第三方变量就没问题
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
