package com.lyt.java;

//��Ŀ��
//	������0123456789101112131415���ĸ�ʽ���л���һ���ַ������С�����������У���5λ
//����0��ʼ��������5����13λ��1����19λ��4���ȵȡ���дһ������������λ��Ӧ�����֡�
//˼·
//	��һö�����֣�����ÿ�����ֵ�λ����ӣ�Ч��̫�͡�
//�۲���ɣ�
//	��λ���ĸ���һ����10������0~9����ռ��10*1λ���֣�
//	��λ���ĸ���һ����90������10~99��ÿ������ռ��λ����ռ��90*2λ���֣�
//	����
//mλ���ĸ���һ����9*10^(m-1)����ÿ������ռmλ��ռ��9*10^(m-1)*mλ���֡�
//�жϵ�n���Ե����������ڼ�λ�����ٴӼ�λ���н���Ѱ�ҡ�
//ע����0��ʼ��������1��ʼ������ʼҪindex++,����Ķ���ʵ������
public class Offer44_DigitsInSequenc {
	public int digitAtIndex(int index) {
		if (index < 0)
			return -1;

		int m = 1;// mλ��
		while (true) {
			// mλ������λ��
			int num = numbersOfIntegers(m);
			if (index < num) 
				return getDigit(index, m);
			index -= num;
			m++;
		}
	}

	// ����mλ������λ�� ���磬��λ��һ����90����10~99����λ����900����100~999
	private int numbersOfIntegers(int m) {
		return m == 1 ? 10 : (int) (9 * Math.pow(10, m - 1) * m);
	}

	// ��ȡ����
	private int getDigit(int index, int m) {
		int number = getFirstNumber(m) + index / m; // ��Ӧ��mλ��
		int indexFromRight = m - index % m; // �������е�λ��
		for (int i = 1; i < indexFromRight; i++)
			number /= 10;
		return number % 10;
	}

	// ��һ��mλ�� �����һ����λ����10����һ����λ����100
	private int getFirstNumber(int m) {
		return m == 1 ? 0 : (int) Math.pow(10, m - 1);
	}

	public static void main(String[] args) {
		Offer44_DigitsInSequenc demo = new Offer44_DigitsInSequenc();
		System.out.println(demo.digitAtIndex(0) == 0);
		System.out.println(demo.digitAtIndex(1) == 1);
		System.out.println(demo.digitAtIndex(10) == 1);
		System.out.println(demo.digitAtIndex(190) == 1);
		System.out.println(demo.digitAtIndex(1000) == 3);
		System.out.println(demo.digitAtIndex(1001) == 7);
		System.out.println(demo.digitAtIndex(1002) == 0);
	}
}
