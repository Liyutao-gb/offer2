package com.lyt.java;

//��Ŀ������
//	��ֻ��������2��3��5��������������Ugly Number�����󰴴�С�����˳��ĵ�1500��������
//����6��8���ǳ�������14���ǣ���Ϊ����������7��ϰ�������ǰ�1������һ��������
// ϰ�������ǰ�1�����ǵ�һ��������1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, 16, 18, 20, 24
public class Offer49_UglyNumber {
	/**
	 * �ⷨһ������ж�ÿ�������ǲ��ǳ����Ľⷨ��ֱ�۵�������Ч����������
	 */
	public int getUglyNumber_Solution1(int index) {
		if (index <= 0)
			return 0;

		int number = 0;
		int uglyFound = 0; // ��ʾ�ڼ�������

		while (uglyFound < index) {
			number++;
			if (isUgly(number)) {
				uglyFound++;
			}
		}
		return number;
	}

	public boolean isUgly(int number) {
		while (number % 2 == 0)
			number = number / 2;
		while (number % 3 == 0)
			number = number / 3;
		while (number % 5 == 0)
			number = number / 5;

		return number == 1;
	}

	/**
	 * �ⷨ�����ռ任ʱ�䣬����һ������������ǰ���Ѿ��ҵ��ĳ����������εõ�����ĳ�����
	 * �����Ϳ���ֱ��������Щ���ǳ�������������ÿһ������ȥ�жϡ�
	 * m2,m3,m5	  	num1,num2,num3
	 * 0  0  0		0	0	0
	 * 1  0  0		2	3	5			
	 * 1  1  0		4	3	5		
	 * 2  1  0		4	6	5			
	 * 2  1  1		6	6	5			
	 * 3  2  1		6	6	10			
	 * 4  2  1		8	9	10			
	 */
	public int getUglyNumber_Solution2(int index) {
		if (index <= 0)
			return 0;

		int[] uglyArray = new int[index];
		uglyArray[0] = 1; // ��һ������Ĭ��1

		int mul2 = 0;
		int mul3 = 0;
		int mul5 = 0;

		for (int i = 1; i < index; i++) {
			int min = min(uglyArray[mul2] * 2, uglyArray[mul3] * 3, uglyArray[mul5] * 5);
			uglyArray[i] = min;

			if (uglyArray[mul2] * 2 == uglyArray[i]) {
				mul2++;
			}
			if (uglyArray[mul3] * 3 == uglyArray[i]) {
				mul3++;
			}
			if (uglyArray[mul5] * 5 == uglyArray[i]) {
				mul5++;
			}
		}
		return uglyArray[index - 1];
	}
	
	/**
	 * ��ΪҪ��֤���������Ǵ�С��������ģ�ÿһ����Ҫ�Ƚ�һ������ֵ��ȡ��Сֵ���������У�
	 * Ȼ���ٸ��������Сֵ��
	 */
	private int min(int a, int b, int c) {
		return (a < b) ? (a < c ? a : c) : (b < c ? b : c);
	}

	public static void main(String[] args) {
		Offer49_UglyNumber demo = new Offer49_UglyNumber();
		int number1 = demo.getUglyNumber_Solution1(1500);
		int number2 = demo.getUglyNumber_Solution2(1500);
		System.out.println(number1 == number2);
	}
}
