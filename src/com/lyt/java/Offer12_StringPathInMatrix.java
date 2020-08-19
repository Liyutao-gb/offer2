package com.lyt.java;

//��Ŀ
//	�����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����·����
//�ԴӾ���������һ��ʼ��ÿһ�������ھ����������ҡ��ϡ����ƶ�һ�����һ��·������
//�˾����ĳһ����ô��·�������ٴν���ø��ӡ������������3��4�ľ����а���һ���ַ���
//��bfce����·����·���е���ĸ���»��߱�������������в������ַ�����abfb����·������Ϊ��
//�����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��·�������ٴν���������ӡ�
//	A B T G
//	C F C S
//	J D E H
//˼·
//	���ȶ�����������������ҵ���һ���ַ���Ȼ�����������Ҳ�����һ���ַ�������ÿ���ַ�����
//��ͬ���жϷ��������жϵ�ǰ�ַ��Ƿ���ȣ��������ܲ��ң�����˲��õݹ麯���������ַ�����
//�������ظ����룬���Ի�Ҫ����һ�����ַ������С��ͬ�Ĳ���ֵ���󣬽�����ĸ��ӱ��Ϊtrue��
//��������������£���Ҫ���л��ݣ���ʱ��Ҫ����ǰλ�õĲ���ֵ��ǻ�false��
//����ν�Ļ����޷Ǿ��Ƕ�ʹ�ù����ַ����б�Ǻʹ�����ȥ��ǣ�
//��ά�����±����: row * cols + col
public class Offer12_StringPathInMatrix {
	/**
	 * �����е�·��
	 * @param matrix �ַ�����
	 * @param rows �ַ���������
	 * @param cols �ַ���������
	 * @param str �����ַ���
	 * @param isVisited ���trueΪ����·��
	 * @return �Ƿ����str�ַ�·��
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
			System.out.println("test1:�д�·����");
		else
			System.out.println("test1:û�д�·����");
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
			System.out.println("test2:�д�·����");
		else
			System.out.println("test2:û�д�·����");
	}

	// matrix=null
	public void test3() {
		char[] matrix = null;
		int rows = 0;
		int cols = 0;
		char[] str = "BFCE".toCharArray();
		if (hasPath(matrix, rows, cols, str))
			System.out.println("test3:�д�·����");
		else
			System.out.println("test3:û�д�·����");
	}

	// str=null
	public void test4() {
		char[] matrix = "ABTGCFCSJDEH".toCharArray();
		int rows = 3;
		int cols = 4;
		char[] str = null;
		if (hasPath(matrix, rows, cols, str))
			System.out.println("test4:�д�·����");
		else
			System.out.println("test4:û�д�·����");
	}

	// A

	// A
	public void test5() {
		char[] matrix = "A".toCharArray();
		int rows = 1;
		int cols = 1;
		char[] str = "A".toCharArray();
		if (hasPath(matrix, rows, cols, str))
			System.out.println("test5:�д�·����");
		else
			System.out.println("test5:û�д�·����");
	}

	// A

	// B
	public void test6() {
		char[] matrix = "A".toCharArray();
		int rows = 1;
		int cols = 1;
		char[] str = "B".toCharArray();
		if (hasPath(matrix, rows, cols, str))
			System.out.println("test6:�д�·����");
		else
			System.out.println("test6:û�д�·����");
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
			System.out.println("test7:�д�·����");
		else
			System.out.println("test7:û�д�·����");
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
