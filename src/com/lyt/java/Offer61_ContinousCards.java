package com.lyt.java;

import java.util.Arrays;
//题目
//	从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，
//A为1，J为11，Q为12，K为13，而大、小王可以看成任意数字。
//思路
//	输入为大小等于5的数组（大小王记为0），输出为布尔值。具体步骤如下：
//1）进行对5张牌进行排序；
//2）找出0的个数；
//3）算出相邻数字的空缺总数；
//4）如果0的个数大于等于空缺总数，说明连续，反之不连续；
//5）记得判断相邻数字是否相等，如果有出现相等，说明不是顺子。
public class Offer61_ContinousCards {
	public boolean isContinuous(int[] numbers) {
		if (numbers == null || numbers.length <= 0)
			throw new RuntimeException("数组不合法");

		Arrays.sort(numbers);
		int numberOf0 = 0;
		int numberOfGap = 0;
		// 1.统计0(大、小王)的个数 
		for (int i : numbers) {
			if (i == 0)
				numberOf0++;
		}

		int small = numberOf0;
		int big = numberOf0 + 1;
		while (big < numbers.length) {
			if (numbers[small] == numbers[big]) // 数组中不能有相等数字
				return false;
			numberOfGap += numbers[big++] - numbers[small++] - 1;
		}

		return numberOf0 >= numberOfGap; // 0的个数 >= gap间隙数
	}

	public static void main(String[] args) {
		Offer61_ContinousCards demo = new Offer61_ContinousCards();
		int[] arr = new int[] { 0, 1, 3, 4, 5 };
		boolean continuous = demo.isContinuous(arr);
		System.out.println(continuous);
	}
}
