package com.lyt.java;

//题目1：找出数组中重复的数字。
//	在一个长度为n的数组里的所有数字都在(0到n-1)的范围内。数组中某些数字是重复的，但不
//知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 
//例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
//思路
//	从哈希表的思路拓展，重排数组：把扫描的每个数字（如数字m）放到其对应下标(m下标)的
//位置上，若同一位置有重复，则说明该数字重复。
//	时间复杂度O(n) 空间复杂度O(1)
public class Offer03_FindDuplication1 {
	/**
	 * 1.比较数字 是否和 下标i相等
	 * 2.(1)数字和下标number[i]的数字比较
	 * 	 (2)不相等就交换number[i]和下标number[i]的数字
	 */
	public int getDuplicate(int[] nums) {
		if (nums == null || nums.length <= 0) {
			System.out.println("数组输入无效！");
			return -1;
		}

		// 判断数组是否合法（每个数都在0 ~ n-1 之间）
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0 || nums[i] > nums.length - 1) {
				System.out.println("数字大小超出范围！");
				return -1;
			}
		}

		// key step
		for (int i = 0; i < nums.length; i++) {
			while (nums[i] != i) {	
				if (nums[i] == nums[nums[i]]) {
					return nums[i];
				}
				int temp = nums[nums[i]];
				nums[nums[i]] = nums[i];
				nums[i] = temp;
			}
		}
		System.out.println("数组中无重复数字！");
		return -1;
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
	 * 数组无重复数字
	 */
	public void test2() {
		System.out.print("test2：");
		int[] a = { 0, 1, 2, 3 };
		int dup = getDuplicate(a);
		if (dup >= 0)
			System.out.println("重复数字为：" + dup);
	}

	/**
	 * 数组数字越界
	 */
	public void test3() {
		System.out.print("test3：");
		int[] a = { 1, 2, 3, 4 };
		int dup = getDuplicate(a);
		if (dup >= 0)
			System.out.println("重复数字为：" + dup);
	}

	/**
	 * 数组带重复数字
	 */
	public void test4() {
		System.out.print("test4：");
		int[] a = { 1, 2, 3, 2, 4 }; // 2,1,3,2,4   3,1,2,2,4   2,1,2,3,4  
		int dup = getDuplicate(a);
		if (dup >= 0)
			System.out.println("重复数字为：" + dup);
	}

	public static void main(String[] args) {
		Offer03_FindDuplication1 f = new Offer03_FindDuplication1();
		f.test1();
		f.test2();
		f.test3();
		f.test4();
	}
}