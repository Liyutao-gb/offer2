package com.lyt.java;

import java.util.LinkedList;
import java.util.Queue;

//��Ŀ
//	����������ʵ��һ��ջ��
//˼·
//	����ͨ��һϵ��ջ��ѹ��͵�����������������������ģ��һ��ջ�Ĺ��̡�����������queue1
//��queue2���ö���ģ����ջ���Ԫ�ص�queue1�Ķ���β������,���ö���ģ���ջʱ��queue1
//β�����һ��Ԫ�ؾ���Ҫ������Ԫ��,���Ƚ�queue1��Ԫ�شӶ���β���������μ��뵽����queue2
//��,��queue1ֻʣһ��Ԫ��ʱ,����Ҫ������Ԫ�ء�
public class Offer09_StackWithTwoQueues {
	class Stack {
		Queue<Integer> queue1 = new LinkedList<Integer>();
		Queue<Integer> queue2 = new LinkedList<Integer>();

		/**
		 * ������
		 */
		public void push(int node) {
			queue1.add(node);
		}

		/**
		 * ɾ�����
		 * ֻ���ж�queue1�Ƿ�Ϊ��
		 */
		public int pop() {
			if (queue1.isEmpty() && queue2.isEmpty()) 
				throw new RuntimeException("��ǰջΪ��");
			
			if (queue1.isEmpty()) {
				while (queue2.size() > 1) {
					queue1.add(queue2.poll());
				}
				return queue2.poll();
			} else {
				while (queue1.size() > 1) {
					queue2.add(queue1.poll());
				}
				return queue1.poll();
			}
		}
	}

	public void test1() {
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		System.out.println(stack.pop());
		stack.push(3);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

	/**
	 * ����ջɾ��Ԫ��
	 */
	public void test2() {
		Stack stack = new Stack();
		System.out.println(stack.pop());
	}

	public static void main(String[] args) {
		Offer09_StackWithTwoQueues demo = new Offer09_StackWithTwoQueues();
		demo.test1();
		demo.test2();
	}
}
