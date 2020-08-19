package com.lyt.java;

//��Ŀ
//	��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת������һ����������
//�������һ����ת�������ת�������СԪ�ء���������{3, 4, 5, 1, 2}Ϊ{1, 2, 3, 4, 5}
//��һ����ת�����������СֵΪ1��
//˼·
//	������һ���̶���������ģ������׷����������Բ��ö��ַ���Ѱ����С���֡�
//������������һЩ���壺
//	1.������������ı������Լ�����ת������С�����ǵ�һ������
//	2.�м���������β����(����һ��)��С��ȣ���{1,0,1,1,1,1}��{1,1,1,1,0,1}���޷�����
//���ַ���ֻ��˳�����
public class Offer11_MinNumberInRotatedArray {
	/**
	 * 1.���鱾�����������ת 
	 * 2.�м���������β������� 
	 * 3.�������
	 */
	public int minNumberInRotateArray(int[] nums) {
		if (nums == null || nums.length <= 0)
			return -1;

		int low = 0;
		int high = nums.length - 1;
		int mid = (low + high) >> 1;

		if (nums[low] < nums[high])
			return nums[low];

		if (nums[mid] == nums[high] && nums[mid] == nums[low]) {
			for (int i = 1; i <= high; i++) {
				if (nums[i] < nums[i - 1]) // Ψһ��
					return i;
			}
			return low;// ����ȫ��Ϊĳ����(һ����)
		}

		while (low + 1 != high) {
			mid = (low + high) >> 1;
			if (nums[mid] <= nums[high]) // if (nums[mid] >= nums[low])
				high = mid;
			else
				low = mid;
		}
		return high;
	}

	public void test1() {
		int[] array = null;
		System.out.println("test1:" + minNumberInRotateArray(array));
	}

	public void test2() {
		int[] array = {};
		System.out.println("test2:" + minNumberInRotateArray(array));
	}

	public void test3() {
		int[] array = { 1 };
		System.out.println("test3:" + minNumberInRotateArray(array));
	}

	public void test4() {
		int[] array = { 1, 2, 3, 4, 5, 6 };
		System.out.println("test4:" + minNumberInRotateArray(array));
	}

	public void test5() {
		int[] array = { 2, 2, 2, 2, 1, 2 };
		System.out.println("test5:" + minNumberInRotateArray(array));
	}

	public void test6() {
		int[] array = { 2, 0, 1, 1, 1 };
		System.out.println("test6:" + minNumberInRotateArray(array));
	}

	public void test7() {
		int[] array = { 6, 6, 8, 9, 10, 1, 2, 2, 3, 3, 4, 5, 6 };
		System.out.println("test7:" + minNumberInRotateArray(array));
	}

	public static void main(String[] args) {
		Offer11_MinNumberInRotatedArray demo = new Offer11_MinNumberInRotatedArray();
		demo.test1();
		demo.test2();
		demo.test3();
		demo.test4();
		demo.test5();
		demo.test6();
		demo.test7();
	}
}
