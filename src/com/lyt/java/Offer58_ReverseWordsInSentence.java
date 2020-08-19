package com.lyt.java;

//��Ŀ
//	����һ��Ӣ�ľ��ӣ���ת�����е��ʵ�˳�򣬵��������ַ���˳�򲻱䡣Ϊ�������������
//����ͨ��ĸһ���������������ַ���"I am a student."�������"student. a am I"��
//˼·
//	����ʵ�ַ�ת�������ӣ�ֻ��Ҫ����β���˸�����һ��ָ�룬����ָ����ָ�����֣�����ָ��
//���м��ƶ����ɡ�֮����ݿո��λ�ã���ÿ������ʹ��ͬ���ķ�����ת���ɡ�
public class Offer58_ReverseWordsInSentence {
	public String reverseSentence(char[] chars) {
		if (chars == null || chars.length <= 0)
			throw new RuntimeException("���鲻�Ϸ�");
		
		// 1.��ת��������
		reverseSb(chars, 0, chars.length - 1);
		// 2.��ת���ʣ�ָ��ָ�򵥴ʵĵ�һ�������һ����
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
