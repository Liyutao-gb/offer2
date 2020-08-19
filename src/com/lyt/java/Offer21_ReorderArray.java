package com.lyt.java;

import java.util.Arrays;
//��Ŀ
//	����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ����������λ�������
//ǰ�벿�֣�����ż��λ������ĺ�벿�֡�
//˼·
//	��������һ���������飬����һ��ָ�룬��ǰ�����ߣ��������������ָ����ƣ�����ż��ʱ��
//ϣ���Ѹ�ż������������棻��ˣ�������һ��ָ�룬�Ӻ���ǰ�ߣ�����ż��ʱָ��ǰ�ƣ�����
//����ʱ����ǡ�ÿ�����ǰ���ָ����ָ��ż�����е�����
public class Offer21_ReorderArray {
	/**
	 * 1.����ƶ�lowָ�룬ֱ����ָ��ż��
	 * 2.��ǰ�ƶ�highָ�룬ֱ����ָ������
	 * 3.��low < high����ֵ
	 */
	public void reOrderArray(int[] arr) {
		if (arr == null || arr.length == 0)
			return;
		
		int low = 0;
		int high = arr.length - 1;
		while (low < high) {
			while (low < arr.length && isOdd(arr[low]))
				low++;
			while (high >= 0 && !isOdd(arr[high]))
				high--;
			if (low < high) {
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
			}
		}
	}
	
	/**
	 * ���߼���ܳ������
	 */
	private boolean isOdd(int n) {
		return (n & 1) == 1;
	}

	// ===============���Դ���===================
	void test1() {
		int[] array = null;
		System.out.println("ԭʼ���飺" + Arrays.toString(array));
		reOrderArray(array);
		System.out.println("���������" + Arrays.toString(array));
		System.out.println();
	}

	void test2() {
		int[] array = {};
		System.out.println("ԭʼ���飺" + Arrays.toString(array));
		reOrderArray(array);
		System.out.println("���������" + Arrays.toString(array));
		System.out.println();
	}

	void test3() {
		int[] array = { -2, 4, -6, 1, -3, 5 };
		System.out.println("ԭʼ���飺" + Arrays.toString(array));
		reOrderArray(array);
		System.out.println("���������" + Arrays.toString(array));
		System.out.println();
	}

	void test4() {
		int[] array = { -1, 3, -5, 2, -4, 6 };
		System.out.println("ԭʼ���飺" + Arrays.toString(array));
		reOrderArray(array);
		System.out.println("���������" + Arrays.toString(array));
		System.out.println();
	}

	void test5() {
		int[] array = { -1, 2, -3, 4, -5, 6 };
		System.out.println("ԭʼ���飺" + Arrays.toString(array));
		reOrderArray(array);
		System.out.println("���������" + Arrays.toString(array));
		System.out.println();
	}

	void test6() {
		int[] array = { 2, 2, 1, 3, 4, 1 };
		System.out.println("ԭʼ���飺" + Arrays.toString(array));
		reOrderArray(array);
		System.out.println("���������" + Arrays.toString(array));
		System.out.println();
	}

	void test7() {
		int[] array = { 1 };
		System.out.println("ԭʼ���飺" + Arrays.toString(array));
		reOrderArray(array);
		System.out.println("���������" + Arrays.toString(array));
		System.out.println();
	}

	public static void main(String[] args) {
		Offer21_ReorderArray demo = new Offer21_ReorderArray();
		demo.test1();
		demo.test2();
		demo.test3();
		demo.test4();
		demo.test5();
		demo.test6();
		demo.test7();
	}
}
