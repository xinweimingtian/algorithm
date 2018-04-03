package sort;


/**
 * 插入排序 时间复杂度O(N^2)，额外空间复杂度O(1)，实现可以做到稳定性
 * @author whmAdmin
 *
 */
public class InsertionSort {

	public static void insertionSort(int[] arr){
		if(null == arr || arr.length < 2){
			return;
		}
		for (int i = 1; i < arr.length; i++) {
			for(int j = i - 1;j>=0 && arr[j] > arr[j+1];j--){
				swap(arr, j, j + 1);
			}
		}
	}
	
	public static void swap(int[] arr, int i, int j) {
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
	}
}
