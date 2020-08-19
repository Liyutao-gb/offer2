package com.lyt.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//题目　
//	输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc，则打印出由
//字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。（本文代码采用
//ArrayList<String>接收返回的字符串，并要求不出现重复字符串）
//思路
//（1）将字符串看成两部分，一部分是第一个字符，另一部分是后面的所有字符。
//（2）首先确定第一个字符，该字符可以是字符串中的任意一个；固定第一个字符后，求出后面
//所有字符的排列（相同步骤，采用递归）。
//（3）实现第一个字符的改变，只需要将第一个字符和后面所有字符进行交换即可。要记得
//字符串输出后要将字符交换回来，变回原始的字符串。
public class Offer38_StringPermutation {
	public List<String> Permutation(String str) {
		if (str == null || str.length() == 0)
			return null;
		
		List<String> list = new ArrayList<>();
		permutationCore(str.toCharArray(), 0, list);
		Collections.sort(list); // 将list中的字符串排序
		return list;
	}

	private void permutationCore(char[] strArray, int index, List<String> list) {
		if (index == strArray.length - 1) {
			if (!list.contains(String.valueOf(strArray))) // 判断是否有重复字符串
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
