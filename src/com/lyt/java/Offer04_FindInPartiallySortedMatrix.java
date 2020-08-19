package com.lyt.java;

//��Ŀ
//	��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ���
//������˳�����������һ������������������һ����ά�����һ���������ж�����
//���Ƿ��и�������
//˼·
//	��������ʱ����������Ͻǿ�ʼ���ң������Ϊ���ӣ�����ת��˼·�������Ͻǿ�ʼ���ң�
//������ֱȽ�С���ұ����ֱȽϴ����׽����жϡ�
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
				System.out.println("����" + a + "�ڶ�ά�����е��±�Ϊ��" + index[0] + "," + index[1]);
				return index;
			} else if (a < matrix[row][column]) {
				column--;
			} else {
				row++;
			}
		}
		System.out.println("�����в������֣�" + a);
		return index;
	}

	// Ҫ���ҵ�����������
	public void test1() {
		System.out.print("test1��");
		int[][] matrix = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		findTarget(matrix, 7);
	}

	// 1 2 8 9
	// 2 4 9 12
	// 4 7 10 13
	// 6 8 11 15
	// Ҫ���ҵ�������������
	public void test2() {
		System.out.print("test2��");
		int[][] matrix = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		findTarget(matrix, 5);
	}

	// ����Ϊ��
	public void test3() {
		System.out.print("test3��");
		int[][] matrix = null;
		findTarget(matrix, 7);
	}

	// 1 2 8 9
	// 4 3 9 12
	// 4 7 10 13
	// 6 8 11 15
	// ���鲻�����С����
	public void test4() {
		System.out.print("test4��");
		int[][] matrix = { { 1, 2, 8, 9 }, { 4, 3, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		findTarget(matrix, 7);
	}

	// ����ÿ�г��Ȳ�һ��
	public void test5() {
		System.out.print("test5��");
		int[][] matrix = { { 1, 2, 8 }, { 4, 3, 9, 12 }, { 4, 7, 10 }, { 6, 8, 11, 15 } };
		findTarget(matrix, 7);
	}

	public static void main(String[] args) {
		Offer04_FindInPartiallySortedMatrix f = new Offer04_FindInPartiallySortedMatrix();
		f.test1(); // ע���±��Ǵ�0��ʼ��
		f.test2();
		f.test3();
		f.test4();
		f.test5();
	}
}
