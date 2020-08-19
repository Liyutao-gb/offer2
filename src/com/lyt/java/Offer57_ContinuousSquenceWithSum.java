package com.lyt.java;

import java.util.ArrayList;
import java.util.List;

//��Ŀ
//	����һ������s����ӡ�����к�Ϊs�������������У����ٺ���������������������15��
//����1+2+3+4+5=4+5+6=7+8=15�����Խ����ӡ��3����������1��5��4��6��7��8��
//˼·:ָ�뷨
//	����(57-1) ��Ϊs���������ֵķ�����������ָ��small��big�ֱ�������е����ֵ����Сֵ��
//��small��1��ʼ��big��2��ʼ��
//����small��big�����еĺ�С��sʱ������big��ʹ���а����������֣����ǵø�������֮�ͣ�
//����small��big�����еĺʹ���sʱ������small��ʹ����ȥ����С�����֣����ǵø�������֮�ͣ�
//����small��big�����еĺ͵���sʱ����ʱ�õ�һ��������ĿҪ������У������Ȼ�������
//small�������������µ����С�
//���������������֣���ˣ���small����s/2ʱ���Ϳ��Խ����ж��ˡ�
public class Offer57_ContinuousSquenceWithSum {
	// ����һ����������ָ��ķ���
	public List<List<Integer>> findContinuousSequence1(int sum) {
		if (sum < 3)
			throw new RuntimeException("��������");

		List<List<Integer>> sequenceList = new ArrayList<>();
		int small = 1;
		int big = 2;
		int curSum = small + big;
		while (small <= sum / 2) {
			if (curSum == sum) {
				List<Integer> sequence = new ArrayList<Integer>();
				for (int i = small; i <= big; i++) {
					sequence.add(i);
				}
				sequenceList.add(sequence);
				curSum -= small;
				small++; // ������λ���Ⱥ�Ҫע��
			}
			if (curSum < sum) {
				big++;
				curSum += big;
			}
			if (curSum > sum) {
				curSum -= small;
				small++;
			}
		}
		return sequenceList;
	}

	// ����������ѧ������
	public List<List<Integer>> findContinuousSequence2(int sum) {
		List<List<Integer>> sequenceList = new ArrayList<>();
		if (sum <= 0)
			return sequenceList;

		for (int n = (int) Math.sqrt(2 * sum); n >= 2; n--) {
			if (((n & 1) == 1 && sum % n == 0) || ((n & 1) == 0 && (sum % n) * 2 == n)) {
				ArrayList<Integer> sequence = new ArrayList<>();
				for (int j = 0, k = (sum / n) - (n - 1) / 2; j < n; j++, k++) {
					sequence.add(k);
				}
				sequenceList.add(sequence);
			}
		}
		return sequenceList;
	}

	public static void main(String[] args) {
		Offer57_ContinuousSquenceWithSum demo = new Offer57_ContinuousSquenceWithSum();
		// 14 ����������7,7 6+7����ʱ���һ��8,7+8�ֻᳬ��14,small = 8���˳�ѭ����
		List<List<Integer>> sequence1 = demo.findContinuousSequence1(15);
		for (List<Integer> list : sequence1) {
			System.out.println(list);
		}
	}
}
