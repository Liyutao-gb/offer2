package com.lyt.java;

//题目
//	在一个m×n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于0）。
//你可以从棋盘的左上角开始拿格子里的礼物，并每次向左或者向下移动一格直到到达棋盘的
//右下角。给定一个棋盘及其上面的礼物，请计算你最多能拿到多少价值的礼物？
//思路
//	动态规划：定义f(i,j)为到达(i,j)位置格子时能拿到的礼物总和的最大值，则有：
//f(i,j)=max{f(i,j),f(i,j)}+values(i,j)。优化前：① ② ③ ④ ⑤
public class Offer47_MaxValueOfGifts {
	public int maxValueOfGifts(int[][] grid) {
		if (grid == null || grid.length <= 0)
			return 0;

		int rows = grid.length;
		int cols = grid[0].length;
		int[] maxValue = new int[cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int left = 0;
				int up = 0;
				if (i > 0)
					up = maxValue[j];
				if (j > 0)
					left = maxValue[j - 1];
				maxValue[j] = Math.max(up, left) + grid[i][j];
			}
		}
		return maxValue[cols - 1];
	}

	public static void main(String[] args) {
		Offer47_MaxValueOfGifts demo = new Offer47_MaxValueOfGifts();
		int[][] arr = new int[][] { { 1, 10, 3, 8 }, { 12, 2, 9, 6 }, { 5, 7, 4, 11 }, { 3, 7, 16, 5 } };
		int maxValueOfGifts = demo.maxValueOfGifts(arr);
		System.out.println(maxValueOfGifts);
	}
}
