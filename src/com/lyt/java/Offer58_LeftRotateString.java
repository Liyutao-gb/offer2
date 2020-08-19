package com.lyt.java;

//题目
//	字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现
//字符串左旋转操作的功能。比如输入字符串"abcdefg"和数字2，该函数将返回左旋转2位得到的
//结果"cdefgab"。
//思路
//	本题思路和上一道题翻转单词顺序的原理一模一样，只是上一道题有空格，这道题没空格，
//先分别翻转前半部分字符串和后半部分字符串，最后翻转整个字符串即可。
public class Offer58_LeftRotateString {
	public String leftRotateString(char[] chars, int n) {
		if (chars == null || chars.length <= 0 || n <= 0 || n > chars.length)
			throw new RuntimeException("输入不合法");
		
		// n %= chars.length; // 当n不做要求时,n对长度取余
		// 1.翻转前半部分字符串
		reverse(chars, 0, n - 1);
		// 2.翻转后半部分字符串
		reverse(chars, n, chars.length - 1);
		// 3.翻转整个字符串
		reverse(chars, 0, chars.length - 1);
		return String.valueOf(chars);
	}

	private void reverse(char[] chars, int start, int end) {
		while (start < end) {
			char temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		Offer58_LeftRotateString demo = new Offer58_LeftRotateString();
		char[] cLetter = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g' };
		demo.leftRotateString(cLetter, 2);
		System.out.println(String.valueOf(cLetter));
	}
}
