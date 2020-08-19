package com.lyt.java;

//题目
//	请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
//假设字符串中只包含从'a'到'z'的字符。
//思路
//	动态规划法：定义函数f(i)为：以第i个字符为结尾的不含重复字符的子字符串的最大长度。
//（1）当第i个字符之前未出现过，则有：f(i)=f(i-1)+1
//（2）当第i个字符之前出现过，记该字符与上次出现的位置距离为d
//　　1）如果d<=f(i-1)，则有f(i)=d；
//　　2）如果d>f(i-1)，则有f(i)=f(i-1)+1；
//我们从第一个字符开始遍历，定义两个int变量preLength和curLength来分别代表f(i-1)和f(i)，
//再创建一个长度为26的pos数组来存放26个字母上次出现的位置，即可根据上述说明进行求解。
//注意：每次最大长度和字母出现位置要记得更新。
public class Offer48_LongestSubstringWithoutDup {
	/**
	 * 解法一：字符串只包含'a'~'z'的字符(最优解)。arabcacfr
	 */
	public static int lengthOfLongestSubstring1(String str) {
		if (str == null || str.length() <= 0)
			return 0;
		int preLength = 0; // 即f(i-1)
		int curLength = 0; // 即f(i)
		int maxLength = 0;
		int[] pos = new int[26]; // 用于存放字母上次出现的位置
		for (int i = 0; i < pos.length; i++)
			pos[i] = -1;
		for (int i = 0; i < str.length(); i++) {
			int index = str.charAt(i) - 'a';
			// 第一种情况是d大于f(i - 1)此时第i个字符上次出现在f(i - 1)对应的最长
			// 子字符串之前，因此f(i) = f(i - 1) + 1。 d > preLength
			if (pos[index] < 0 || i - pos[index] > preLength) {
				curLength = preLength + 1;
			} else {
				// 第二种情况是d小于或者等于f(i - 1)，此时第i个字符上次出现在f(i - 1)
				// 对应的最长子字符串之中，f(i) = d。 d <= preLength
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
	 * 解法二：给定一个字符串，找出其中不含有重复字符的 最长子串 的长度。 (可以包含 除'a'~'z'之外的 其他字符)
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
	 * 解法三：把当前字符看成子字符串的末尾结点，记录当前最长不重复子串
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
