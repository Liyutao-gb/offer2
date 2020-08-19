package com.lyt.java;

//题目
//	把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序
//的数组的一个旋转，输出旋转数组的最小元素。例如数组{3, 4, 5, 1, 2}为{1, 2, 3, 4, 5}
//的一个旋转，该数组的最小值为1。
//思路
//	数组在一定程度上是排序的，很容易分析出：可以采用二分法来寻找最小数字。
//但是这里面有一些陷阱：
//	1.递增排序数组的本身是自己的旋转，则最小数字是第一个数字
//	2.中间数字与首尾数字(三者一致)大小相等，如{1,0,1,1,1,1}和{1,1,1,1,0,1}，无法采用
//二分法，只能顺序查找
public class Offer11_MinNumberInRotatedArray {
	/**
	 * 1.数组本身是自身的旋转 
	 * 2.中间数字与首尾数字相等 
	 * 3.正常情况
	 */
	public int minNumberInRotateArray(int[] nums) {
		if (nums == null || nums.length <= 0)
			return -1;

		int low = 0;
		int high = nums.length - 1;
		int mid = (low + high) >> 1;

		if (nums[low] < nums[high])
			return nums[low];

		if (nums[mid] == nums[high] && nums[mid] == nums[low]) {
			for (int i = 1; i <= high; i++) {
				if (nums[i] < nums[i - 1]) // 唯一的
					return i;
			}
			return low;// 数组全部为某个数(一个数)
		}

		while (low + 1 != high) {
			mid = (low + high) >> 1;
			if (nums[mid] <= nums[high]) // if (nums[mid] >= nums[low])
				high = mid;
			else
				low = mid;
		}
		return high;
	}

	public void test1() {
		int[] array = null;
		System.out.println("test1:" + minNumberInRotateArray(array));
	}

	public void test2() {
		int[] array = {};
		System.out.println("test2:" + minNumberInRotateArray(array));
	}

	public void test3() {
		int[] array = { 1 };
		System.out.println("test3:" + minNumberInRotateArray(array));
	}

	public void test4() {
		int[] array = { 1, 2, 3, 4, 5, 6 };
		System.out.println("test4:" + minNumberInRotateArray(array));
	}

	public void test5() {
		int[] array = { 2, 2, 2, 2, 1, 2 };
		System.out.println("test5:" + minNumberInRotateArray(array));
	}

	public void test6() {
		int[] array = { 2, 0, 1, 1, 1 };
		System.out.println("test6:" + minNumberInRotateArray(array));
	}

	public void test7() {
		int[] array = { 6, 6, 8, 9, 10, 1, 2, 2, 3, 3, 4, 5, 6 };
		System.out.println("test7:" + minNumberInRotateArray(array));
	}

	public static void main(String[] args) {
		Offer11_MinNumberInRotatedArray demo = new Offer11_MinNumberInRotatedArray();
		demo.test1();
		demo.test2();
		demo.test3();
		demo.test4();
		demo.test5();
		demo.test6();
		demo.test7();
	}
}
