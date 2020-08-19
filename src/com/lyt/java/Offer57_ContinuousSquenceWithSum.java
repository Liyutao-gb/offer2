package com.lyt.java;

import java.util.ArrayList;
import java.util.List;

//题目
//	输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。例如输入15，
//由于1+2+3+4+5=4+5+6=7+8=15，所以结果打印出3个连续序列1～5、4～6和7～8。
//思路:指针法
//	类似(57-1) 和为s的两个数字的方法，用两个指针small和big分别代表序列的最大值和最小值。
//令small从1开始，big从2开始。
//当从small到big的序列的和小于s时，增加big，使序列包含更多数字；（记得更新序列之和）
//当从small到big的序列的和大于s时，增加small，使序列去掉较小的数字；（记得更新序列之和）
//当从small到big的序列的和等于s时，此时得到一个满足题目要求的序列，输出，然后继续将
//small增大，往后面找新的序列。
//序列最少两个数字，因此，当small到了s/2时，就可以结束判断了。
public class Offer57_ContinuousSquenceWithSum {
	// 方法一：采用两个指针的方法
	public List<List<Integer>> findContinuousSequence1(int sum) {
		if (sum < 3)
			throw new RuntimeException("输入有误！");

		List<List<Integer>> sequenceList = new ArrayList<>();
		int small = 1;
		int big = 2;
		int curSum = small + big;
		while (small <= sum / 2) {
			if (curSum == sum) {
				List<Integer> sequence = new ArrayList<Integer>();
				for (int i = small; i <= big; i++) {
					sequence.add(i);
				}
				sequenceList.add(sequence);
				curSum -= small;
				small++; // 这两行位置先后要注意
			}
			if (curSum < sum) {
				big++;
				curSum += big;
			}
			if (curSum > sum) {
				curSum -= small;
				small++;
			}
		}
		return sequenceList;
	}

	// 方法二：数学分析法
	public List<List<Integer>> findContinuousSequence2(int sum) {
		List<List<Integer>> sequenceList = new ArrayList<>();
		if (sum <= 0)
			return sequenceList;

		for (int n = (int) Math.sqrt(2 * sum); n >= 2; n--) {
			if (((n & 1) == 1 && sum % n == 0) || ((n & 1) == 0 && (sum % n) * 2 == n)) {
				ArrayList<Integer> sequence = new ArrayList<>();
				for (int j = 0, k = (sum / n) - (n - 1) / 2; j < n; j++, k++) {
					sequence.add(k);
				}
				sequenceList.add(sequence);
			}
		}
		return sequenceList;
	}

	public static void main(String[] args) {
		Offer57_ContinuousSquenceWithSum demo = new Offer57_ContinuousSquenceWithSum();
		// 14 不会有两个7,7 6+7不够时会加一个8,7+8又会超过14,small = 8后退出循环。
		List<List<Integer>> sequence1 = demo.findContinuousSequence1(15);
		for (List<Integer> list : sequence1) {
			System.out.println(list);
		}
	}
}
