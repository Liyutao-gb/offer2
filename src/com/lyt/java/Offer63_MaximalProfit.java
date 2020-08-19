package com.lyt.java;

//��Ŀ
// �����ĳ��Ʊ�ļ۸���ʱ���Ⱥ�˳��洢��������,�����������׸ù�Ʊ���ܻ�õ������Ƕ���?
//����һֻ��Ʊ��ĳЩʱ��ڵ�ļ۸�Ϊ{9, 11, 8, 5,7, 12, 16, 14}������������ڼ۸�Ϊ5��
//ʱ�����벢�ڼ۸�Ϊ16ʱ�����������ջ���������11��
//˼·
//	��Ʊ���׵��������Թ�Ʊ����������۸�Ĳ�ۡ�ֻ��������ĳֻ��Ʊ֮�������������ô����
//�������������Ʊ�������ֵĲ�ֵ����ˣ������������������������Ե�����֮����Ȼ������
//��Խ�ͻ������Խ�������ɨ�赽�����е�i������ʱ��ֻҪ�����ܼ�ס֮ǰ��i-1�������е�
//��Сֵ�����������ǰ��λ����ʱ���ܵõ����������
public class Offer63_MaximalProfit {
	public static int MaxDiff(int[] prices) {
		if (prices == null || prices.length < 2)
			throw new RuntimeException("���鲻�Ϸ�");

//		 Ĭ�Ͽ���Ϊ0
//		int min = prices[0];
//		int maxDiff = 0;
//		for (int i = 1; i < prices.length; i++) {
//			if (prices[i - 1] < min)	// �ҳ�֮ǰ����Сֵ
//				min = prices[i - 1];
//		
//			if (prices[i] - min > maxDiff)
//				maxDiff = prices[i] - min;
//		}
//
//		return maxDiff;

		int min = prices[0];
		// �����������Ǹ�����ֻҪ������С����
		int maxDiff = prices[1] - min;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i - 1] < min) // ��¼ "֮ǰ(i-1)" �е���С����
				min = prices[i - 1];
			
			if (prices[i] - min > maxDiff)
				maxDiff = prices[i] - min;
		}

		return maxDiff;
	}

	public static void main(String[] args) {
		int[] arr1 = null;
		System.out.println(MaxDiff(arr1) == -1);

		int[] arr2 = {};
		System.out.println(MaxDiff(arr2) == -1);

		int[] arr3 = { 16, 16, 16, 16, 16 };
		System.out.println(MaxDiff(arr3) == 0);

		int[] arr4 = { 1, 2, 4, 7, 11, 16 };
		System.out.println(MaxDiff(arr4) == 15);

		int[] arr5 = { 16, 11, 7, 4, 2, 1 };
		System.out.println(MaxDiff(arr5) == -1);

		int[] arr6 = { 9, 11, 5, 7, 16, 1, 4, 2 };
		System.out.println(MaxDiff(arr6) == 11);

		int[] arr7 = { 2, 4 };
		System.out.println(MaxDiff(arr7) == 2);

		int[] arr8 = { 4, 2 };
		System.out.println(MaxDiff(arr8) == -2);
	}
}
