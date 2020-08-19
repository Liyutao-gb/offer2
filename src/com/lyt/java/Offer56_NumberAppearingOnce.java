package com.lyt.java;

//��Ŀ
//	��һ�������г���һ������ֻ����һ��֮��,�������ֶ����������Ρ����ҳ��Ǹ�ֻ����һ�ε�
//���֡�
//˼·
//	����������ֳ��������Σ��޷���������ֻ����һ�ε���������һ��ͨ���������λ�������
//������ͬ�����֡�������Ȼ��������λ�����˼·��
//	���������ֵĶ����Ʊ�ʾ�Ķ�Ӧλ�������������ĳһλ�ܱ�����������ôֻ����һ�ε�����
//�ڸ�λΪ0����֮��Ϊ1��
public class Offer56_NumberAppearingOnce {
	public int singleNumber(int[] nums) {
		if (nums == null || nums.length <= 0)
			throw new RuntimeException("���鲻�Ϸ�");

		int[] bits = new int[32];

		for (int i = 0; i < bits.length; i++) {
			for (int j = 0; j < nums.length; j++) { // ÿһλ���ֶ�Ӧ��0��1������
				int num = nums[j] >> i;
				bits[i] += (num & 1);
			}
		}

		// �ǻ۽ⷨ(������ �� ʮ����)
		int result = 0;
		for (int i = bits.length - 1; i >= 0; i--) {
			result <<= 1;
			result += bits[i] % 3;
		}
		return result;
	}

	public static void main(String[] args) {
		Offer56_NumberAppearingOnce demo = new Offer56_NumberAppearingOnce();
		int[] arr = { 2, 2, 2, 5, 3, 3, 3, 6, 6, 6 };
		int appearingOnce = demo.singleNumber(arr);
		System.out.println(appearingOnce);
	}
}
