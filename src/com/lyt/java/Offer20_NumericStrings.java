package com.lyt.java;

//��Ŀ
//	��ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С���������磬�ַ�����+100����
//��5e2������-123������3.1416������-1E-16������ʾ��ֵ������12e������1a3.14������1.2.3������+-5��
//����12e+5.4�������ǡ�
//˼·
//	�տ�ʼ��˼·�Ǵ�ͷ��β�������������Ĳ�ͬ������з������������׳���
//��˲��á���ָOFFER��һ��ķ����������ֵ���ʽ�ܽ�Ϊ��(A.B E/e A) ,
//��˳������жϣ�A���������������B������������������
public class Offer20_NumericStrings {
	public boolean isNumeric(char[] str) {
		if (str == null || str.length == 0)
			return false;
		int[] index = new int[1];
		index[0] = 0; // ���ڼ�¼��ǰ�ַ�λ��
		// ���ж�A
		boolean isNumeric; // ���ڼ�¼�Ƿ���������
		isNumeric = isInteger(str, index);
		// �ж�B
		if (index[0] < str.length && (str[index[0]] == '.')) {
			index[0]++;
			isNumeric = isUnsignedInteger(str, index) || isNumeric; // .B��A.��A.B��ʽ������
		}
		// �ж�e�����A
		if (index[0] < str.length && (str[index[0]] == 'e' || str[index[0]] == 'E')) {
			index[0]++;
			isNumeric = isInteger(str, index) && isNumeric;
		}
		if (isNumeric && index[0] == str.length)
			return true;
		else
			return false;
	}

	private boolean isInteger(char[] str, int[] index) { // ��int[]���ܴ�ֵ��int�Ļ���Ҫ����indexΪȫ�ֱ���
		if (index[0] < str.length && (str[index[0]] == '+' || str[index[0]] == '-'))
			index[0]++;
		return isUnsignedInteger(str, index);
	}

	private boolean isUnsignedInteger(char[] str, int[] index) {
		int start = index[0];
		while (index[0] < str.length && (str[index[0]] - '0' <= 9 && str[index[0]] - '0' >= 0))
			index[0]++;
		if (index[0] > start)
			return true;
		else
			return false;
	}

	// =======���Դ���=========
	void test(String testName, char[] str, boolean expected) {
		System.out.print(testName + "��");
		if (isNumeric(str) == expected)
			System.out.println(" passed!");
		else
			System.out.println(" failed!");
	}

	void test1() {
		char[] str = null;
		test("test1", str, false);
	}

	void test2() {
		char[] str = {};
		test("test2", str, false);
	}

	void test3() {
		String string = "e3";
		char[] str = string.toCharArray();
		test("test3", str, false);
	}

	void test4() {
		String string = "3e1.2";
		char[] str = string.toCharArray();
		test("test4", str, false);
	}

	void test5() {
		String string = "e3";
		char[] str = string.toCharArray();
		test("test5", str, false);
	}

	void test6() {
		String string = "1.2e3";
		char[] str = string.toCharArray();
		test("test6", str, true);
	}

	void test7() {
		String string = "-.2e3";
		char[] str = string.toCharArray();
		test("test7", str, true);
	}

	void test8() {
		String string = "-.2e-3";
		char[] str = string.toCharArray();
		test("test8", str, true);
	}

	void test9() {
		String string = "1.e-3";
		char[] str = string.toCharArray();
		test("test9", str, true);
	}

	void test10() {
		String string = "1.";
		char[] str = string.toCharArray();
		test("test10", str, true);
	}

	void test11() {
		String string = ".2";
		char[] str = string.toCharArray();
		test("test11", str, true);
	}

	void test12() {
		String string = "12e3";
		char[] str = string.toCharArray();
		test("test12", str, true);
	}

	public static void main(String[] args) {
		Offer20_NumericStrings demo = new Offer20_NumericStrings();
		demo.test1();
		demo.test2();
		demo.test3();
		demo.test4();
		demo.test5();
		demo.test6();
		demo.test7();
		demo.test8();
		demo.test9();
		demo.test10();
		demo.test11();
		demo.test12();
	}
}
