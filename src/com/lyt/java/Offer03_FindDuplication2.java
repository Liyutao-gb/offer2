package com.lyt.java;

//��Ŀ2�����޸������ҳ��ظ������֡�
//	��һ������Ϊn+1����������������ֶ���1��n�ķ�Χ�ڣ�����������������һ������
//���ظ��ġ����ҳ�����������һ���ظ������֣��������޸���������顣���磬���
//���볤��Ϊ8������{2, 3, 5, 4, 3, 2, 6, 7}����ô��Ӧ��������ظ�������2����3��
//˼·1
//	����һ������Ϊn+1�ĸ�������,Ȼ����һ��ԭ�����ÿ�����ָ��Ƶ��������顣���
//ԭ�����б����Ƶ���m,��������Ƶ������������±�Ϊm��λ�á�
//˼·2
//	���鳤��Ϊn+1��������ֻ��1��n��˵���ض����ظ����֡������ɶ��ֲ��ҷ���չ��
//��1~n�����ִ��м�����m�ֳ������֣���ǰһ��1~m��������Ŀ����m����˵���ظ�
//������ǰһ�����䣬�����ں������m+1~n��ÿ���������ж�һ��Ϊ����ֱ���ҵ��ظ����֡�
public class Offer03_FindDuplication2 {
	/**
	 * ����һ�����ı�ԭ����
	 *    ʱ�临�Ӷ�O(n)		�ռ临�Ӷ�O(n)
	 */
	public int getD(int[] nums) {
		if (nums == null || nums.length <= 0) 	// ����������Ч��
			return -1;

		for (int a : nums) {
			if (a < 1 || a > nums.length - 1) 	// ���ִ�С������Χ��
				return -1;
		}

		int[] helper = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (helper[nums[i]] != 0) 
				return nums[i];
			helper[nums[i]] = nums[i];
		}
		return -1;
	}

	/**
	 * �����������ı�ԭ����
	 *    ʱ�临�Ӷ�O(nlogn)		�ռ临�Ӷ�O(1)
	 */
	public int getDuplicate(int[] nums) {
		if (nums == null || nums.length <= 0) 	// ����������Ч��
			return -1;
		
		for (int a : nums) {
			if (a < 1 || a > nums.length - 1)	// ���ִ�С������Χ��
				return -1;
		}
		
		int low = 1;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = (high + low) >> 1;
			int count = countRange(nums, low, mid);
			if (low == high) {
				if (count > 1)
					return low;
			}
			if (count > mid - low + 1) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	/**
	 * ������[low,high]��Χ�����ֵĸ���
	 */
	public int countRange(int[] arr, int low, int high) {
		if (arr == null)
			return 0;
		int count = 0;
		for (int a : arr) {
			if (a >= low && a <= high)
				count++;
		}
		return count;
	}

	/**
	 * ����Ϊnull
	 */
	public void test1() {
		System.out.print("test1��");
		int[] a = null;
		int dup = getDuplicate(a);
		if (dup >= 0)
			System.out.println("�ظ�����Ϊ��" + dup);
	}

	/**
	 * ��������Խ��
	 */
	public void test2() {
		System.out.print("test2��");
		int[] a = { 1, 2, 3, 4 };
		int dup = getDuplicate(a);
		if (dup >= 0)
			System.out.println("�ظ�����Ϊ��" + dup);
	}

	/**
	 * ������ظ�����
	 */
	public void test3() {
		System.out.print("test3��");
		int[] a = {2, 3, 5, 4, 3, 2, 6, 7};
		int dup = getDuplicate(a);
		if (dup >= 0)
			System.out.println("�ظ�����Ϊ��" + dup);
	}

	public static void main(String[] args) {
		Offer03_FindDuplication2 f2 = new Offer03_FindDuplication2();
		f2.test1();
		f2.test2();
		f2.test3();
	}
}