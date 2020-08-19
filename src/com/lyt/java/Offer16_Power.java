package com.lyt.java;

//��Ŀ
//	ʵ�ֺ���double Power(double base, int exponent)����base��exponent�η�������ʹ��
//�⺯����ͬʱ����Ҫ���Ǵ������⡣
//˼·
//	����������ʵ�֣�����Ҫע���������壺
//1) 0�ĸ����η������ڣ�
//2) 0��0�η�û����ѧ����;
//3) Ҫ����exponentΪ��������������ȶ�exponent���з������ۣ��ٶ�base�Ƿ�Ϊ0�������ۡ�
public class Offer16_Power {
	/**
	 * ����һ
	 */
	public double power(double x, int n) {
		double result;
		if (n > 0) {
			result = powerCore1(x, n);
		} else if (n < 0) {
			if (x == 0) {
				System.out.println("0û�и�������!");
				return 0;
			}
			result = 1 / powerCore1(x, -n);
		} else {
			if (x == 0) {
				System.out.println("0û��0����!");
			}
			return 1;
		}
		return result;
	}
	
	/**
	 * ѭ��
	 * exponent >>= 1��ѭ����exponent >>>= 1���󣬱��磺2.0  ���0.0
	 * ������10^1101 = 10^0001*10^0100*10^1000
	 * 		��10^1+10^4+10^8
	 */
	public double powerCore1(double base, int exponent) {
		double result = 1;
		while (exponent != 0) {
			if ((exponent & 0x1) == 1)
				result *= base;
			exponent /= 2;
			base *= base; // ָ������һλ����������
		}
		return result;
	}
	
	/**
	 * �ݹ�
	 */
	private double powerCore2(double x, int n) {
		if (n == 0)
			return 1;

		double result = powerCore2(x, n / 2);
		result *= result;
		if ((n & 0x1) == 1)
			result *= x;
		return result;
	}

	/**
	 * ������
	 */
	public double myPow(double x, int n) {
		double result = 1.0;
		for (int i = n; i != 0; i /= 2) {
			if ((i & 1) == 1)
				result *= x;
			x *= x;	 // ָ������һλ����������
		}
		return n < 0 ? 1 / result : result;
	}

	public static void main(String[] args) {
		Offer16_Power demo = new Offer16_Power();
		System.out.print("0��6�η�:");
		System.out.println(demo.power(0, 6));
		System.out.print("0��-6�η�:");
		System.out.println(demo.power(0, -6));
		System.out.print("0��0�η�:");
		System.out.println(demo.power(0, 0));
		System.out.print("2��6�η�:");
		System.out.println(demo.power(2, 6));
		System.out.print("2��-3�η�:");
		System.out.println(demo.power(2, -3));
		System.out.print("5��0�η�:");
		System.out.println(demo.power(5, 0));
		System.out.print("-2��6�η�:");
		System.out.println(demo.power(-2, 6));
		System.out.print("1��-2147483648�η�:");
		System.out.println(demo.power(1, -2147483648));
		System.out.print("1��-2147483648�η�:");
		System.out.println(demo.powerCore2(2, 5));
	}
}
