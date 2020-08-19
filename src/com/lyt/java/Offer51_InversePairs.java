package com.lyt.java;

//��Ŀ��
//	�������е������������ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�
//����һ�����飬�����������е�����Ե�������
//˼·
//	����������飬��ÿ�����ֶ��ͺ�������ֱȽϴ�С��ʱ�临�Ӷ�ΪO(n^2)��Ч��̫�͡�
//���ù鲢�����˼�룬�Ƚ�����ֽ��Ϊn������Ϊ1�������飬Ȼ����������ϲ�ͬʱ�ź�˳��
//�ڶ�����������ϲ�����ʱ������������±�Ϊstart~mid����ָ��Ϊi���ұ������±�Ϊ
//mid+1~end����ָ��Ϊj������ָ�붼ָ����������������֣�����ʱ��
//��1�����iָ������ִ���jָ������֣�˵�����������j-mid�������ǰ�iָ������ַ�����ʱ
//���������������У�Ȼ����i-1��ָ�������ǰһ�����֣�������������
//��2�����iָ�������С�ڵ���jָ������֣�˵����ʱ����������ԣ���jָ������ַ�����ʱ
//���������������У�Ȼ����j-1��ָ�������ǰһ�����֣�������������
//��3��ĳһ���������ֶ�������������󣬽���һ��������ʣ�µ����ַ������������У��������
//��4���������õ����ְ�˳��ֵ��ԭʼ����������������Ա�ϲ����������������ϲ�
public class Offer51_InversePairs {
	public int inversePairs(int[] arr) {
		if (arr == null || arr.length <= 0)
			return 0;
		int count = getCount(arr, 0, arr.length - 1);
		return count;
	}

	private int getCount(int[] arr, int start, int end) {
		if (start >= end)
			return 0;
		
		int mid = (end + start) >> 1;
		int left = getCount(arr, start, mid);
		int right = getCount(arr, mid + 1, end);
		int count = merge(arr, start, mid, end);
		
		return count + left + right;
	}
	

	public int merge(int[] arr, int start, int mid, int end) {
		int[] temp = new int[end - start + 1];
		
		int i = mid;
		int j = end;
		int k = temp.length - 1;
		int count = 0;
		
		while (i >= start && j >= mid + 1) {
			if (arr[i] > arr[j]) {
				count += (j - mid);
				temp[k--] = arr[i--];
			} else {
				temp[k--] = arr[j--];
			}
		}
		while (i >= start)
			temp[k--] = arr[i--];
		while (j >= mid + 1)
			temp[k--] = arr[j--];
		for (k = 0; k < temp.length; k++)
			arr[start++] = temp[k];
		
		return count;
	}
	
	public static void main(String[] args) {
		Offer51_InversePairs demo = new Offer51_InversePairs();
		int[] arr = {7, 5, 6, 4};
		int pairs = demo.inversePairs(arr);
		System.out.println(pairs);
	}
}
