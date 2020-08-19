package com.lyt.java;

//��Ŀ
//	����дһ������StrToInt��ʵ�ְ��ַ���ת��������������ܡ���Ȼ������ʹ��atoi��������
//���ƵĿ⺯����
//˼·
//	��Ŀ�ܼ򵥣���Ҫ����ʵ�ֶ�ÿ���ַ�ת��Ϊ���֣��������ۼӼ��ɡ������кܶ����������
//��Ҫ���ǽ�ȥ������null�����ַ��������������š��ַ��������֡�����ȵȡ�
//	���ڷǷ����������룬����ֵΪ0����Ҫ��һ��ȫ�ֱ������б�ǡ�
//	д����ʱһ��Ҫ����������ֲ���������
public class Offer67_StringToInt {
	static boolean isValid = false;

	public static int strToInt(String str) {
		if (str == null || str.length() <= 0)
			return 0;
		char[] chars = str.toCharArray();
		long num = 0; // ����long���洢���Է�ֹԽ��
		boolean minus = false;
		for (int i = 0; i < chars.length; i++) {
			if (i == 0 && chars[i] == '-') {
				minus = true;
			} else if (i == 0 && chars[i] == '+') {
				minus = false;
			} else {
				int a = (int) (chars[i] - '0');
				if (a < 0 || a > 9) {
					isValid = false;
					return 0;
				}
				num = (minus == false) ? num * 10 + a : num * 10 - a;
				isValid = true; // �������������Ϊ�˷�ֹstr=��+����������ж�Ϊtrue
				if ((!minus && num > 0x7FFFFFFF) || (minus && num < 0x80000000)) {
					isValid = false;
					return 0;
				}
			}
		}
		return (int) num;
	}

	// �򵥲�����
	public static void main(String[] args) {
		System.out.println(strToInt("1948243") == 1948243);
		System.out.println(isValid == true);
		System.out.println(strToInt("+1948243") == 1948243);
		System.out.println(isValid == true);
		System.out.println(strToInt("-1948243") == -1948243);
		System.out.println(isValid == true);
		System.out.println(strToInt("-0") == 0);
		System.out.println(isValid == true);
		System.out.println(strToInt("-194+8243") == 0);
		System.out.println(isValid == false);
		System.out.println(strToInt("") == 0);
		System.out.println(isValid == false);
		System.out.println(strToInt(null) == 0);
		System.out.println(isValid == false);
		System.out.println(strToInt("999999999999999") == 0);
		System.out.println(isValid == false);
		System.out.println(strToInt("+") == 0);
		System.out.println(isValid == false);

		System.out.println(strToInt("2147483647") == 2147483647); // 0x7FFFFFFF
		System.out.println(isValid == true);
		System.out.println(strToInt("2147483648") == 0);
		System.out.println(isValid == false);

		System.out.println(strToInt("-2147483648") == -2147483648); // 0x80000000
		System.out.println(isValid == true);
		System.out.println(strToInt("-2147483649") == 0);
		System.out.println(isValid == false);
	}
}
