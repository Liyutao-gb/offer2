package com.lyt.java;

//题目
//	写一个函数，求两个整数之和，要求在函数体内不得使用＋、－、×、÷四则运算符号。
//思路
//　对数字做运算，除了四则运算外，只剩下位运算了。根据一般情况下的加法步骤，设计如下：
//	1）不考虑进位对每一位相加：1加0，0加1都等于1，而0加0，1加1等于0，所以使用异或^操作；
//	2）计算进位：只有1加1产生进位，所以采用位与&操作，再左移1位；
//	3）将和与进位相加，即重复前两步操作。结束判断为进位为0。
//二进制位运算的几个用法，下面举的例子中，a=1010 1010
//按位与&
//（1）清零：a&0=0
//（2）取指定位上的数字，如取得数字a的最后四位：a&0000 1111 = 0000 1010
//按位或|
//（1）置1，如将a的后四位置为1：a|0000 1111 = 1010 1111
//异或^
//（1）取反，如将a的后四位取反：a^0000 1111 = 1010 0101
//（2）与0异或保留原值，如：a^0000 0000 =1010 1010
//（3）交换两个的变量值：A=A^B; B=A^B; A=A^B; 可以完成A和B的交换。
//	      加减法交换两个的变量值：A=A+B; B=A-B; A=A-B;
public class Offer65_AddTwoNumbers {
	public int add(int num1, int num2) {
		while (num2 != 0) {
			int sum = num1 ^ num2; // 没进位的和
			int carry = (num1 & num2) << 1; // 进位
			num1 = sum;
			num2 = carry;
		}
		return num1;
	}

	public int add2(int num1, int num2) {
		if (num2 == 0)
			return num1;
		return add2(num1 ^ num2, (num1 & num2) << 1);
	}

	public static void main(String[] args) {
		Offer65_AddTwoNumbers demo = new Offer65_AddTwoNumbers();
		int add = demo.add(5, 9);
		int add2 = demo.add2(5, 9);
		System.out.println(add == add2);
	}
}
