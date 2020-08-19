package com.lyt.java;

//题目
//	输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号
//和普通字母一样处理。例如输入字符串"I am a student."，则输出"student. a am I"。
//思路
//	首先实现翻转整个句子：只需要在首尾两端各放置一个指针，交换指针所指的数字，两端指针
//往中间移动即可。之后根据空格的位置，对每个单词使用同样的方法翻转即可。
public class Offer58_ReverseWordsInSentence {
	public String reverseSentence(char[] chars) {
		if (chars == null || chars.length <= 0)
			throw new RuntimeException("数组不合法");
		
		// 1.翻转整个句子
		reverseSb(chars, 0, chars.length - 1);
		// 2.翻转单词（指针指向单词的第一个和最后一个）
		int start = 0;
		int end = 0;
		while (start < chars.length) {
			while (end < chars.length && chars[end] != ' ') {
				end++;
			}
			reverseSb(chars, start, end - 1);
			start = ++end;
		}
		return String.valueOf(chars);
	}

	public void reverseSb(char[] chars, int start, int end) {
		while (start < end) {
			char temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		Offer58_ReverseWordsInSentence demo = new Offer58_ReverseWordsInSentence();
		char[] cLetter = new char[] { 'I', ' ', 'a', 'm', ' ', 'a', ' ', 's', 't', 'u', 'd', 'e', 'n', 't', '.' };
		String sentence = demo.reverseSentence(cLetter);
		System.out.println(sentence);
	}
}
