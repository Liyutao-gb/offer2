package com.lyt.java;

//题目
//	输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
//思路
//	每次打印矩阵最外面的一圈（用方法printMatrixInCircle()表示），每次都是这个操作，
//所以可以采用递归。每次打印矩阵的左上角的横纵坐标相同，即为start，而其余三个角的坐标
//都与行列数以及start有关，因此只需要for循环即可实现打印。
//当然，其实只要针对start进行循环判断，start*2的值小于行数和列数时才需要继续打印，
//这样，通过这个条件，可以用循环来打印每次的最外圈矩阵。
public class Offer29_PrintMatrix {
	/**
	 * 1.首先和start比较,判断是否可以进行遍历; 
	 * 2.判断是否剩的是一行或者一列的情况，遍历完记得return; 
	 * 3.继续打印边界值;
	 * 4.最后继续递归打印更内部的矩阵，令start+1。
	 */
	public void printMatrixInCircle(int[][] matrix) {
		if (matrix == null || matrix.length <= 0)
			return;
		printMatrix(matrix, 0);
	}

	private void printMatrix(int[][] matrix, int start) {
		int row = matrix.length;
		int col = matrix[0].length;
		int endX = col - 1 - start;
		int endY = row - 1 - start;
		if (start > endX || start > endY)// 递归退出遍历
			return;

		if (endY == start) {
			for (int i = start; i <= endX; i++) {
				System.out.print(matrix[start][i] + " ");
			}
			return;
		}
		if (endX == start) {
			for (int i = start; i <= endY; i++) {
				System.out.print(matrix[i][start] + " ");
			}
			return;
		}

		for (int i = start; i <= endX; i++) {
			System.out.print(matrix[start][i] + " ");
		}
		for (int i = start + 1; i <= endY; i++) {
			System.out.print(matrix[i][endX] + " ");
		}
		for (int i = endX - 1; i >= start; i--) {
			System.out.print(matrix[endY][i] + " ");
		}
		for (int i = endY - 1; i >= start + 1; i--) {
			System.out.print(matrix[i][start] + " ");
		}

		printMatrix(matrix, start + 1);
	}

	public static void main(String[] args) {
		Offer29_PrintMatrix demo = new Offer29_PrintMatrix();
		int[][] a = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int[][] b = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
		int[][] c = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		System.out.print("4行4列：");
		demo.printMatrixInCircle(a);
		System.out.print("\n4行3列：");
		demo.printMatrixInCircle(b);
		System.out.print("\n3行4列：");
		demo.printMatrixInCircle(c);
		// int[][] a= {};
		// int[][] a= {{}};
		// int[][] a= {{1}};
		// int[][] a= {{1,2,3,4}};
		// int[][] a= {{1},{2},{3},{4}};
		// int[][] a= {{1,2,3},{4,5,6}};
		// int[][] a=null;
	}
}
