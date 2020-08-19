package com.lyt.java;

//题目
//	请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.
//则经过替换之后的字符串为We%20Are%20Happy。
//思路
//	首先要询问面试官是新建一个字符串还是在原有的字符串上修改，本题要求在原有字符串上进
//行修改。若从前往后依次替换，在每次遇到空格字符时，都需要移动后面O(n)个字符，对于含有
//O(n)个空格字符的字符串而言，总的时间效率为O(n2)。
//	转变思路：先计算出需要的总长度，然后从后往前进行复制和替换，则每个字符只需
//要复制一次即可。时间效率为O(n)。
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
	 * 输入为null
	 */
	public void test1() {
		System.out.print("Test1：");
		String sBuffer = null;
		String s = replaceSpace(sBuffer);
		System.out.println(s);
	}

	/**
	 * 输入为空字符串
	 */
	public void test2() {
		System.out.print("Test2：");
		String sBuffer = "";
		String s = replaceSpace(sBuffer);
		System.out.println(s);
	}

	/**
	 * 输入字符串无空格
	 */
	public void test3() {
		System.out.print("Test3：");
		String sBuffer = "abc";
		String s = replaceSpace(sBuffer);
		System.out.println(s);
	}

	/**
	 * 输入字符串为首尾空格，中间连续空格
	 */
	public void test4() {
		System.out.print("Test4：");
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
