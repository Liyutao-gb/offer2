package com.lyt.java;

//题目
//	一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0到n-1之内。
//在范围0到n-1的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
//思路
//	如果从头到尾依次比较值与小标是否相等，时间复杂度为O(n)，效率低。
//由于是排序数组，我们继续考虑使用二分查找算法,找出数组中第一个值和下标不相等的元素。
//　当中间数字等于其下标时，我们在后半部分查找；
//　当中间数字不等于其下标时：
//　　1）如果中间数字的前一个数字也不等于其下标，则在前半部分查找；
//　　2）如果中间数字的前一个数字等于其下标，则说明中间数字的下标即为我们所要找的数字。
public class Offer53_MissingNumber {
	public int getMissingNumber(int[] arr) {
		if (arr == null || arr.length <= 0)
			throw new RuntimeException("数组不合法");
		
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] != mid) {
				if (mid == 0 || arr[mid - 1] == mid - 1)
					return mid;
				else
					high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Offer53_MissingNumber demo = new Offer53_MissingNumber();
		int[] arr = { 0, 2, 3, 4, 5 };
		int number = demo.getMissingNumber(arr);
		System.out.println(number);
	}
}
