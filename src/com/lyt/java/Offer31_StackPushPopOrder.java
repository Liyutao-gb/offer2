package com.lyt.java;

import java.util.Stack;
//题目：判断一个序列是否为栈的一个弹出序列
//	输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出
//顺序。假设压入栈的所有数字均不相等。例如序列1、2、3、4、5是某栈的压栈序列，序列
//4、5、3、2、1是该压栈序列对应的一个弹出序列，但4、3、5、1、2就不可能是该压栈序列的
//弹出序列。
//思路
//	建立一个栈，按照压栈序列依次进行入栈操作，按出栈序列的顺序依次弹出数字。
//在出栈时，若下一个要出栈的数字与栈顶数字相同则弹出。如果压栈序列中的所有数字都
//入栈后没有完全出栈成功则代表两个序列不匹配，返回false。
public class Offer31_StackPushPopOrder {
	public boolean isPopOrder(int[] pushA, int[] popA) {
		if (pushA == null || popA == null || pushA.length == 0 || popA.length != pushA.length)
			return false;

		Stack<Integer> stack = new Stack<Integer>();
		int popIndex = 0;
		for (int i = 0; i < pushA.length; i++) {
			stack.push(pushA[i]);
			while (!stack.empty() && stack.peek() == popA[popIndex]) {
				stack.pop();
				popIndex++;
			}
		}
		return stack.empty();
	}

	public static void main(String[] args) {
		Offer31_StackPushPopOrder order = new Offer31_StackPushPopOrder();
		int[] pushA = { 1, 2, 3, 4, 5 };
		int[] popA = { 4, 5, 3, 2, 1 };
		boolean b = order.isPopOrder(pushA, popA);
		System.out.println(b);
	}
}
