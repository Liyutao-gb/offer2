package com.lyt.java;

//题目
//	输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则打印出1、2、3一直到最大的
//3位数即999。
//思路
//	陷阱：n过大时 是大数问题，不能简单用int或者long数据输出，需要采用字符串或者数组表达
//大数。
//解决方法：通过字符数组char[]来进行输出数字。
//	1）在字符串表达的数字上模拟加法；
//	2）把字符串表达的数字打印出来。
public class Offer17_Print1ToMaxOfNDigits {
	/**
	 * 采用模拟加一的方法
	 */
	public void print1ToMaxOfNDights(int n) {
		if (n <= 0)
			return;
		
		char[] digit = new char[n];
		for (int i = 0; i < n; i++)
			digit[i] = '0';
		
		for (int i = n - 1; i >= 0; i--) {
			while (digit[i] != '9') {	// 0-900 → 901-990 → 991-999
				int m = 0;
				digit[m]++;
				while (m + 1 < n && digit[m] > '9') { // m + 1 < n
					digit[m] = '0';
					digit[m + 1]++;
					m++;	// 进行二次循环,比如99
				}
				printDigits(digit);
			}
		}
	}

	private void printDigits(char[] digit) {
		int len = digit.length - 1;
		while (digit[len] == '0')	// 去首部0
			len--;
		for (int i = len; i >= 0; i--)
			System.out.print(digit[i]);
		System.out.println();
	}
	
	// ========测试代码=============
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
