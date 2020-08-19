package com.lyt.java;

//��Ŀ1���ҳ��������ظ������֡�
//	��һ������Ϊn����������������ֶ���(0��n-1)�ķ�Χ�ڡ�������ĳЩ�������ظ��ģ�����
//֪���м����������ظ��ġ�Ҳ��֪��ÿ�������ظ����Ρ����ҳ�����������һ���ظ������֡� 
//���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ������ǵ�һ���ظ�������2��
//˼·
//	�ӹ�ϣ���˼·��չ���������飺��ɨ���ÿ�����֣�������m���ŵ����Ӧ�±�(m�±�)��
//λ���ϣ���ͬһλ�����ظ�����˵���������ظ���
//	ʱ�临�Ӷ�O(n) �ռ临�Ӷ�O(1)
public class Offer03_FindDuplication1 {
	/**
	 * 1.�Ƚ����� �Ƿ�� �±�i���
	 * 2.(1)���ֺ��±�number[i]�����ֱȽ�
	 * 	 (2)����Ⱦͽ���number[i]���±�number[i]������
	 */
	public int getDuplicate(int[] nums) {
		if (nums == null || nums.length <= 0) {
			System.out.println("����������Ч��");
			return -1;
		}

		// �ж������Ƿ�Ϸ���ÿ��������0 ~ n-1 ֮�䣩
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0 || nums[i] > nums.length - 1) {
				System.out.println("���ִ�С������Χ��");
				return -1;
			}
		}

		// key step
		for (int i = 0; i < nums.length; i++) {
			while (nums[i] != i) {	
				if (nums[i] == nums[nums[i]]) {
					return nums[i];
				}
				int temp = nums[nums[i]];
				nums[nums[i]] = nums[i];
				nums[i] = temp;
			}
		}
		System.out.println("���������ظ����֣�");
		return -1;
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
	 * �������ظ�����
	 */
	public void test2() {
		System.out.print("test2��");
		int[] a = { 0, 1, 2, 3 };
		int dup = getDuplicate(a);
		if (dup >= 0)
			System.out.println("�ظ�����Ϊ��" + dup);
	}

	/**
	 * ��������Խ��
	 */
	public void test3() {
		System.out.print("test3��");
		int[] a = { 1, 2, 3, 4 };
		int dup = getDuplicate(a);
		if (dup >= 0)
			System.out.println("�ظ�����Ϊ��" + dup);
	}

	/**
	 * ������ظ�����
	 */
	public void test4() {
		System.out.print("test4��");
		int[] a = { 1, 2, 3, 2, 4 }; // 2,1,3,2,4   3,1,2,2,4   2,1,2,3,4  
		int dup = getDuplicate(a);
		if (dup >= 0)
			System.out.println("�ظ�����Ϊ��" + dup);
	}

	public static void main(String[] args) {
		Offer03_FindDuplication1 f = new Offer03_FindDuplication1();
		f.test1();
		f.test2();
		f.test3();
		f.test4();
	}
}