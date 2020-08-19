package com.lyt.java;

//题目
//	在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下
//递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组
//中是否含有该整数。
//思路
//	查找整数时，如果从左上角开始查找，情况较为复杂，可以转换思路，从右上角开始查找：
//左边数字比较小，右边数字比较大，容易进行判断。
public class Offer04_FindInPartiallySortedMatrix {
	public int[] findTarget(int[][] matrix, int a) {
		if (matrix == null || matrix.length <= 0)
			return new int[] {};

		int[] index = { -1, -1 };
		int row = 0;
		int column = matrix[0].length - 1;
		while (row <= matrix.length - 1 && column >= 0) {
			if (a == matrix[row][column]) {
				index[0] = row;
				index[1] = column;
				System.out.println("数字" + a + "在二维数组中的下标为：" + index[0] + "," + index[1]);
				return index;
			} else if (a < matrix[row][column]) {
				column--;
			} else {
				row++;
			}
		}
		System.out.println("数组中不含数字：" + a);
		return index;
	}

	// 要查找的数在数组中
	public void test1() {
		System.out.print("test1：");
		int[][] matrix = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		findTarget(matrix, 7);
	}

	// 1 2 8 9
	// 2 4 9 12
	// 4 7 10 13
	// 6 8 11 15
	// 要查找的数不在数组中
	public void test2() {
		System.out.print("test2：");
		int[][] matrix = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		findTarget(matrix, 5);
	}

	// 数组为空
	public void test3() {
		System.out.print("test3：");
		int[][] matrix = null;
		findTarget(matrix, 7);
	}

	// 1 2 8 9
	// 4 3 9 12
	// 4 7 10 13
	// 6 8 11 15
	// 数组不满足大小规则
	public void test4() {
		System.out.print("test4：");
		int[][] matrix = { { 1, 2, 8, 9 }, { 4, 3, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		findTarget(matrix, 7);
	}

	// 数组每行长度不一致
	public void test5() {
		System.out.print("test5：");
		int[][] matrix = { { 1, 2, 8 }, { 4, 3, 9, 12 }, { 4, 7, 10 }, { 6, 8, 11, 15 } };
		findTarget(matrix, 7);
	}

	public static void main(String[] args) {
		Offer04_FindInPartiallySortedMatrix f = new Offer04_FindInPartiallySortedMatrix();
		f.test1(); // 注意下标是从0开始的
		f.test2();
		f.test3();
		f.test4();
		f.test5();
	}
}
