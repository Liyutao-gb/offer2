package com.lyt.java;

//题目
//	请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可
//以从矩阵中任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过
//了矩阵的某一格，那么该路径不能再次进入该格子。例如在下面的3×4的矩阵中包含一条字符串
//“bfce”的路径（路径中的字母用下划线标出）。但矩阵中不包含字符串“abfb”的路径，因为字
//符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
//	A B T G
//	C F C S
//	J D E H
//思路
//	首先对所整个矩阵遍历，找到第一个字符，然后向上下左右查找下一个字符，由于每个字符都是
//相同的判断方法（先判断当前字符是否相等，再向四周查找），因此采用递归函数。由于字符查找
//过后不能重复进入，所以还要定义一个与字符矩阵大小相同的布尔值矩阵，进入过的格子标记为true。
//如果不满足的情况下，需要进行回溯，此时，要将当前位置的布尔值标记回false。
//（所谓的回溯无非就是对使用过的字符进行标记和处理后的去标记）
//二维数组下标计算: row * cols + col
public class Offer12_StringPathInMatrix {
	/**
	 * 矩阵中的路径
	 * @param matrix 字符数组
	 * @param rows 字符数组行数
	 * @param cols 字符数组列数
	 * @param str 连续字符串
	 * @param isVisited 标记true为可行路径
	 * @return 是否存在str字符路径
	 */
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		if (matrix == null || rows <= 0 || cols <= 0 || str == null)
			return false;
		
		boolean[][] isVisited = new boolean[rows][cols];
		int pathLength = 0;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (hasPathCore(matrix, row, col, rows, cols, str, pathLength, isVisited))
					return true;
			}
		}
		return false;
	}

	private boolean hasPathCore(char[] matrix, int row, int col, int rows, int cols, char[] str, int pathLength,
			boolean[][] isVisited) {
		if (row < 0 || col < 0 || row >= rows || col >= cols || isVisited[row][col]
				|| matrix[row * cols + col] != str[pathLength])
			return false;
		if (pathLength == str.length - 1)
			return true;
		
		isVisited[row][col] = true;
		boolean hasPath = false;
		hasPath = hasPathCore(matrix, row - 1, col, rows, cols, str, pathLength + 1, isVisited)
				|| hasPathCore(matrix, row + 1, col, rows, cols, str, pathLength + 1, isVisited)
				|| hasPathCore(matrix, row, col - 1, rows, cols, str, pathLength + 1, isVisited)
				|| hasPathCore(matrix, row, col + 1, rows, cols,  str, pathLength + 1, isVisited);

		if (!hasPath) {
			isVisited[row][col] = false;
		}
		return hasPath;
	}

	// A B T G
	// C F C S
	// J D E H

	// BFCTB
	public void test1() {
		char[] matrix = "ABTGCFCSJDEH".toCharArray();
		int rows = 3;
		int cols = 4;
		char[] str = "BFCTB".toCharArray();
		if (hasPath(matrix, rows, cols, str))
			System.out.println("test1:有此路径！");
		else
			System.out.println("test1:没有此路径！");
	}

	// A B T G
	// C F C S
	// J D E H

	// BFCE
	public void test2() {
		char[] matrix = "ABTGCFCSJDEH".toCharArray();
		int rows = 3;
		int cols = 4;
		char[] str = "BFCE".toCharArray();
		if (hasPath(matrix, rows, cols, str))
			System.out.println("test2:有此路径！");
		else
			System.out.println("test2:没有此路径！");
	}

	// matrix=null
	public void test3() {
		char[] matrix = null;
		int rows = 0;
		int cols = 0;
		char[] str = "BFCE".toCharArray();
		if (hasPath(matrix, rows, cols, str))
			System.out.println("test3:有此路径！");
		else
			System.out.println("test3:没有此路径！");
	}

	// str=null
	public void test4() {
		char[] matrix = "ABTGCFCSJDEH".toCharArray();
		int rows = 3;
		int cols = 4;
		char[] str = null;
		if (hasPath(matrix, rows, cols, str))
			System.out.println("test4:有此路径！");
		else
			System.out.println("test4:没有此路径！");
	}

	// A

	// A
	public void test5() {
		char[] matrix = "A".toCharArray();
		int rows = 1;
		int cols = 1;
		char[] str = "A".toCharArray();
		if (hasPath(matrix, rows, cols, str))
			System.out.println("test5:有此路径！");
		else
			System.out.println("test5:没有此路径！");
	}

	// A

	// B
	public void test6() {
		char[] matrix = "A".toCharArray();
		int rows = 1;
		int cols = 1;
		char[] str = "B".toCharArray();
		if (hasPath(matrix, rows, cols, str))
			System.out.println("test6:有此路径！");
		else
			System.out.println("test6:没有此路径！");
	}

	// AAAA
	// AAAA
	// AAAA
	// AAAAAAAAAAAA
	public void test7() {
		char[] matrix = "AAAAAAAAAAAA".toCharArray();
		int rows = 3;
		int cols = 4;
		char[] str = "AAAAAAAAAAAA".toCharArray();
		if (hasPath(matrix, rows, cols, str))
			System.out.println("test7:有此路径！");
		else
			System.out.println("test7:没有此路径！");
	}

	public static void main(String[] args) {
		Offer12_StringPathInMatrix demo = new Offer12_StringPathInMatrix();
		demo.test1();
		demo.test2();
		demo.test3();
		demo.test4();
		demo.test5();
		demo.test6();
		demo.test7();
	}

}
