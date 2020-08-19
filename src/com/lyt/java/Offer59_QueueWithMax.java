package com.lyt.java;

import java.util.ArrayDeque;
import java.util.Deque;
//题目
//	请定义一个队列并实现函数max得到队列里的最大值，要求函数max、push_back和pop_front的
//时间复杂度都是O(1)。
//思路
//	与滑动窗口的最大值一题相似,利用双端队列来存储当前队列里的最大值以及之后可能的最大值
//	在定义题目要求功能的队列时，除了定义一个队列data存储数值，还需额外用一个队列maxmium
//存储可能的最大值；此外，还要定义一个数据结构，用于存放数据以及当前的index值，用于删除
//操作时确定是否删除maxmium中最大值。
public class Offer59_QueueWithMax {
	private Deque<InternalData> data = new ArrayDeque<>();
	private Deque<InternalData> maximum = new ArrayDeque<>();

	private class InternalData {
		int number;
		int index;

		public InternalData(int number, int index) {
			this.number = number;
			this.index = index;
		}
	}

	private int curIndex;

	public void push_back(int number) {
		InternalData curData = new InternalData(number, curIndex);
		data.addLast(curData);

		while (!maximum.isEmpty() && maximum.getLast().number < number)
			maximum.removeLast();
		maximum.addLast(curData);

		curIndex++; // 别漏了这句
	}

	public void pop_front() {
		if (data.isEmpty()) {
			System.out.println("队列为空，无法删除！");
			return;
		}
		InternalData curData = data.removeFirst();
		if (curData.index == maximum.getFirst().index)
			maximum.removeFirst();
	}

	public int max() {
		if (maximum == null) {
			System.out.println("队列为空，无法删除！");
			return 0;
		}
		return maximum.getFirst().number;
	}

	public static void main(String[] args) {
		Offer59_QueueWithMax testQueue = new Offer59_QueueWithMax();
		// {2}
		testQueue.push_back(2);
		System.out.println(testQueue.max() == 2);
		// {2, 3}
		testQueue.push_back(3);
		System.out.println(testQueue.max() == 3);
		// {2, 3, 4}
		testQueue.push_back(4);
		System.out.println(testQueue.max() == 4);
		// {2, 3, 4, 2}
		testQueue.push_back(2);
		System.out.println(testQueue.max() == 4);
		// {3, 4, 2}
		testQueue.pop_front();
		System.out.println(testQueue.max() == 4);
		// {4, 2}
		testQueue.pop_front();
		System.out.println(testQueue.max() == 4);
		// {2}
		testQueue.pop_front();
		System.out.println(testQueue.max() == 2);
		// {2, 6}
		testQueue.push_back(6);
		System.out.println(testQueue.max() == 6);
		// {2, 6, 2}
		testQueue.push_back(2);
		System.out.println(testQueue.max() == 6);
		// {2, 6, 2, 5}
		testQueue.push_back(5);
		System.out.println(testQueue.max() == 6);
		// {6, 2, 5}
		testQueue.pop_front();
		System.out.println(testQueue.max() == 6);
		// {2, 5}
		testQueue.pop_front();
		System.out.println(testQueue.max() == 5);
		// {5}
		testQueue.pop_front();
		System.out.println(testQueue.max() == 5);
		// {5, 1}
		testQueue.push_back(1);
		System.out.println(testQueue.max() == 5);
	}
}
