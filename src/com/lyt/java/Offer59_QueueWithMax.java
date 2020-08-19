package com.lyt.java;

import java.util.ArrayDeque;
import java.util.Deque;
//��Ŀ
//	�붨��һ�����в�ʵ�ֺ���max�õ�����������ֵ��Ҫ����max��push_back��pop_front��
//ʱ�临�Ӷȶ���O(1)��
//˼·
//	�뻬�����ڵ����ֵһ������,����˫�˶������洢��ǰ����������ֵ�Լ�֮����ܵ����ֵ
//	�ڶ�����ĿҪ���ܵĶ���ʱ�����˶���һ������data�洢��ֵ�����������һ������maxmium
//�洢���ܵ����ֵ�����⣬��Ҫ����һ�����ݽṹ�����ڴ�������Լ���ǰ��indexֵ������ɾ��
//����ʱȷ���Ƿ�ɾ��maxmium�����ֵ��
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

		curIndex++; // ��©�����
	}

	public void pop_front() {
		if (data.isEmpty()) {
			System.out.println("����Ϊ�գ��޷�ɾ����");
			return;
		}
		InternalData curData = data.removeFirst();
		if (curData.index == maximum.getFirst().index)
			maximum.removeFirst();
	}

	public int max() {
		if (maximum == null) {
			System.out.println("����Ϊ�գ��޷�ɾ����");
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
