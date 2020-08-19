package com.lyt.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//��Ŀ��
//	����һ���ַ�������ӡ�����ַ������ַ����������С����������ַ���abc�����ӡ����
//�ַ�a��b��c�������г����������ַ���abc��acb��bac��bca��cab��cba�������Ĵ������
//ArrayList<String>���շ��ص��ַ�������Ҫ�󲻳����ظ��ַ�����
//˼·
//��1�����ַ������������֣�һ�����ǵ�һ���ַ�����һ�����Ǻ���������ַ���
//��2������ȷ����һ���ַ������ַ��������ַ����е�����һ�����̶���һ���ַ����������
//�����ַ������У���ͬ���裬���õݹ飩��
//��3��ʵ�ֵ�һ���ַ��ĸı䣬ֻ��Ҫ����һ���ַ��ͺ��������ַ����н������ɡ�Ҫ�ǵ�
//�ַ��������Ҫ���ַ��������������ԭʼ���ַ�����
public class Offer38_StringPermutation {
	public List<String> Permutation(String str) {
		if (str == null || str.length() == 0)
			return null;
		
		List<String> list = new ArrayList<>();
		permutationCore(str.toCharArray(), 0, list);
		Collections.sort(list); // ��list�е��ַ�������
		return list;
	}

	private void permutationCore(char[] strArray, int index, List<String> list) {
		if (index == strArray.length - 1) {
			if (!list.contains(String.valueOf(strArray))) // �ж��Ƿ����ظ��ַ���
				list.add(String.valueOf(strArray));
		} else {
			for (int i = index; i < strArray.length; i++) {
				char temp = strArray[index];
				strArray[index] = strArray[i];
				strArray[i] = temp;
				permutationCore(strArray, index + 1, list);
				strArray[i] = strArray[index];
				strArray[index] = temp;
			}
		}
	}

	public static void main(String[] args) {
		Offer38_StringPermutation demo = new Offer38_StringPermutation();
		List<String> list = demo.Permutation("abc");
		for (String s : list) {
			System.out.print(s + " ");
		}
	}
}
