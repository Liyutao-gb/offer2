package com.lyt.java;

//��Ŀ
//	����һ�������������������ÿ��Ԫ�ض�������������Ψһ�ġ�����ʵ��һ�������ҳ�������
//����һ����ֵ�������±��Ԫ�ء����磬������{-3, -1,1, 3, 5}�У�����3�������±���ȡ�
//˼·
//	ͬ53-1��53-2һ�������ٴ�ͷ��β�������������������飬���Ǽ�������ʹ�ö��ֲ����㷨��
//1�����м����ֵ������±�ʱ���м����ּ�Ϊ�������֣�
//2�����м����ִ������±�ʱ������벿������Ѱ�ң�
//3�����м�����С�����±�ʱ�����Ұ벿������Ѱ�ң�
public class Offer53_IntegerIdenticalToIndex {
	public int getNumberSameAsIndex(int[] arr) {
		if (arr == null || arr.length <= 0)
			throw new RuntimeException("���鲻�Ϸ�");

		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = (high + low) >> 1;
			if (arr[mid] > mid)
				high = mid - 1;
			else if (arr[mid] < mid)
				low = mid + 1;
			else
				return mid;
		}
		return -1;
	}

	public static void main(String[] args) {
		Offer53_IntegerIdenticalToIndex demo = new Offer53_IntegerIdenticalToIndex();
		int[] arr = new int[] { -3, -1, 1, 3, 5 };
		int numberSameAsIndex = demo.getNumberSameAsIndex(arr);
		System.out.println(numberSameAsIndex);
	}
}
