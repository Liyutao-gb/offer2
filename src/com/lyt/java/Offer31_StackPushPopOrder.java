package com.lyt.java;

import java.util.Stack;
//��Ŀ���ж�һ�������Ƿ�Ϊջ��һ����������
//	���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���
//˳�򡣼���ѹ��ջ���������־�����ȡ���������1��2��3��4��5��ĳջ��ѹջ���У�����
//4��5��3��2��1�Ǹ�ѹջ���ж�Ӧ��һ���������У���4��3��5��1��2�Ͳ������Ǹ�ѹջ���е�
//�������С�
//˼·
//	����һ��ջ������ѹջ�������ν�����ջ����������ջ���е�˳�����ε������֡�
//�ڳ�ջʱ������һ��Ҫ��ջ��������ջ��������ͬ�򵯳������ѹջ�����е��������ֶ�
//��ջ��û����ȫ��ջ�ɹ�������������в�ƥ�䣬����false��
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
