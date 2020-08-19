package com.lyt.java;

import java.util.ArrayList;
import java.util.Arrays;

//题目　
//	输入n个整数，找出其中最小的k个数。例如输入4、5、1、6、2、7、3、8这8个数字，
//则最小的4个数字是1、2、3、4。
//思路
//	思路一：同剑指offer(39) 数组中出现次数超过一半的数字中使用partition()方法，
//基于数组的第k个数字调整，使得更小的k个数字都在数组左边即可。
//	思路二：依次遍历n个整数，用一个容器存放最小的k个数字，每遇到比容器中最大的数字
//还小的数字时，将最大值替换为该数字。容器可以使用最大堆或者红黑树来实现。本文根据
//堆排序的原理来实现。特别适合处理海量数据，磁盘无限大，内存只能够存入k个数，每次
//从磁盘中取数字,比较内存中的数字放入与否。
//扩展：最大的k个数。修改最小堆,和比较放入条件即可。（① ② ③）
public class Offer40_KLeastNumbers {
	/**
	 * 方法一：基于堆的容器，时间复杂度O(nlogk)
	 * 		1.先放入前k个数
	 * 		2.将数组构造成最大堆形式,上浮
	 * 		3.存在更小的数字时, 重新调整最大堆,下沉
	 * @param input
	 * @param k 数组容器
	 * @return
	 */
	public int[] getLeastNumbers(int[] input, int k) {
		if (input == null || k <= 0 || k > input.length)
			return new int[] {};

		int[] numbers = new int[k];
		for (int i = 0; i < k; i++)
			numbers[i] = input[i];
		for (int i = k / 2 - 1; i >= 0; i--) {
			adjustHeap(numbers, i, k - 1);
		}
		for (int i = k; i < input.length; i++) {
			if (input[i] < numbers[0]) { // ①
				numbers[0] = input[i];
				adjustHeap(numbers, 0, k - 1);
			}
		}
		return numbers;
	}

	// 调整成最大堆
	private void adjustHeap(int[] arr, int start, int end) {
		int temp = arr[start];
		int child = start * 2 + 1;
		while (child <= end) {
			if (child + 1 <= end && arr[child] < arr[child + 1])// ②
				child++;
			if (arr[child] < temp)// ③
				break;
			arr[start] = arr[child];
			start = child;
			child = child * 2 + 1;
		}
		arr[start] = temp;
	}

	public static void main(String[] args) {
		Offer40_KLeastNumbers demo = new Offer40_KLeastNumbers();
		int[] arr = new int[] { 4, 5, 1, 6, 2, 7, 3, 8 };
		int k = 4;
		int[] leastNumbers = demo.getLeastNumbers(arr, k);
		System.out.print("最小的" + k + "个数是：" + Arrays.toString(leastNumbers));
	}

	/*
	 * 方法二：采用partition() 时间复杂度O(n)
	 */
	public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
		ArrayList<Integer> leastNumbers = new ArrayList<Integer>();
		while (input == null || k <= 0 || k > input.length)
			return leastNumbers;
		int start = 0;
		int end = input.length - 1;
		int index = partition(input, start, end);
		while (index != k - 1) {
			if (index < k - 1) {
				start = index + 1;
				index = partition(input, start, end);
			} else {
				end = index - 1;
				index = partition(input, start, end);
			}
		}
		for (int i = 0; i < k; i++) {
			leastNumbers.add(input[i]);
		}
		return leastNumbers;
	}

	private int partition(int[] arr, int start, int end) {
		int pivotKey = arr[start];
		while (start < end) {
			while (start < end && arr[end] >= pivotKey)
				end--;
			swap(arr, start, end);
			while (start < end && arr[start] <= pivotKey)
				start++;
			swap(arr, start, end);
		}
		return start;
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
