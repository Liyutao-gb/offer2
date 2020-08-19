package com.lyt.java;

import java.util.Arrays;
//��Ŀ
//	���˿����������5���ƣ��ж��ǲ���һ��˳�ӣ�����5�����ǲ��������ġ�2��10Ϊ���ֱ���
//AΪ1��JΪ11��QΪ12��KΪ13������С�����Կ����������֡�
//˼·
//	����Ϊ��С����5�����飨��С����Ϊ0�������Ϊ����ֵ�����岽�����£�
//1�����ж�5���ƽ�������
//2���ҳ�0�ĸ�����
//3������������ֵĿ�ȱ������
//4�����0�ĸ������ڵ��ڿ�ȱ������˵����������֮��������
//5���ǵ��ж����������Ƿ���ȣ�����г�����ȣ�˵������˳�ӡ�
public class Offer61_ContinousCards {
	public boolean isContinuous(int[] numbers) {
		if (numbers == null || numbers.length <= 0)
			throw new RuntimeException("���鲻�Ϸ�");

		Arrays.sort(numbers);
		int numberOf0 = 0;
		int numberOfGap = 0;
		// 1.ͳ��0(��С��)�ĸ��� 
		for (int i : numbers) {
			if (i == 0)
				numberOf0++;
		}

		int small = numberOf0;
		int big = numberOf0 + 1;
		while (big < numbers.length) {
			if (numbers[small] == numbers[big]) // �����в������������
				return false;
			numberOfGap += numbers[big++] - numbers[small++] - 1;
		}

		return numberOf0 >= numberOfGap; // 0�ĸ��� >= gap��϶��
	}

	public static void main(String[] args) {
		Offer61_ContinousCards demo = new Offer61_ContinousCards();
		int[] arr = new int[] { 0, 1, 3, 4, 5 };
		boolean continuous = demo.isContinuous(arr);
		System.out.println(continuous);
	}
}
