package com.lyt.java;

import java.util.HashMap;
import java.util.Map;

//题目
//	输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有
//多对数字的和等于s，输出任意一对即可。
//思路
//	从头开始遍历数字，确定一个数字后，对后面的数字遍历，判断和是否为s，这种方法复杂度
//为O(n^2)，效率太低。
//	我们考虑到，如果一个数字比较小，那么另一个数字一定比较大，同时数字为递增排列；
//所以，我们设置两个指针，一个指针small从第一个数字（最小）出发，另一个指针big从
//最后一个数字（最大）出发：
//当small加big的和小于s时，只需要将small指向后一个数字（更大），继续判断；
//当small加big的和大于s时，只需要将big指向前一个数字（更小），继续判断；
//当small加big的和等于s时，求解完成。
//由于是从两边往中间移动，所以不会有跳过的情况，时间复杂度为O(n)。
public class Offer57_TwoNumbersWithSum {
	/**
	 * 两数之和：有序数组，找数字
	 */
	public int[] findNumbersWithSum(int[] nums, int target) {
		if (nums == null || nums.length <= 0)
			throw new RuntimeException("数组不合法");
		
		int low = 0;
		int high = nums.length - 1;
		while (low < high) {
			if (nums[low] + nums[high] == target) {
				return new int[] {nums[low], nums[high]};
			} else if (nums[low] + nums[high] < target)
				low++;
			else
				high--;
		}
		return new int[]{};
	}

	/**
	 * 两数之和：无序数组，找下标
	 */
	public int[] twoSum(int[] nums, int target) {
		if (nums == null || nums.length <= 0)
			throw new RuntimeException("数组不合法");

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int num = target - nums[i];
			if (map.containsKey(num)) {
				return new int[] { map.get(num), i };
			}
			map.put(nums[i], i);
		}

		return new int[]{};
	}
}
