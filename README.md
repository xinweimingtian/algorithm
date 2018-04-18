# algorithm
学习的算法知识


##一、sort        数组排序

	1.BubbleSort 冒泡排序 时间复杂度O(N^2)，额外空间复杂度O(1)，实现可以做到稳定性；

	2.InsertionSort 插入排序
	时间复杂度O(N^2)，额外空间复杂度O(1)，实现可以做到稳定性；
	运行时间取决于输入中元素的初始顺序，对一个已经有序或者接近有序的数组排序顺将比随机顺序数组或逆序数组进行排序要快的多。

	3.SelectionSort 选择排序 
	时间复杂度O(N^2)，额外空间复杂度O(1)，实现可以做到稳定性；
	运行时间和输入无关，每次都要找到最小的值。
	数据移动是最少的，每次就交换数组两个元素的值。

	4.MergeSort 归并排序 时间复杂度O(N*logN)，额外空间复杂度O(N)，实现可以做到稳定性；
	无论最好还是最坏均为： O(nlgn); 空间复杂度为 O(n);

	5.QuickSort 随机快速排序 时间复杂度O(N*logN)，额外空间复杂度O(logN)，常规实现做不到稳定性。（普通快速排序中额外空间复杂度最低为O(logN))；

	6.HeapSort 堆排序 时间复杂度O(N*logN)，额外空间复杂度O(1)，建立堆的操作O(N)，实现不能做到稳定性；

	7.BucketSort 桶排序 时间复杂度O(N)，额外空间复杂度O(N)，实现做到稳定性；
***
	
##二、 linked     队列、栈、链表、矩阵

	1.DogCatQueue 对dogcat队列进行封装，标记入队序号

	2.PalindromeNumber 判断链表是不是回文数

	3.PrintMatrixSpiralOrder 转圈打印矩阵

	4.TurnUpMatrixByk 在行列都排好序的矩阵中找数

	5.TwoLinkedCommon 打印两个有序链表的公共部分

	6.TwoQueuesStack 队列实现栈结构

	7.TwoStacksQueue 栈实现队列结构

	8.ZigZagPrintMatrix 之字形打印矩阵
