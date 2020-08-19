package com.lyt.java;

import java.util.HashMap;
import java.util.Map;

//��Ŀ
//	����һ����������������һ������s���������в�����������ʹ�����ǵĺ�������s�������
//������ֵĺ͵���s���������һ�Լ��ɡ�
//˼·
//	��ͷ��ʼ�������֣�ȷ��һ�����ֺ󣬶Ժ�������ֱ������жϺ��Ƿ�Ϊs�����ַ������Ӷ�
//ΪO(n^2)��Ч��̫�͡�
//	���ǿ��ǵ������һ�����ֱȽ�С����ô��һ������һ���Ƚϴ�ͬʱ����Ϊ�������У�
//���ԣ�������������ָ�룬һ��ָ��small�ӵ�һ�����֣���С����������һ��ָ��big��
//���һ�����֣���󣩳�����
//��small��big�ĺ�С��sʱ��ֻ��Ҫ��smallָ���һ�����֣����󣩣������жϣ�
//��small��big�ĺʹ���sʱ��ֻ��Ҫ��bigָ��ǰһ�����֣���С���������жϣ�
//��small��big�ĺ͵���sʱ�������ɡ�
//�����Ǵ��������м��ƶ������Բ����������������ʱ�临�Ӷ�ΪO(n)��
public class Offer57_TwoNumbersWithSum {
	/**
	 * ����֮�ͣ��������飬������
	 */
	public int[] findNumbersWithSum(int[] nums, int target) {
		if (nums == null || nums.length <= 0)
			throw new RuntimeException("���鲻�Ϸ�");
		
		int low = 0;
		int high = nums.length - 1;
		while (low < high) {
			if (nums[low] + nums[high] == target) {
				return new int[] {nums[low], nums[high]};
			} else if (nums[low] + nums[high] < target)
				low++;
			else
				high--;
		}
		return new int[]{};
	}

	/**
	 * ����֮�ͣ��������飬���±�
	 */
	public int[] twoSum(int[] nums, int target) {
		if (nums == null || nums.length <= 0)
			throw new RuntimeException("���鲻�Ϸ�");

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int num = target - nums[i];
			if (map.containsKey(num)) {
				return new int[] { map.get(num), i };
			}
			map.put(nums[i], i);
		}

		return new int[]{};
	}
}
