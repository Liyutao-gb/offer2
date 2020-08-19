package com.lyt.java;

//��Ŀ
//	�ַ���������ת�����ǰ��ַ���ǰ������ɸ��ַ�ת�Ƶ��ַ�����β�����붨��һ������ʵ��
//�ַ�������ת�����Ĺ��ܡ����������ַ���"abcdefg"������2���ú�������������ת2λ�õ���
//���"cdefgab"��
//˼·
//	����˼·����һ���ⷭת����˳���ԭ��һģһ����ֻ����һ�����пո������û�ո�
//�ȷֱ�תǰ�벿���ַ����ͺ�벿���ַ��������ת�����ַ������ɡ�
public class Offer58_LeftRotateString {
	public String leftRotateString(char[] chars, int n) {
		if (chars == null || chars.length <= 0 || n <= 0 || n > chars.length)
			throw new RuntimeException("���벻�Ϸ�");
		
		// n %= chars.length; // ��n����Ҫ��ʱ,n�Գ���ȡ��
		// 1.��תǰ�벿���ַ���
		reverse(chars, 0, n - 1);
		// 2.��ת��벿���ַ���
		reverse(chars, n, chars.length - 1);
		// 3.��ת�����ַ���
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
