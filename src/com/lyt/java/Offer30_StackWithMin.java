package com.lyt.java;

import java.util.Stack;

//��Ŀ��
//	����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ����СԪ�ص�min�������ڸ�ջ�У�
//����min��push��pop��ʱ�临�Ӷȶ���O(1)��
//˼·
//	����뷨�Ƕ���һ����Ա����min�������СԪ�أ����ǵ���СԪ�ص�����min����Ҫ
//��Ӧ�ı䣬���Ա����ÿ�ε���Сֵ���洢���������ǲ���һ������ջ�������Сֵ��
//����ջ: 3��4��2��5��1
//����ջ: 3��3��2��2��1
public class Offer30_StackWithMin {
	Stack<Integer> stack_data = new Stack<Integer>();
	Stack<Integer> stack_min = new Stack<Integer>();

	/**
	 * ͬ��ջ
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
			throw new RuntimeException("ջ��");
		}
		stack_data.pop();
		stack_min.pop();
	}

	public int min() {
		if(stack_min.empty()) {
			throw new RuntimeException("ջ��");
		}
		return stack_min.peek();
	}
	
	/**
	 * ��ͬ��ջ
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
