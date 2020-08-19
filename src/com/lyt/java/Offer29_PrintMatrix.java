package com.lyt.java;

//��Ŀ
//	����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֡�
//˼·
//	ÿ�δ�ӡ�����������һȦ���÷���printMatrixInCircle()��ʾ����ÿ�ζ������������
//���Կ��Բ��õݹ顣ÿ�δ�ӡ��������Ͻǵĺ���������ͬ����Ϊstart�������������ǵ�����
//�����������Լ�start�йأ����ֻ��Ҫforѭ������ʵ�ִ�ӡ��
//��Ȼ����ʵֻҪ���start����ѭ���жϣ�start*2��ֵС������������ʱ����Ҫ������ӡ��
//������ͨ�����������������ѭ������ӡÿ�ε�����Ȧ����
public class Offer29_PrintMatrix {
	/**
	 * 1.���Ⱥ�start�Ƚ�,�ж��Ƿ���Խ��б���; 
	 * 2.�ж��Ƿ�ʣ����һ�л���һ�е������������ǵ�return; 
	 * 3.������ӡ�߽�ֵ;
	 * 4.�������ݹ��ӡ���ڲ��ľ�����start+1��
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
		if (start > endX || start > endY)// �ݹ��˳�����
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
		System.out.print("4��4�У�");
		demo.printMatrixInCircle(a);
		System.out.print("\n4��3�У�");
		demo.printMatrixInCircle(b);
		System.out.print("\n3��4�У�");
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
