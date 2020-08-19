package com.lyt.java;

//题目　
//	在字符串中找出第一个只出现一次的字符。如输入"abaccdeff"，则输出'b'。
//思路
//	创建哈希表，键值key为字符，值value为出现次数。第一遍扫描：对每个扫描到的字符的次数加一
//第二遍扫描：对每个扫描到的字符通过哈希表查询次数，第一个次数为1的字符即为符合要求的输出。
//由于字符（char）是长度为8的数据类型，共有256中可能，因此哈希表可以用一个长度为256的
//数组来代替，数组的下标相当于键值key，对应字符的ASCII码值；数组的值相当于哈希表的值value
//用于存放对应字符出现的次数。
//	扩展：有两个字符串,从第一个字符串中删除在第二个字符串中出现过的所有字符。
//思路
//	创建一个用数组实现的简单哈希表来存储第二个字符串。这样可以用O(1)的时间判断该字符
//是不是在第二个字符串中。时间复杂度O(n)。
public class Offer50_FirstNotRepeatingChar {
	public char firstNotRepeatingChar(String str) {
		if (str == null)
			return 0; 
		
		int[] repeat = new int[256];
		for (int i = 0; i < str.length(); i++) {
			repeat[str.charAt(i)]++;
		}
		for (int i = 0; i < str.length(); i++) {
			if (repeat[str.charAt(i)] == 1)
				return str.charAt(i);
		}
		return 0;	// '\0'的ASCii为0
	}

	public static void main(String[] args) {
		Offer50_FirstNotRepeatingChar demo = new Offer50_FirstNotRepeatingChar();
		System.out.println((demo.firstNotRepeatingChar("google") == 'l'));
		System.out.println((demo.firstNotRepeatingChar("aabccdbd") == '\0'));
		System.out.println((demo.firstNotRepeatingChar("$abcdefg") == '$'));
		System.out.println((demo.firstNotRepeatingChar(null) == 0));
	}
}
