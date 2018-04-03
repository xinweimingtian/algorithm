package sort;

/**
 * 随机快速排序 时间复杂度O(N*logN)，额外空间复杂度O(logN)，常规实现做不到稳定性。（普通快速排序中额外空间复杂度最低为O(logN)）
 * @author whmAdmin
 *
 */
public class QuickSort {

	public static void quickSort(int[] arr){
		if(null == arr || arr.length < 2){
			return;
		}
		quickSort(arr, 0, arr.length-1);
	}
	
	public static void quickSort(int[] arr, int L, int R){
		if(L < R){
			swap(arr, L + (int)(Math.random() * (R - L + 1)), R);
			int[] p = partition(arr, L, R);
			quickSort(arr, L, p[0] - 1);//从 最左边开始到 等于区域前
			quickSort(arr, p[1] + 1, R); //从大于区域后一位开始 到最右
			
		}
	}
	
	public static int[] partition(int[] arr, int L,int R){
		// 小于区域坐标
		int less = L - 1;
		// 大于区域坐标（在右侧，往左侧移动）
		int more = R;
		while(L < more){ // 左边坐标和大于区域碰撞 停止循环
			// 如果左边元素小于最右边选择的元素
			if(arr[L] < arr[R]){
				// 小于区域位置边界增加 然后把小于位置元素和左边元素替换
				// 左边坐标增加
				swap(arr,++less,L++);
			// 如果左边的元素大于最右边的元素
			}else if(arr[L] > arr[R]){
				// 大于区域位置边界减少 然后把大于区域位置元素和左边元素替换
				// 左边左边不变
				swap(arr,--more,L);
			}else{ //相等  坐标左边增加
				L++;
			}
		}
		
		swap(arr,more,R); // 最后替换大于区域边界坐标和最右边坐标
		// 返回等于区域坐标
		return new int[] {less + 1, more};
	}
	
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
