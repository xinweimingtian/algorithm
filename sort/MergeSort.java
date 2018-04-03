package sort;

/**
 * 归并排序 时间复杂度O(N*logN)，额外空间复杂度O(N)，实现可以做到稳定性
 * @author whmAdmin
 *
 */
public class MergeSort {
	
	public static void mergeSort(int[] arr){
		if(null == arr || arr.length < 2){
			return;
		}
		
		mergeSortTest(arr, 0, arr.length-1);
	}

	public static void mergeSortTest(int[] arr, int L, int R) {
		// 如果左右下坐标相等，返回
		if(L == R){
			return;
		}
		
		// 获取中间下坐标
		int mid = L + (R - L) / 2;
		// 先排序左部分，左部分是L到mid中间这部分元素
		mergeSortTest(arr, L, mid);
		// 再排序右部分，右部分是mid中间后一位到R这部分元素
		mergeSortTest(arr, mid+1, R);
		// 对要排序的数组进行排序操作
		mergeSortArray(arr,L,mid,R);
		
	}

	public static void mergeSortArray(int[] arr, int L, int mid, int R) {
		//创建新数组
		int[] arrs = new int[R-L+1];
		//设置新数组开始坐标
		int i = 0;
		// 设置左部分开始指针
		int p1 = L;
		// 设置右部分开始指针
		int p2 = mid + 1;
		
		// 如果左指针坐标小于等于中间左边并且右指针坐标小于等于R最右坐标，继续循环。否则越界停止循环
		while(p1<=mid&& p2 <= R){
			// 比较左右两个指针上的元素大小，谁小就拷贝到新数组，并且指针位置++
			arrs[i++] = arr[p1] < arr[p2]?arr[p1++]:arr[p2++];
		}
		
		// 如果左指针位置比右指针所有位置元素都大，需要把剩余左部分全部拷贝到新数组
		while(p1<=mid){
			arrs[i++] = arr[p1++];
		}
		
		// 同理如果右指针位置比左指针所有位置的元素都大，需要把剩余右部分全部拷贝新数组
		while(p2<=R){
			arrs[i++] = arr[p2++];
		}
		// 以上左右指针拷贝只能出现一种
		
		// 把排序好的新数组元素拷贝到原数组中
		for (int j = 0; j < arrs.length; j++) {
			// L+1是要按原位置进行拷贝回去
			arr[L+j] = arrs[j];
		}
	}

}
