package com.lyt.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
//题目　
//	输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中
//最小的一个。例如输入数组{3, 32, 321}，则打印出这3个数字能排成的最小数字321323。
//思路
//	效率不高的方法：求出所有全排列（类似字符串的排列 ），将数字拼起来，最后求出所有的
//最小值。这效率太低，且没有考虑到大数问题。
//	好的方法：观察规律，自行定义一种排序规则。
//	对于数字m和n，可以拼接成mn和nm，如果mn<nm，我们定义m小于n。反之则相反。利用这个排
//序规则，从小排到大即可实现题目要求。
//拼接m和n时，要考虑到大数问题，因此将m和n拼接起来的数字转换成字符串处理。因为mn和nm
//的字符串位数相同，因此它们的大小只需要按照字符串大小的比较规则就可以了。
//compareTo方法()：1.字符串与对象进行比较; 2.按字典顺序比较两个字符串;
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
				return b.compareTo(a); // 组成最大数 b.compareTo(a);
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for (String str : list)
			sb.append(str);
		return sb.charAt(0) == '0' ? "0" : sb.toString();// 特殊："00"
	}

	public static void main(String[] args) {
		Offer45_SortArrayForMinNumber demo = new Offer45_SortArrayForMinNumber();
		int[] arr = { 3, 30, 34, 5, 9 };
		String printMinNumber = demo.getMinNumber(arr);
		System.out.println(printMinNumber);
	}
}
