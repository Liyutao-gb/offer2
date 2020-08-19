package com.lyt.java;

//题目　
//	输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整/数组成一个子数组。
//求所有子数组的和的最大值。要求时间复杂度为O(n)。
//思路
//	分析规律，从第一个数字开始累加，若走到某一个数字时，前面的累加和为负数，说明不能
//继续累加了，要从当前数字重新开始累加。在累加过程中，将每次累加和的最大值记录下来，
//遍历完成后，返回该数字。
public class Offer42_GreatestSumOfSubarrays {
	public int getGreatestSumOfSubArray(int[] arr) {
		if (arr == null || arr.length <= 0)
			return 0;
			
		int sum = arr[0];
		int maxSum = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (sum > 0) {
				sum += arr[i];
			} else {
				sum = arr[i];
			}
			maxSum = Math.max(maxSum, sum);
		}
		return maxSum;
	}

	public static void main(String[] args) {
		Offer42_GreatestSumOfSubarrays demo = new Offer42_GreatestSumOfSubarrays();
		int[] arr = {3, 5, -2, -5, 7, -4 };
		int sum = demo.getGreatestSumOfSubArray(arr);
		System.out.println(sum);
	}
}
