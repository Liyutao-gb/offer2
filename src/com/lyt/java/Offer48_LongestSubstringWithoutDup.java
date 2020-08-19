package com.lyt.java;

//��Ŀ
//	����ַ������ҳ�һ����Ĳ������ظ��ַ������ַ��������������ַ����ĳ��ȡ�
//�����ַ�����ֻ������'a'��'z'���ַ���
//˼·
//	��̬�滮�������庯��f(i)Ϊ���Ե�i���ַ�Ϊ��β�Ĳ����ظ��ַ������ַ�������󳤶ȡ�
//��1������i���ַ�֮ǰδ���ֹ������У�f(i)=f(i-1)+1
//��2������i���ַ�֮ǰ���ֹ����Ǹ��ַ����ϴγ��ֵ�λ�þ���Ϊd
//����1�����d<=f(i-1)������f(i)=d��
//����2�����d>f(i-1)������f(i)=f(i-1)+1��
//���Ǵӵ�һ���ַ���ʼ��������������int����preLength��curLength���ֱ����f(i-1)��f(i)��
//�ٴ���һ������Ϊ26��pos���������26����ĸ�ϴγ��ֵ�λ�ã����ɸ�������˵��������⡣
//ע�⣺ÿ����󳤶Ⱥ���ĸ����λ��Ҫ�ǵø��¡�
public class Offer48_LongestSubstringWithoutDup {
	/**
	 * �ⷨһ���ַ���ֻ����'a'~'z'���ַ�(���Ž�)��arabcacfr
	 */
	public static int lengthOfLongestSubstring1(String str) {
		if (str == null || str.length() <= 0)
			return 0;
		int preLength = 0; // ��f(i-1)
		int curLength = 0; // ��f(i)
		int maxLength = 0;
		int[] pos = new int[26]; // ���ڴ����ĸ�ϴγ��ֵ�λ��
		for (int i = 0; i < pos.length; i++)
			pos[i] = -1;
		for (int i = 0; i < str.length(); i++) {
			int index = str.charAt(i) - 'a';
			// ��һ�������d����f(i - 1)��ʱ��i���ַ��ϴγ�����f(i - 1)��Ӧ���
			// ���ַ���֮ǰ�����f(i) = f(i - 1) + 1�� d > preLength
			if (pos[index] < 0 || i - pos[index] > preLength) {
				curLength = preLength + 1;
			} else {
				// �ڶ��������dС�ڻ��ߵ���f(i - 1)����ʱ��i���ַ��ϴγ�����f(i - 1)
				// ��Ӧ������ַ���֮�У�f(i) = d�� d <= preLength
				curLength = i - pos[index];
			}
			pos[index] = i;
			if (curLength > maxLength)
				maxLength = curLength;
			preLength = curLength;
		}
		return maxLength;
	}

	/**
	 * �ⷨ��������һ���ַ������ҳ����в������ظ��ַ��� ��Ӵ� �ĳ��ȡ� (���԰��� ��'a'~'z'֮��� �����ַ�)
	 */
	public static int lengthOfLongestSubstring2(String s) {
		if (s == null)
			return 0;
		boolean[] letter = new boolean[128];
		int maxLength = 0;
		int start = 0, end = 0;
		while (end < s.length()) {
			if (!letter[s.charAt(end)]) {
				letter[s.charAt(end)] = true;
				end++;
				maxLength = Math.max(maxLength, end - start);
			} else {
				letter[s.charAt(start)] = false;
				start++;
			}
		}
		return maxLength;
	}

	/**
	 * �ⷨ�����ѵ�ǰ�ַ��������ַ�����ĩβ��㣬��¼��ǰ����ظ��Ӵ�
	 */
	public static int lengthOfLongestSubstring3(String s) {
		if (s == null || s.length() <= 0)
			return 0;
		int[] index = new int[128];
		int preIndex = 0;
		int maxLength = 0;
		for (int curIndex = 0; curIndex < s.length(); curIndex++) {
			preIndex = Math.max(index[s.charAt(curIndex)], preIndex);
			maxLength = Math.max(maxLength, curIndex - preIndex + 1);
			index[s.charAt(curIndex)] = curIndex + 1;
		}
		return maxLength;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring3("arabcacfr") == 4);
		System.out.println(lengthOfLongestSubstring3("abcabcbb") == 3);
		System.out.println(lengthOfLongestSubstring3("aaa") == 1);
		System.out.println(lengthOfLongestSubstring3("abcdef") == 6);
		System.out.println(lengthOfLongestSubstring3("") == 0);
		System.out.println(lengthOfLongestSubstring3(null) == 0);
	}
}
