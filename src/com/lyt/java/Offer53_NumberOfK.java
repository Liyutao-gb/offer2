package com.lyt.java;

//��Ŀ
//	ͳ��һ�����������������г��ֵĴ���������������������{1, 2, 3, 3,3, 3, 4, 5}������3��
//����3����������г�����4�Σ�������4��
//˼·
//	����������������˵��������ö��ַ��ҵ�ĳһ��3������ǰ�����������������һ����
//���һ��3���ڳ���Ϊn���������п��ܳ���O(n)��3�����������ɨ�跽��ʱ�临�Ӷ�ΪO(n)��
//Ч�����ͷ��βɨ��һ�����ٶ�̫����
//	����ؼ����ҵ���һ�������һ��3��������ǳ��ԸĽ����ַ����м����ֱ�3�����С�����
//��֮ǰ���ƣ��ؼ����м����ֵ���3���������ʱ���Է����������£�
//	1������м����ֵ�ǰһ������Ҳ����3��˵����һ��3��ǰ�棬������ǰ��β��ҵ�һ��3��
//	2������м����ֵ�ǰһ�����ֲ�����3��˵����λ���ǵ�һ��3��
//	3������м����ֵĺ�һ������Ҳ����3��˵�����һ��3�ں��棬�����ں��β������һ��3��
//	4������м����ֵĺ�һ�����ֲ�����3��˵����λ�������һ��3��
public class Offer53_NumberOfK {
	public int getNumberOfK(int[] arr, int k) {
		if (arr == null || arr.length <= 0)
			throw new RuntimeException("���鲻�Ϸ�");
		
		int firstK = getFirstK(arr, 0, arr.length - 1, k);
		if (firstK == -1)
			throw new RuntimeException("�����ڸ�����");
		
		int lastK = getLastK(arr, firstK, arr.length - 1, k);
		return lastK - firstK + 1;
	}

	private int getFirstK(int[] arr, int start, int end, int k) {
		if (start > end)
			return -1;
		
		int mid = (start + end) >> 1;
		if (arr[mid] == k) {
			if (mid == 0 || arr[mid - 1] != k)
				return mid;
			else
				end = mid - 1;
		} else if (arr[mid] < k) {
			start = mid + 1;
		} else {
			end = mid - 1;
		}
		return getFirstK(arr, start, end, k);
	}

	private int getLastK(int[] arr, int start, int end, int k) {
		if (start > end)
			return -1;
		
		int mid = (start + end) >> 1;
		if (arr[mid] == k) {
			if (mid == arr.length - 1 || arr[mid + 1] != k)
				return mid;
			else
				start = mid + 1;
		} else if (arr[mid] < k) {
			start = mid + 1;
		} else {
			end = mid - 1;
		}
		return getLastK(arr, start, end, k);
	}

	public static void main(String[] args) {
		Offer53_NumberOfK demo = new Offer53_NumberOfK();
		int[] arr = { 1, 2, 3, 3, 3, 3, 4, 5 };
		int i = demo.getNumberOfK(arr, 3);
		System.out.println(i);
	}
}
