package com.lyt.java;

//��Ŀ
//	��ʵ��һ������������һ��������������������Ʊ�ʾ��1�ĸ����������9��ʾ�ɶ�������1001
//��2λ��1������������9���ú������2��
//˼·
//	������������йص���Ŀ��Ӧ���뵽λ����(�롢��������ơ�����)��
//	����һ���������㡱��һ�����ʣ�ͨ�����Ӧλ��Ϊ1������λΪ0�������������㣬����ĳһ����
//ָ��λ�ϵ�ֵ��������У��Ȱ�����n��1�������㣬�ж����λ�Ƿ�Ϊ1�����Ű�1����һλ����n��
//�����㣬�����жϴε�λ�Ƿ�Ϊ1�����������ƣ����ɶ�ÿһ��λ�ö������жϣ��Ӷ����Ի��1�ĸ�
//�������ַ�����Ҫѭ���ж�32�Ρ�
//	��������better�������һ��������Ϊ0�������������1����ôԭ�������������ұߵ�1�ͻ��
//Ϊ0��ԭ����1��������е�0������1����������λ�������ܵ�Ӱ�졣�ٰ�ԭ���������ͼ�ȥ1֮
//��Ľ���������㣬��ԭ���������ұ�һ��1��һλ��ʼ����λ������0����ˣ���һ��������1��
//�ٺ�ԭ���������������㣬��Ѹ��������ұߵ�1���0�����ַ������������м���1����ֻ��Ҫѭ
//���жϼ��Ρ�
// >> ������λ��0,������λ��1	;	>>> ����������λ����0
//ע���ж�һ������Ϊ2�������η���n > 0 && (n & (n - 1)) == 0
//	    �ж�һ������Ϊ4�������η���n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) == n
public class Offer15_NumberOf1InBinary {
	public int NumberOf1_Solution1(int n) {
		int count = 0;
		int flag = 1;
		while (flag != 0) {
			if ((flag & n) != 0)
				count++;
			flag <<= 1;
		}
		return count;
	}

	public int NumberOf1_Solution2(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n = (n - 1) & n;
		}
		return count;
	}

	// =========���Դ���========= 

	void test(String testName, int n, int expected) {
		if (testName != null)
			System.out.println(testName + ":");
		if (NumberOf1_Solution1(n) == expected) {
			System.out.print("    soluton1:" + "passed  ");
		} else {
			System.out.print("    solution1:" + "failed  ");
		}

		if (NumberOf1_Solution2(n) == expected) {
			System.out.println("soluton2:" + "passed  ");
		} else {
			System.out.println("solution2:" + "failed  ");
		}
	}

	void test1() {
		test("Test for 0", 0, 0);
	}

	void test2() {
		test("Test for 1", 1, 1);
	}

	void test3() {
		test("Test for 10", 10, 2);
	}

	void test4() {
		test("Test for 0x7FFFFFFF", 0x7FFFFFFF, 31);
	}

	void test5() {
		test("Test for 0xFFFFFFFF", 0xFFFFFFFF, 32);
	}

	void test6() {
		test("Test for 0x80000000", 0x80000000, 1);
	}

	public static void main(String[] args) {
		Offer15_NumberOf1InBinary demo = new Offer15_NumberOf1InBinary();
		demo.test1();
		demo.test2();
		demo.test3();
		demo.test4();
		demo.test5();
		demo.test6();
	}
}
