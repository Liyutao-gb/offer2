package com.lyt.java;

//题目
//	在一个数组中除了一个数字只出现一次之外,其他数字都出现了三次。请找出那个只出现一次的
//数字。
//思路
//	这道题中数字出现了三次，无法像数组中只出现一次的两个数字一样通过利用异或位运算进行
//消除相同个数字。但是仍然可以沿用位运算的思路。
//	将所有数字的二进制表示的对应位都加起来，如果某一位能被三整除，那么只出现一次的数字
//在该位为0；反之，为1。
public class Offer56_NumberAppearingOnce {
	public int singleNumber(int[] nums) {
		if (nums == null || nums.length <= 0)
			throw new RuntimeException("数组不合法");

		int[] bits = new int[32];

		for (int i = 0; i < bits.length; i++) {
			for (int j = 0; j < nums.length; j++) { // 每一位数字对应的0或1加起来
				int num = nums[j] >> i;
				bits[i] += (num & 1);
			}
		}

		// 智慧解法(二进制 → 十进制)
		int result = 0;
		for (int i = bits.length - 1; i >= 0; i--) {
			result <<= 1;
			result += bits[i] % 3;
		}
		return result;
	}

	public static void main(String[] args) {
		Offer56_NumberAppearingOnce demo = new Offer56_NumberAppearingOnce();
		int[] arr = { 2, 2, 2, 5, 3, 3, 3, 6, 6, 6 };
		int appearingOnce = demo.singleNumber(arr);
		System.out.println(appearingOnce);
	}
}
