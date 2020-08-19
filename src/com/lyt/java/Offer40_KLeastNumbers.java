package com.lyt.java;

import java.util.ArrayList;
import java.util.Arrays;

//��Ŀ��
//	����n���������ҳ�������С��k��������������4��5��1��6��2��7��3��8��8�����֣�
//����С��4��������1��2��3��4��
//˼·
//	˼·һ��ͬ��ָoffer(39) �����г��ִ�������һ���������ʹ��partition()������
//��������ĵ�k�����ֵ�����ʹ�ø�С��k�����ֶ���������߼��ɡ�
//	˼·�������α���n����������һ�����������С��k�����֣�ÿ��������������������
//��С������ʱ�������ֵ�滻Ϊ�����֡���������ʹ�����ѻ��ߺ������ʵ�֡����ĸ���
//�������ԭ����ʵ�֡��ر��ʺϴ��������ݣ��������޴��ڴ�ֻ�ܹ�����k������ÿ��
//�Ӵ�����ȡ����,�Ƚ��ڴ��е����ַ������
//��չ������k�������޸���С��,�ͱȽϷ����������ɡ����� �� �ۣ�
public class Offer40_KLeastNumbers {
	/**
	 * ����һ�����ڶѵ�������ʱ�临�Ӷ�O(nlogk)
	 * 		1.�ȷ���ǰk����
	 * 		2.�����鹹���������ʽ,�ϸ�
	 * 		3.���ڸ�С������ʱ, ���µ�������,�³�
	 * @param input
	 * @param k ��������
	 * @return
	 */
	public int[] getLeastNumbers(int[] input, int k) {
		if (input == null || k <= 0 || k > input.length)
			return new int[] {};

		int[] numbers = new int[k];
		for (int i = 0; i < k; i++)
			numbers[i] = input[i];
		for (int i = k / 2 - 1; i >= 0; i--) {
			adjustHeap(numbers, i, k - 1);
		}
		for (int i = k; i < input.length; i++) {
			if (input[i] < numbers[0]) { // ��
				numbers[0] = input[i];
				adjustHeap(numbers, 0, k - 1);
			}
		}
		return numbers;
	}

	// ����������
	private void adjustHeap(int[] arr, int start, int end) {
		int temp = arr[start];
		int child = start * 2 + 1;
		while (child <= end) {
			if (child + 1 <= end && arr[child] < arr[child + 1])// ��
				child++;
			if (arr[child] < temp)// ��
				break;
			arr[start] = arr[child];
			start = child;
			child = child * 2 + 1;
		}
		arr[start] = temp;
	}

	public static void main(String[] args) {
		Offer40_KLeastNumbers demo = new Offer40_KLeastNumbers();
		int[] arr = new int[] { 4, 5, 1, 6, 2, 7, 3, 8 };
		int k = 4;
		int[] leastNumbers = demo.getLeastNumbers(arr, k);
		System.out.print("��С��" + k + "�����ǣ�" + Arrays.toString(leastNumbers));
	}

	/*
	 * ������������partition() ʱ�临�Ӷ�O(n)
	 */
	public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
		ArrayList<Integer> leastNumbers = new ArrayList<Integer>();
		while (input == null || k <= 0 || k > input.length)
			return leastNumbers;
		int start = 0;
		int end = input.length - 1;
		int index = partition(input, start, end);
		while (index != k - 1) {
			if (index < k - 1) {
				start = index + 1;
				index = partition(input, start, end);
			} else {
				end = index - 1;
				index = partition(input, start, end);
			}
		}
		for (int i = 0; i < k; i++) {
			leastNumbers.add(input[i]);
		}
		return leastNumbers;
	}

	private int partition(int[] arr, int start, int end) {
		int pivotKey = arr[start];
		while (start < end) {
			while (start < end && arr[end] >= pivotKey)
				end--;
			swap(arr, start, end);
			while (start < end && arr[start] <= pivotKey)
				start++;
			swap(arr, start, end);
		}
		return start;
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
