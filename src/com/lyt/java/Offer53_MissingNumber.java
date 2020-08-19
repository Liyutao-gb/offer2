package com.lyt.java;

//��Ŀ
//	һ������Ϊn-1�ĵ������������е��������ֶ���Ψһ�ģ�����ÿ�����ֶ��ڷ�Χ0��n-1֮�ڡ�
//�ڷ�Χ0��n-1��n������������ֻ��һ�����ֲ��ڸ������У����ҳ�������֡�
//˼·
//	�����ͷ��β���αȽ�ֵ��С���Ƿ���ȣ�ʱ�临�Ӷ�ΪO(n)��Ч�ʵ͡�
//�������������飬���Ǽ�������ʹ�ö��ֲ����㷨,�ҳ������е�һ��ֵ���±겻��ȵ�Ԫ�ء�
//�����м����ֵ������±�ʱ�������ں�벿�ֲ��ң�
//�����м����ֲ��������±�ʱ��
//����1������м����ֵ�ǰһ������Ҳ���������±꣬����ǰ�벿�ֲ��ң�
//����2������м����ֵ�ǰһ�����ֵ������±꣬��˵���м����ֵ��±꼴Ϊ������Ҫ�ҵ����֡�
public class Offer53_MissingNumber {
	public int getMissingNumber(int[] arr) {
		if (arr == null || arr.length <= 0)
			throw new RuntimeException("���鲻�Ϸ�");
		
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] != mid) {
				if (mid == 0 || arr[mid - 1] == mid - 1)
					return mid;
				else
					high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Offer53_MissingNumber demo = new Offer53_MissingNumber();
		int[] arr = { 0, 2, 3, 4, 5 };
		int number = demo.getMissingNumber(arr);
		System.out.println(number);
	}
}
