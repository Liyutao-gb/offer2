package com.lyt.java;

//��Ŀ��
//	��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡���������һ������Ϊ9��
//����{1, 2, 3, 2, 2, 2, 5, 4, 2}����������2�������г�����5�Σ��������鳤�ȵ�һ�룬
//������2��
//˼·�����ִ�������һ�룬��˵���������ֳ��ֵĴ�������������֮�ͻ���
//	������������б�������ֵ��һ����������ĳһ���֣���һ���Ǵ�������������һ������ʱ��
//���뱣��������ͬ���������1����֮��1��������=0���򱣴���һ�����֣�������������Ϊ1��
//����Ҫ�ҵ����ֳ��ֵĴ�������������֮�ͻ��࣬��ôҪ�ҵ����ֿ϶������һ�ΰѴ�������
//Ϊ1�����֡�
public class Offer39_MoreThanHalfNumbers {
	/**
	 * ����һ��
	 * 		1.���count��������0,���õ�ǰ������Ϊnum
	 * 		2.��ǰ���ֺ���һ������һ��,count++
	 *      �жϴ����Ƿ񳬹�һ��
	 */
	public int MoreThanHalfNum_Solution2(int[] arr) {
		if (arr == null || arr.length <= 0)
			throw new RuntimeException("���鲻�Ϸ�");

		int num = arr[0];
		int count = 1;
		for (int i = 1; i < arr.length; i++) {
			if (count == 0) {
				num = arr[i];
				count = 1;
			} else if (arr[i] == num) {
				count++;
			} else {
				count--;
			}
		}

		if (count > 0) {
			int times = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == num)
					times++;
			}
			if (times * 2 > arr.length) {
				return num;
			}
		}
		throw new RuntimeException("�����ڳ������鳤��һ�������");
	}

	public static void main(String[] args) {
		Offer39_MoreThanHalfNumbers demo = new Offer39_MoreThanHalfNumbers();
		int i = demo.MoreThanHalfNum_Solution2(new int[] { 2, 4, 3, 3, 3, 3, 5 });
		System.out.println(i);
	}

	// ��������partition����
	public int MoreThanHalfNum_Solution(int[] array) {
		if (array == null || array.length <= 0)
			return 0;
		int low = 0;
		int high = array.length - 1;
		int index = partition(array, low, high);
		while (index != array.length >> 1) {
			if (index < array.length >> 1) {
				low = index + 1;
				index = partition(array, low, high);
			} else {
				high = index - 1;
				index = partition(array, low, high);
			}
		}
		// �жϴ����Ƿ񳬹�һ��
		int num = array[index];
		int times = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == num) {
				times++;
			}
		}
		if (times * 2 > array.length) {
			return num;
		}
		return 0;
	}

	private int partition(int[] array, int low, int high) {
		int pivotKey = array[low];
		while (low < high) {
			while (low < high && array[high] >= pivotKey)
				high--;
			int temp = array[low];
			array[low] = array[high];
			array[high] = temp;
			while (low < high && array[low] <= pivotKey)
				low++;
			temp = array[low];
			array[low] = array[high];
			array[high] = temp;
		}
		return low;
	}

}
