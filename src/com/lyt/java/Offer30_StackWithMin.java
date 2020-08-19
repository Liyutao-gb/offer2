package com.lyt.java;

import java.util.Stack;

//题目　
//	定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。在该栈中，
//调用min、push及pop的时间复杂度都是O(1)。
//思路
//	最初想法是定义一个成员变量min来存放最小元素，但是当最小元素弹出后，min就需要
//相应改变，所以必须把每次的最小值都存储下来。考虑采用一个辅助栈来存放最小值：
//　　栈: 3，4，2，5，1
//辅助栈: 3，3，2，2，1
public class Offer30_StackWithMin {
	Stack<Integer> stack_data = new Stack<Integer>();
	Stack<Integer> stack_min = new Stack<Integer>();

	/**
	 * 同步栈
	 */
	public void push(int x) {
		stack_data.push(x);
		if (stack_min.empty() ||  x <= stack_min.peek()) {
			stack_min.push(x);
		} else {
			stack_min.push(stack_min.peek());
		}
	}

	public void pop() {
		if (stack_data.empty()) {
			throw new RuntimeException("栈空");
		}
		stack_data.pop();
		stack_min.pop();
	}

	public int min() {
		if(stack_min.empty()) {
			throw new RuntimeException("栈空");
		}
		return stack_min.peek();
	}
	
	/**
	 * 非同步栈
	 */
	public void push1(int x) {
		stack_data.push(x);
		if (stack_min.isEmpty() || x <= getMin()) {
			stack_min.push(x);
		}
	}

	public void pop1() {
		if (stack_data.isEmpty()) {
			throw new RuntimeException("Your stack is empty.");
		}
		int val = stack_data.pop();
		if (val == getMin())
			stack_min.pop();
	}

	public int getMin() {
		if (stack_min.isEmpty()) {
			throw new RuntimeException("Your stack is empty.");
		}
		return stack_min.peek();
	}
}
