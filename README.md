# algorithm
学习的算法知识


1.sort	数组排序
	BubbleSort 冒泡排序 时间复杂度O(N^2)，额外空间复杂度O(1)，实现可以做到稳定性
	InsertionSort 插入排序 时间复杂度O(N^2)，额外空间复杂度O(1)，实现可以做到稳定性
	SelectionSort 选择排序 时间复杂度O(N^2)，额外空间复杂度O(1)，实现可以做到稳定性
	MergeSort 归并排序 时间复杂度O(N*logN)，额外空间复杂度O(N)，实现可以做到稳定性
	QuickSort 随机快速排序 时间复杂度O(N*logN)，额外空间复杂度O(logN)，常规实现做不到稳定性。（普通快速排序中额外空间复杂度最低为O(logN)）
	HeapSort 堆排序 时间复杂度O(N*logN)，额外空间复杂度O(1)，建立堆的操作O(N)，实现不能做到稳定性
	BucketSort 桶排序 时间复杂度O(N)，额外空间复杂度O(N)，实现做到稳定性
	
2. linked 队列、栈、链表、矩阵
	DogCatQueue 对dogcat队列进行封装，标记入队序号
	PalindromeNumber 判断链表是不是回文数
	PrintMatrixSpiralOrder 转圈打印矩阵
	TurnUpMatrixByk 在行列都排好序的矩阵中找数
	TwoLinkedCommon 打印两个有序链表的公共部分
	TwoQueuesStack 队列实现栈结构
	TwoStacksQueue 栈实现队列结构
	ZigZagPrintMatrix 之字形打印矩阵