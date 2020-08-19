package com.lyt.java;

//题目　
//	数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的
//数组{1, 2, 3, 2, 2, 2, 5, 4, 2}。由于数字2在数组中出现了5次，超过数组长度的一半，
//因此输出2。
//思路：数字次数超过一半，则说明：该数字出现的次数比其他数字之和还多
//	遍历数组过程中保存两个值：一个是数组中某一数字，另一个是次数。遍历到下一个数字时，
//若与保存数字相同，则次数加1，反之减1。若次数=0，则保存下一个数字，次数重新设置为1。
//由于要找的数字出现的次数比其他数字之和还多，那么要找的数字肯定是最后一次把次数设置
//为1的数字。
public class Offer39_MoreThanHalfNumbers {
	/**
	 * 方法一：
	 * 		1.如果count次数等于0,设置当前数字暂为num
	 * 		2.当前数字和上一个数字一样,count++
	 *      判断次数是否超过一半
	 */
	public int MoreThanHalfNum_Solution2(int[] arr) {
		if (arr == null || arr.length <= 0)
			throw new RuntimeException("数组不合法");

		int num = arr[0];
		int count = 1;
		for (int i = 1; i < arr.length; i++) {
			if (count == 0) {
				num = arr[i];
				count = 1;
			} else if (arr[i] == num) {
				count++;
			} else {
				count--;
			}
		}

		if (count > 0) {
			int times = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == num)
					times++;
			}
			if (times * 2 > arr.length) {
				return num;
			}
		}
		throw new RuntimeException("不存在超过数组长度一半的数字");
	}

	public static void main(String[] args) {
		Offer39_MoreThanHalfNumbers demo = new Offer39_MoreThanHalfNumbers();
		int i = demo.MoreThanHalfNum_Solution2(new int[] { 2, 4, 3, 3, 3, 3, 5 });
		System.out.println(i);
	}

	// 方法二：partition方法
	public int MoreThanHalfNum_Solution(int[] array) {
		if (array == null || array.length <= 0)
			return 0;
		int low = 0;
		int high = array.length - 1;
		int index = partition(array, low, high);
		while (index != array.length >> 1) {
			if (index < array.length >> 1) {
				low = index + 1;
				index = partition(array, low, high);
			} else {
				high = index - 1;
				index = partition(array, low, high);
			}
		}
		// 判断次数是否超过一半
		int num = array[index];
		int times = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == num) {
				times++;
			}
		}
		if (times * 2 > array.length) {
			return num;
		}
		return 0;
	}

	private int partition(int[] array, int low, int high) {
		int pivotKey = array[low];
		while (low < high) {
			while (low < high && array[high] >= pivotKey)
				high--;
			int temp = array[low];
			array[low] = array[high];
			array[high] = temp;
			while (low < high && array[low] <= pivotKey)
				low++;
			temp = array[low];
			array[low] = array[high];
			array[high] = temp;
		}
		return low;
	}

}
