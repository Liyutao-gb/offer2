package com.lyt.java;

//题目
//	一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次
//的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
//思路
//	两个相同的数字异或等于0。
//	如果数组中只有一个数字只出现一次，其他的数字出现两次，我们从头到尾异或每个数字，那么
//最终的结果刚好是那个只出现一次的数字。而本题里数组中有两个数字只出现一次，如果能够将
//数组分为两部分，两部分中都只有一个数字只出现一次，那么就可以解决该问题了。
//解决方法：
//	我们依旧从头到尾异或每个数字，那么最终的结果就是这两个只出现一次的数字的异或结果，
//由于两个数不同，因此这个结果数字中一定有一位为1，把结果中第一个1的位置记为第n位。
//因为是两个只出现一次的数字的异或结果，所以这两个数字在第n位上的数字一定是1和0。
//	接下来我们根据数组中每个数字的第n位上的数字是否为1来进行分组，恰好能将数组分为
//两个都只有一个数字只出现一次的数组，对两个数组从头到尾异或，就可以得到这两个数了。
public class Offer56_NumbersAppearOnce {
	public int[] singleNumber(int[] nums) {
		if (nums == null || nums.length < 2)
			throw new RuntimeException("数组不合法");

		int[] result = new int[2];
		int xor = 0;
		for (int i : nums) {
			xor ^= i;
		}

		int mask = xor & (-xor);
//		int indexOf1 = 0;
//		while (((xor & 1) == 0) && (indexOf1 <= 4 * 8)) {
//			xor = xor >> 1; // 只有n>>1不完整，要n=n>>1
//			indexOf1++;
//		}

		for (int i : nums) {
			 if((i & mask) == mask)	// if (((i >> indexOf1) & 1) == 1) 
				result[0] ^= i;
			else
				result[1] ^= i;
		}

		return result;
	}

	public static void main(String[] args) {
		Offer56_NumbersAppearOnce demo = new Offer56_NumbersAppearOnce();
		int[] nums = new int[] { 2, 4, 3, 6, 3, 2, 5, 5 };
		int[] appearOnce = demo.singleNumber(nums);
		System.out.println(appearOnce[0] + " " + appearOnce[1]);
	}
}
