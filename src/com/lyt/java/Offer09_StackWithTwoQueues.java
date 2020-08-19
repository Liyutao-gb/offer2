package com.lyt.java;

import java.util.LinkedList;
import java.util.Queue;

//题目
//	用两个队列实现一个栈。
//思路
//	我们通过一系列栈的压入和弹出操作来分析用两个队列模拟一个栈的过程。有两个队列queue1
//和queue2，用队列模拟入栈添加元素到queue1的队列尾部即可,当用队列模拟出栈时，queue1
//尾部最后一个元素就是要弹出的元素,首先将queue1的元素从队列尾部弹出依次加入到队列queue2
//中,当queue1只剩一个元素时,就是要弹出的元素。
public class Offer09_StackWithTwoQueues {
	class Stack {
		Queue<Integer> queue1 = new LinkedList<Integer>();
		Queue<Integer> queue2 = new LinkedList<Integer>();

		/**
		 * 插入结点
		 */
		public void push(int node) {
			queue1.add(node);
		}

		/**
		 * 删除结点
		 * 只能判断queue1是否为空
		 */
		public int pop() {
			if (queue1.isEmpty() && queue2.isEmpty()) 
				throw new RuntimeException("当前栈为空");
			
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
	 * 往空栈删除元素
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
