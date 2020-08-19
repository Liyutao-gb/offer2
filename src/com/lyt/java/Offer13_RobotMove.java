package com.lyt.java;

//��Ŀ
//	������һ��m��n�еķ���һ�������˴�����(0, 0)�ĸ��ӿ�ʼ�ƶ�����ÿһ�ο��������ҡ�
//�ϡ����ƶ�һ�񣬵����ܽ�������������������λ֮�ʹ���k�ĸ��ӡ����磬��kΪ18ʱ��������
//�ܹ����뷽��(35, 37)����Ϊ3+5+3+7=18���������ܽ��뷽��(35, 38)����Ϊ3+5+3+8=19������
//�û������ܹ�������ٸ����ӣ�
//˼·
//	��(12) �����е�·�����ƣ�Ҳ���û��ݷ������жϻ������ܷ����(i,j)�����ж���Χ4�����ӡ�
//���ⷵ�ص���intֵ��
public class Offer13_RobotMove {
	public int movingCount(int threshold, int rows, int cols) {
		if (rows <= 0 || cols <= 0 || threshold < 0)
			return 0;
		
		boolean[][] isVisited = new boolean[rows][cols];
		int count = movingCountCore(threshold, 0, 0, rows, cols, isVisited);
		return count;
	}

	private int movingCountCore(int threshold, int row, int col, int rows, int cols, boolean[][] isVisited) {
		if (row < 0 || col < 0 || row >= rows || col >= cols || isVisited[row][col]
				|| cal(row) + cal(col) > threshold)
			return 0;
		
		isVisited[row][col] = true;
		return 1 + movingCountCore(threshold, row - 1, col, rows, cols, isVisited)
				+ movingCountCore(threshold, row + 1, col, rows, cols, isVisited)
				+ movingCountCore(threshold, row, col - 1, rows, cols, isVisited)
				+ movingCountCore(threshold, row, col + 1, rows, cols, isVisited);
	}

	private int cal(int num) {
		int sum = 0;
		while (num != 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}

	void test(String testName, int threshold, int rows, int cols, int expected) {
		if (testName != null)
			System.out.print(testName + ":");

		if (movingCount(threshold, rows, cols) == expected)
			System.out.println("Passed.");
		else
			System.out.println("Failed.");
	}

	// ������ж���
	void test1() {
		test("Test1", 5, 10, 10, 21);
	}

	// ������ж���
	void test2() {
		test("Test2", 15, 20, 20, 359);
	}

	// ����ֻ��һ�У�������ֻ�ܵ��ﲿ�ַ���
	void test3() {
		test("Test3", 10, 1, 100, 29);
	}

	// ����ֻ��һ�У��������ܵ������з���
	void test4() {
		test("Test4", 10, 1, 10, 10);
	}

	// ����ֻ��һ�У�������ֻ�ܵ��ﲿ�ַ���
	void test5() {
		test("Test5", 15, 100, 1, 79);
	}

	// ����ֻ��һ�У��������ܵ������з���
	void test6() {
		test("Test6", 15, 10, 1, 10);
	}

	// ����ֻ��һ��һ��
	void test7() {
		test("Test7", 15, 1, 1, 1);
	}

	// ����ֻ��һ��һ��
	void test8() {
		test("Test8", 0, 1, 1, 1);
	}

	// �����˲��ܽ�������һ������
	void test9() {
		test("Test9", -10, 10, 10, 0);
	}

	public static void main(String[] args) {
		Offer13_RobotMove demo = new Offer13_RobotMove();
		demo.test1();
		demo.test2();
		demo.test3();
		demo.test4();
		demo.test5();
		demo.test6();
		demo.test7();
		demo.test8();
		demo.test9();
	}

}
