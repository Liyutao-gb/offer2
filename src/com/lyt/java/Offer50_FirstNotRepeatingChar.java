package com.lyt.java;

//��Ŀ��
//	���ַ������ҳ���һ��ֻ����һ�ε��ַ���������"abaccdeff"�������'b'��
//˼·
//	������ϣ����ֵkeyΪ�ַ���ֵvalueΪ���ִ�������һ��ɨ�裺��ÿ��ɨ�赽���ַ��Ĵ�����һ
//�ڶ���ɨ�裺��ÿ��ɨ�赽���ַ�ͨ����ϣ���ѯ��������һ������Ϊ1���ַ���Ϊ����Ҫ��������
//�����ַ���char���ǳ���Ϊ8���������ͣ�����256�п��ܣ���˹�ϣ�������һ������Ϊ256��
//���������棬������±��൱�ڼ�ֵkey����Ӧ�ַ���ASCII��ֵ�������ֵ�൱�ڹ�ϣ���ֵvalue
//���ڴ�Ŷ�Ӧ�ַ����ֵĴ�����
//	��չ���������ַ���,�ӵ�һ���ַ�����ɾ���ڵڶ����ַ����г��ֹ��������ַ���
//˼·
//	����һ��������ʵ�ֵļ򵥹�ϣ�����洢�ڶ����ַ���������������O(1)��ʱ���жϸ��ַ�
//�ǲ����ڵڶ����ַ����С�ʱ�临�Ӷ�O(n)��
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
		return 0;	// '\0'��ASCiiΪ0
	}

	public static void main(String[] args) {
		Offer50_FirstNotRepeatingChar demo = new Offer50_FirstNotRepeatingChar();
		System.out.println((demo.firstNotRepeatingChar("google") == 'l'));
		System.out.println((demo.firstNotRepeatingChar("aabccdbd") == '\0'));
		System.out.println((demo.firstNotRepeatingChar("$abcdefg") == '$'));
		System.out.println((demo.firstNotRepeatingChar(null) == 0));
	}
}
