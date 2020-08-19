package com.lyt.java;

//��Ŀ
//	һ�����������������������֮�⣬���������ֶ����������Ρ���д�����ҳ�������ֻ����һ��
//�����֡�Ҫ��ʱ�临�Ӷ���O(n)���ռ临�Ӷ���O(1)��
//˼·
//	������ͬ������������0��
//	���������ֻ��һ������ֻ����һ�Σ����������ֳ������Σ����Ǵ�ͷ��β���ÿ�����֣���ô
//���յĽ���պ����Ǹ�ֻ����һ�ε����֡�������������������������ֻ����һ�Σ�����ܹ���
//�����Ϊ�����֣��������ж�ֻ��һ������ֻ����һ�Σ���ô�Ϳ��Խ���������ˡ�
//���������
//	�������ɴ�ͷ��β���ÿ�����֣���ô���յĽ������������ֻ����һ�ε����ֵ��������
//������������ͬ�����������������һ����һλΪ1���ѽ���е�һ��1��λ�ü�Ϊ��nλ��
//��Ϊ������ֻ����һ�ε����ֵ�����������������������ڵ�nλ�ϵ�����һ����1��0��
//	���������Ǹ���������ÿ�����ֵĵ�nλ�ϵ������Ƿ�Ϊ1�����з��飬ǡ���ܽ������Ϊ
//������ֻ��һ������ֻ����һ�ε����飬�����������ͷ��β��򣬾Ϳ��Եõ����������ˡ�
public class Offer56_NumbersAppearOnce {
	public int[] singleNumber(int[] nums) {
		if (nums == null || nums.length < 2)
			throw new RuntimeException("���鲻�Ϸ�");

		int[] result = new int[2];
		int xor = 0;
		for (int i : nums) {
			xor ^= i;
		}

		int mask = xor & (-xor);
//		int indexOf1 = 0;
//		while (((xor & 1) == 0) && (indexOf1 <= 4 * 8)) {
//			xor = xor >> 1; // ֻ��n>>1��������Ҫn=n>>1
//			indexOf1++;
//		}

		for (int i : nums) {
			 if((i & mask) == mask)	// if (((i >> indexOf1) & 1) == 1) 
				result[0] ^= i;
			else
				result[1] ^= i;
		}

		return result;
	}

	public static void main(String[] args) {
		Offer56_NumbersAppearOnce demo = new Offer56_NumbersAppearOnce();
		int[] nums = new int[] { 2, 4, 3, 6, 3, 2, 5, 5 };
		int[] appearOnce = demo.singleNumber(nums);
		System.out.println(appearOnce[0] + " " + appearOnce[1]);
	}
}
