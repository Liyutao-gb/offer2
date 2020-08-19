package com.lyt.java;

import java.util.Stack;

//��Ŀ
//	������ջʵ��һ�����С����е��������£���ʵ��������������appendTail��deleteHead��
//�ֱ�����ڶ���β����������ڶ���ͷ��ɾ�����Ĺ��ܡ�
//˼·
//	�����ϼ򵥣��Լ�������ģ��һ�²���ɾ���Ĺ��̣��ڲݸ�ֽ�϶��ֻ�һ�£�������϶�
//����һ��ջstack1��һֱ���룻ɾ��ʱ��ֱ�ӳ�ջ�޷�ʵ�ֶ��е��Ƚ��ȳ�������ʱ��Ҫ
//��Ԫ�ش�stack1��ջ��ѹ����һ��ջstack2�У�Ȼ���ٴ�stack2�г�ջ��OK�ˡ���Ҫ��΢
//ע����ǣ���stack2�л���Ԫ�أ�stack1�е�Ԫ�ز���ѹ��������stack2��ûԪ��ʱ��
//stack1�е�����Ԫ�ض�����ѹ��stack2�С�����˳��ͻᱻ���ҡ�
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
	 * ���ն���ɾ��Ԫ��
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
