package com.lyt.java;

//题目
//	求1+2+…+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件
//判断语句（A?B:C）。
//思路
//	不能使用乘除法，不能使用循环语句、判断语句。可以考虑的有   单目运算符：++和--,
//双目运算符：+,-，移位运算符<<和>>，关系运算符>,<等，逻辑运算符&&，||,&,|,^，赋值= 
//最有可能使用到的就是逻辑运算符了。如果记得它们有短路特性的话，就可以当作if来使用。
//	例如：对于A && B，如果A为假，那么就不执行B了；而如果A为真，就会执行B。
//　对于A || B，如果A为真，那么就会不执行B了；而如果A为假，就会执行B。
//因此我们使用递归来代替循环，用逻辑运算符&&或者||来代替判断语句。
//代码实现功能为：当n大于1时，和为f(n)=f(n-1)+n，n=1时，f(n)=1
public class Offer64_Accumulate {
	public int getSum(int n) {
		boolean flag = (n > 1) && ((n += getSum(n - 1)) > 0);
		// boolean flag = (n == 1) || ((n += getSum(n - 1)) > 0);

		// 上面这句话相当于下面：（利用递归来代替循环)
		// if (n > 1)
		// 		n += getSum(n - 1);
		return n;
	}

	public static void main(String[] args) {
		Offer64_Accumulate demo = new Offer64_Accumulate();
		int sum = demo.getSum(5);
		System.out.println(sum);
	}
}
