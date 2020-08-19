package com.lyt.java;

//��Ŀ
//	��ʵ��һ����������һ���ַ����е�ÿ���ո��滻�ɡ�%20�������磬���ַ���ΪWe Are Happy.
//�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
//˼·
//	����Ҫѯ�����Թ����½�һ���ַ���������ԭ�е��ַ������޸ģ�����Ҫ����ԭ���ַ����Ͻ�
//���޸ġ�����ǰ���������滻����ÿ�������ո��ַ�ʱ������Ҫ�ƶ�����O(n)���ַ������ں���
//O(n)���ո��ַ����ַ������ԣ��ܵ�ʱ��Ч��ΪO(n2)��
//	ת��˼·���ȼ������Ҫ���ܳ��ȣ�Ȼ��Ӻ���ǰ���и��ƺ��滻����ÿ���ַ�ֻ��
//Ҫ����һ�μ��ɡ�ʱ��Ч��ΪO(n)��
public class Offer05_ReplaceSpaces {
	public String replaceSpace(String str) {
		if (str == null || str.length() <= 0)
			return null;
		
		char[] c1 = str.toCharArray();
		int len = str.length();
		for (int i = 0; i < str.length(); i++) {
			if (c1[i] == ' ')
				len += 2;
		}
		
		char[] c2 = new char[len];
		int index2 = c2.length - 1;
		for (int i = c1.length - 1; i >= 0; i--) {
			if (c1[i] != ' ') {
				c2[index2--] = c1[i];
			} else {
				c2[index2--] = '0';
				c2[index2--] = '2';
				c2[index2--] = '%';
			}
		}
		
		return String.valueOf(c2);
	}

	/**
	 * ����Ϊnull
	 */
	public void test1() {
		System.out.print("Test1��");
		String sBuffer = null;
		String s = replaceSpace(sBuffer);
		System.out.println(s);
	}

	/**
	 * ����Ϊ���ַ���
	 */
	public void test2() {
		System.out.print("Test2��");
		String sBuffer = "";
		String s = replaceSpace(sBuffer);
		System.out.println(s);
	}

	/**
	 * �����ַ����޿ո�
	 */
	public void test3() {
		System.out.print("Test3��");
		String sBuffer = "abc";
		String s = replaceSpace(sBuffer);
		System.out.println(s);
	}

	/**
	 * �����ַ���Ϊ��β�ո��м������ո�
	 */
	public void test4() {
		System.out.print("Test4��");
		String sBuffer = " a b  c  ";
		String s = replaceSpace(sBuffer);
		System.out.println(s);
	}

	public static void main(String[] args) {
		Offer05_ReplaceSpaces rs = new Offer05_ReplaceSpaces();
		rs.test1();
		rs.test2();
		rs.test3();
		rs.test4();
	}
}
