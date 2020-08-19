package com.lyt.java;

//题目
// 假设把某股票的价格按照时间先后顺序存储在数组中,请问买卖交易该股票可能获得的利润是多少?
//例如一只股票在某些时间节点的价格为{9, 11, 8, 5,7, 12, 16, 14}。如果我们能在价格为5的
//时候买入并在价格为16时卖出，则能收获最大的利润11。
//思路
//	股票交易的利润来自股票买入和卖出价格的差价。只能在买入某只股票之后才能卖出。那么利润
//是买入和卖出股票两个数字的差值。因此，最大利润就是数组中所有数对的最大差之。显然，买入
//价越低获得利润越大。如果在扫描到数组中第i个数字时，只要我们能记住之前的i-1个数字中的
//最小值，就能算出当前价位卖出时可能得到的最大利润。
public class Offer63_MaximalProfit {
	public static int MaxDiff(int[] prices) {
		if (prices == null || prices.length < 2)
			throw new RuntimeException("数组不合法");

//		 默认亏本为0
//		int min = prices[0];
//		int maxDiff = 0;
//		for (int i = 1; i < prices.length; i++) {
//			if (prices[i - 1] < min)	// 找出之前的最小值
//				min = prices[i - 1];
//		
//			if (prices[i] - min > maxDiff)
//				maxDiff = prices[i] - min;
//		}
//
//		return maxDiff;

		int min = prices[0];
		// 最大利润可以是负数，只要亏损最小就行
		int maxDiff = prices[1] - min;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i - 1] < min) // 记录 "之前(i-1)" 中的最小数字
				min = prices[i - 1];
			
			if (prices[i] - min > maxDiff)
				maxDiff = prices[i] - min;
		}

		return maxDiff;
	}

	public static void main(String[] args) {
		int[] arr1 = null;
		System.out.println(MaxDiff(arr1) == -1);

		int[] arr2 = {};
		System.out.println(MaxDiff(arr2) == -1);

		int[] arr3 = { 16, 16, 16, 16, 16 };
		System.out.println(MaxDiff(arr3) == 0);

		int[] arr4 = { 1, 2, 4, 7, 11, 16 };
		System.out.println(MaxDiff(arr4) == 15);

		int[] arr5 = { 16, 11, 7, 4, 2, 1 };
		System.out.println(MaxDiff(arr5) == -1);

		int[] arr6 = { 9, 11, 5, 7, 16, 1, 4, 2 };
		System.out.println(MaxDiff(arr6) == 11);

		int[] arr7 = { 2, 4 };
		System.out.println(MaxDiff(arr7) == 2);

		int[] arr8 = { 4, 2 };
		System.out.println(MaxDiff(arr8) == -2);
	}
}
