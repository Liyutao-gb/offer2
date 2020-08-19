package com.lyt.java;

//��Ŀ
//	��������n����˳���ӡ����1����nλʮ����������������3�����ӡ��1��2��3һֱ������
//3λ����999��
//˼·
//	���壺n����ʱ �Ǵ������⣬���ܼ���int����long�����������Ҫ�����ַ�������������
//������
//���������ͨ���ַ�����char[]������������֡�
//	1�����ַ�������������ģ��ӷ���
//	2�����ַ����������ִ�ӡ������
public class Offer17_Print1ToMaxOfNDigits {
	/**
	 * ����ģ���һ�ķ���
	 */
	public void print1ToMaxOfNDights(int n) {
		if (n <= 0)
			return;
		
		char[] digit = new char[n];
		for (int i = 0; i < n; i++)
			digit[i] = '0';
		
		for (int i = n - 1; i >= 0; i--) {
			while (digit[i] != '9') {	// 0-900 �� 901-990 �� 991-999
				int m = 0;
				digit[m]++;
				while (m + 1 < n && digit[m] > '9') { // m + 1 < n
					digit[m] = '0';
					digit[m + 1]++;
					m++;	// ���ж���ѭ��,����99
				}
				printDigits(digit);
			}
		}
	}

	private void printDigits(char[] digit) {
		int len = digit.length - 1;
		while (digit[len] == '0')	// ȥ�ײ�0
			len--;
		for (int i = len; i >= 0; i--)
			System.out.print(digit[i]);
		System.out.println();
	}
	
	// ========���Դ���=============
	void test(int nDigits) {
		System.out.println("===test begin===");
		System.out.println("method:");
		print1ToMaxOfNDights(nDigits);
		System.out.println("===test over===");
	}

	public static void main(String[] args) {
		Offer17_Print1ToMaxOfNDigits demo = new Offer17_Print1ToMaxOfNDigits();
		demo.test(-1);
		demo.test(0);
		demo.test(1);
		demo.test(2);
	}
}
