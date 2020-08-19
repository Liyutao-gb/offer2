package com.lyt.java;

import java.util.Stack;

//题目
//	用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail和deleteHead，
//分别完成在队列尾部插入结点和在队列头部删除结点的功能。
//思路
//	这道题较简单，自己先试着模拟一下插入删除的过程（在草稿纸上动手画一下）：插入肯定
//是往一个栈stack1中一直插入；删除时，直接出栈无法实现队列的先进先出规则，这时需要
//将元素从stack1出栈，压到另一个栈stack2中，然后再从stack2中出栈就OK了。需要稍微
//注意的是：当stack2中还有元素，stack1中的元素不能压进来；当stack2中没元素时，
//stack1中的所有元素都必须压入stack2中。否则顺序就会被打乱。
public class Offer09_QueueWithTwoStacks {
	class Queue {
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();

		public void add(int node) {
			stack1.push(node);
		}

		public int poll() {
			if (stack1.empty() && stack2.empty()) {
				throw new RuntimeException("Queue is empty.");
			}
			if (stack2.empty()) {
				while (!stack1.empty()) {
					stack2.push(stack1.pop());
				}
			}
			return stack2.pop();
		}

		public int peek() {
			if (stack1.isEmpty() && stack2.isEmpty()) {
				throw new RuntimeException("Queue is empty.");
			}
			if (stack2.isEmpty()) {
				while (!stack1.isEmpty()) {
					stack2.push(stack1.pop());
				}
			}
			return stack2.peek();
		}
	}

	public void test1() {
		Queue queue = new Queue();
		queue.add(1);
		queue.add(2);
		System.out.println(queue.poll());
		queue.add(3);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
	}

	/**
	 * 往空队列删除元素
	 */
	public void test2() {
		Queue queue = new Queue();
		System.out.println(queue.poll());
	}

	public static void main(String[] args) {
		Offer09_QueueWithTwoStacks demo = new Offer09_QueueWithTwoStacks();
		demo.test1();
		demo.test2();
	}
}
