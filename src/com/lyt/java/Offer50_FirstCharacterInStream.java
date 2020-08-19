package com.lyt.java;

//题目　
//	请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前
//两个字符"go"时，第一个只出现一次的字符是'g'。当从该字符流中读出前六个字符"google"时，
//第一个只出现一次的字符是'l'。
//思路
//	字符只能一个一个从字符流中读出来，因此要定义一个容器来保存字符以及其在字符流中的位置。
//为尽可能高效解决问题，要在O(1)时间内往数据容器中插入字符，及其对应的位置，因此这个数据
//容器可以用哈希表来实现，以字符的ASCII码作为哈希表的键值key，字符对应的位置作为哈希表的
//值value。
//	开始时，哈希表的值都初始化为-1，当读取到某个字符时，将位置存入value中，如果之前读取过
//该字符（即value>=0），将value赋值为-2，代表重复出现过。最后对哈希表遍历，在value>=0的
//键值对中找到最小的value，该value即为第一个只出现一次的字符，ASCII码为key的字符即为所求
//字符。
public class Offer50_FirstCharacterInStream {
	private int index;
	private int[] occurence;

	public Offer50_FirstCharacterInStream() { // 在构造函数中初始化成员变量
		index = 0;
		occurence = new int[256];
		for (int i = 0; i < 256; i++) {
			occurence[i] = -1;
		}
	}

	public void insert(char ch) {
		if (occurence[(int) ch] == -1) {
			occurence[(int) ch] = index; // 第一次出现
		} else if (occurence[(int) ch] >= 0) {
			occurence[(int) ch] = -2; // 已经出现过了
		}
		index++;
	}

	public char getFirst() {
		int minIndex = Integer.MAX_VALUE; // 最大的integer
		char ch = '#';
		for (int i = 0; i < 256; i++) {
			if (occurence[i] >= 0 && occurence[i] < minIndex) {
				ch = (char) i;
				minIndex = occurence[i];
			}
		}
		return ch;
	}
}
