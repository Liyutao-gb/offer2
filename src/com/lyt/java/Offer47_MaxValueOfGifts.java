package com.lyt.java;

//��Ŀ
//	��һ��m��n�����̵�ÿһ�񶼷���һ�����ÿ�����ﶼ��һ���ļ�ֵ����ֵ����0����
//����Դ����̵����Ͻǿ�ʼ�ø�����������ÿ��������������ƶ�һ��ֱ���������̵�
//���½ǡ�����һ�����̼������������������������õ����ټ�ֵ�����
//˼·
//	��̬�滮������f(i,j)Ϊ����(i,j)λ�ø���ʱ���õ��������ܺ͵����ֵ�����У�
//f(i,j)=max{f(i,j),f(i,j)}+values(i,j)���Ż�ǰ���� �� �� �� ��
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
