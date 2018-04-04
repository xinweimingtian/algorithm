# algorithm
学习的算法知识


1.sort	数组排序
	BubbleSort 冒泡排序 时间复杂度O(N^2)，额外空间复杂度O(1)，实现可以做到稳定性；
	
	InsertionSort 插入排序
		时间复杂度O(N^2)，额外空间复杂度O(1)，实现可以做到稳定性；
		运行时间取决于输入中元素的初始顺序，对一个已经有序或者接近有序的数组排序顺将比随机顺序数组或逆序数组进行排序要快的多。
	
	SelectionSort 选择排序 
		时间复杂度O(N^2)，额外空间复杂度O(1)，实现可以做到稳定性；
		运行时间和输入无关，每次都要找到最小的值。
		数据移动是最少的，每次就交换数组两个元素的值。
	
	MergeSort 归并排序 时间复杂度O(N*logN)，额外空间复杂度O(N)，实现可以做到稳定性；
		无论最好还是最坏均为： O(nlgn); 空间复杂度为 O(n);
	
	QuickSort 随机快速排序 时间复杂度O(N*logN)，额外空间复杂度O(logN)，常规实现做不到稳定性。（普通快速排序中额外空间复杂度最低为O(logN)）；
	
	HeapSort 堆排序 时间复杂度O(N*logN)，额外空间复杂度O(1)，建立堆的操作O(N)，实现不能做到稳定性；
	
	BucketSort 桶排序 时间复杂度O(N)，额外空间复杂度O(N)，实现做到稳定性；
	
	
