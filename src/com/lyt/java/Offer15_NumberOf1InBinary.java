package com.lyt.java;

//题目
//	请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。例如把9表示成二进制是1001
//有2位是1。因此如果输入9，该函数输出2。
//思路
//	遇到与二进制有关的题目，应该想到位运算(与、或、异或、左移、右移)。
//	方法一：“与运算”有一个性质：通过与对应位上为1，其余位为0的数进行与运算，可以某一整数
//指定位上的值。这道题中，先把整数n与1做与运算，判断最低位是否为1；接着把1左移一位，与n做
//与运算，可以判断次低位是否为1……反复左移，即可对每一个位置都进行判断，从而可以获得1的个
//数。这种方法需要循环判断32次。
//	方法二（better）：如果一个整数不为0，把这个整数减1，那么原来处在整数最右边的1就会变
//为0，原来在1后面的所有的0都会变成1。其余所有位将不会受到影响。再把原来的整数和减去1之
//后的结果做与运算，从原来整数最右边一个1那一位开始所有位都会变成0。因此，把一个整数减1，
//再和原来的整数做与运算，会把该整数最右边的1变成0。这种方法，整数中有几个1，就只需要循
//环判断几次。
// >> 正数高位补0,负数高位补1	;	>>> 正、负数高位都补0
//注：判断一个整数为2的整数次方。n > 0 && (n & (n - 1)) == 0
//	    判断一个整数为4的整数次方。n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) == n
public class Offer15_NumberOf1InBinary {
	public int NumberOf1_Solution1(int n) {
		int count = 0;
		int flag = 1;
		while (flag != 0) {
			if ((flag & n) != 0)
				count++;
			flag <<= 1;
		}
		return count;
	}

	public int NumberOf1_Solution2(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n = (n - 1) & n;
		}
		return count;
	}

	// =========测试代码========= 

	void test(String testName, int n, int expected) {
		if (testName != null)
			System.out.println(testName + ":");
		if (NumberOf1_Solution1(n) == expected) {
			System.out.print("    soluton1:" + "passed  ");
		} else {
			System.out.print("    solution1:" + "failed  ");
		}

		if (NumberOf1_Solution2(n) == expected) {
			System.out.println("soluton2:" + "passed  ");
		} else {
			System.out.println("solution2:" + "failed  ");
		}
	}

	void test1() {
		test("Test for 0", 0, 0);
	}

	void test2() {
		test("Test for 1", 1, 1);
	}

	void test3() {
		test("Test for 10", 10, 2);
	}

	void test4() {
		test("Test for 0x7FFFFFFF", 0x7FFFFFFF, 31);
	}

	void test5() {
		test("Test for 0xFFFFFFFF", 0xFFFFFFFF, 32);
	}

	void test6() {
		test("Test for 0x80000000", 0x80000000, 1);
	}

	public static void main(String[] args) {
		Offer15_NumberOf1InBinary demo = new Offer15_NumberOf1InBinary();
		demo.test1();
		demo.test2();
		demo.test3();
		demo.test4();
		demo.test5();
		demo.test6();
	}
}
