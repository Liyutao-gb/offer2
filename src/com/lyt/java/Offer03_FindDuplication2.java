package com.lyt.java;

//题目2：不修改数组找出重复的数字。
//	在一个长度为n+1的数组里的所有数字都在1到n的范围内，所以数组中至少有一个数字
//是重复的。请找出数组中任意一个重复的数字，但不能修改输入的数组。例如，如果
//输入长度为8的数组{2, 3, 5, 4, 3, 2, 6, 7}，那么对应的输出是重复的数字2或者3。
//思路1
//	创建一个长度为n+1的辅助数组,然后逐一把原数组的每个数字复制到辅助数组。如果
//原数组中被复制的是m,则把它复制到辅助数组中下标为m的位置。
//思路2
//	数组长度为n+1，而数字只从1到n，说明必定有重复数字。可以由二分查找法拓展：
//把1~n的数字从中间数字m分成两部分，若前一半1~m的数字数目超过m个，说明重复
//数字在前一半区间，否则，在后半区间m+1~n。每次在区间中都一分为二，直到找到重复数字。
public class Offer03_FindDuplication2 {
	/**
	 * 方法一：不改变原数组
	 *    时间复杂度O(n)		空间复杂度O(n)
	 */
	public int getD(int[] nums) {
		if (nums == null || nums.length <= 0) 	// 数组输入无效！
			return -1;

		for (int a : nums) {
			if (a < 1 || a > nums.length - 1) 	// 数字大小超出范围！
				return -1;
		}

		int[] helper = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (helper[nums[i]] != 0) 
				return nums[i];
			helper[nums[i]] = nums[i];
		}
		return -1;
	}

	/**
	 * 方法二：不改变原数组
	 *    时间复杂度O(nlogn)		空间复杂度O(1)
	 */
	public int getDuplicate(int[] nums) {
		if (nums == null || nums.length <= 0) 	// 数组输入无效！
			return -1;
		
		for (int a : nums) {
			if (a < 1 || a > nums.length - 1)	// 数字大小超出范围！
				return -1;
		}
		
		int low = 1;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = (high + low) >> 1;
			int count = countRange(nums, low, mid);
			if (low == high) {
				if (count > 1)
					return low;
			}
			if (count > mid - low + 1) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	/**
	 * 返回在[low,high]范围中数字的个数
	 */
	public int countRange(int[] arr, int low, int high) {
		if (arr == null)
			return 0;
		int count = 0;
		for (int a : arr) {
			if (a >= low && a <= high)
				count++;
		}
		return count;
	}

	/**
	 * 数组为null
	 */
	public void test1() {
		System.out.print("test1：");
		int[] a = null;
		int dup = getDuplicate(a);
		if (dup >= 0)
			System.out.println("重复数字为：" + dup);
	}

	/**
	 * 数组数字越界
	 */
	public void test2() {
		System.out.print("test2：");
		int[] a = { 1, 2, 3, 4 };
		int dup = getDuplicate(a);
		if (dup >= 0)
			System.out.println("重复数字为：" + dup);
	}

	/**
	 * 数组带重复数字
	 */
	public void test3() {
		System.out.print("test3：");
		int[] a = {2, 3, 5, 4, 3, 2, 6, 7};
		int dup = getDuplicate(a);
		if (dup >= 0)
			System.out.println("重复数字为：" + dup);
	}

	public static void main(String[] args) {
		Offer03_FindDuplication2 f2 = new Offer03_FindDuplication2();
		f2.test1();
		f2.test2();
		f2.test3();
	}
}