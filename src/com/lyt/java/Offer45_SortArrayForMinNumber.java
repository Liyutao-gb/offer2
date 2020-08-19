package com.lyt.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
//��Ŀ��
//	����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ�������������
//��С��һ����������������{3, 32, 321}�����ӡ����3���������ųɵ���С����321323��
//˼·
//	Ч�ʲ��ߵķ������������ȫ���У������ַ��������� ����������ƴ���������������е�
//��Сֵ����Ч��̫�ͣ���û�п��ǵ��������⡣
//	�õķ������۲���ɣ����ж���һ���������
//	��������m��n������ƴ�ӳ�mn��nm�����mn<nm�����Ƕ���mС��n����֮���෴�����������
//����򣬴�С�ŵ��󼴿�ʵ����ĿҪ��
//ƴ��m��nʱ��Ҫ���ǵ��������⣬��˽�m��nƴ������������ת�����ַ���������Ϊmn��nm
//���ַ���λ����ͬ��������ǵĴ�Сֻ��Ҫ�����ַ�����С�ıȽϹ���Ϳ����ˡ�
//compareTo����()��1.�ַ����������бȽ�; 2.���ֵ�˳��Ƚ������ַ���;
public class Offer45_SortArrayForMinNumber {
	public String getMinNumber(int[] nums) {
		if (nums == null || nums.length <= 0)
			return null;

		List<String> list = new ArrayList<>();
		for (int num : nums)
			list.add(String.valueOf(num));
		
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				String a = s1 + s2; 
				String b = s2 + s1;
//				System.out.println(a + " " + b);
//				System.out.println(a.compareTo(b));
				return b.compareTo(a); // �������� b.compareTo(a);
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for (String str : list)
			sb.append(str);
		return sb.charAt(0) == '0' ? "0" : sb.toString();// ���⣺"00"
	}

	public static void main(String[] args) {
		Offer45_SortArrayForMinNumber demo = new Offer45_SortArrayForMinNumber();
		int[] arr = { 3, 30, 34, 5, 9 };
		String printMinNumber = demo.getMinNumber(arr);
		System.out.println(printMinNumber);
	}
}
