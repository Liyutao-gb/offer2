package com.lyt.java;

//��Ŀ��
//	����һ���������飬������������Ҳ�и�����������һ���������Ķ����/�����һ�������顣
//������������ĺ͵����ֵ��Ҫ��ʱ�临�Ӷ�ΪO(n)��
//˼·
//	�������ɣ��ӵ�һ�����ֿ�ʼ�ۼӣ����ߵ�ĳһ������ʱ��ǰ����ۼӺ�Ϊ������˵������
//�����ۼ��ˣ�Ҫ�ӵ�ǰ�������¿�ʼ�ۼӡ����ۼӹ����У���ÿ���ۼӺ͵����ֵ��¼������
//������ɺ󣬷��ظ����֡�
public class Offer42_GreatestSumOfSubarrays {
	public int getGreatestSumOfSubArray(int[] arr) {
		if (arr == null || arr.length <= 0)
			return 0;
			
		int sum = arr[0];
		int maxSum = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (sum > 0) {
				sum += arr[i];
			} else {
				sum = arr[i];
			}
			maxSum = Math.max(maxSum, sum);
		}
		return maxSum;
	}

	public static void main(String[] args) {
		Offer42_GreatestSumOfSubarrays demo = new Offer42_GreatestSumOfSubarrays();
		int[] arr = {3, 5, -2, -5, 7, -4 };
		int sum = demo.getGreatestSumOfSubArray(arr);
		System.out.println(sum);
	}
}
