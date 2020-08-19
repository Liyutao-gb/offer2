package com.lyt.java;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
//��Ŀ
//	����һ������ͻ������ڵĴ�С�����ҳ����л�������������ֵ�����磬�����������
//{2, 3, 4, 2, 6, 2, 5, 1}���������ڵĴ�С3����ôһ������6���������ڣ����ǵ����ֵ�ֱ�
//Ϊ{4, 4, 6, 6, 6, 5}
//˼·
//	���ǿ��ǰ�ÿ�����ܳ�Ϊ���ֵ�����ּ�¼�������Ϳ��Կ��ٵĵõ����ֵ��
//	����һ�����˿��ڵĶ��У��������п��������ֵ�����֣���ŵ���ʵ�Ƕ�Ӧ���±꣩��
//�����ֵλ�ڶ��п�ͷ����ͷ��ʼɨ�����飬
//1��������������ֱȶ��������е����ֶ�����ô���������ֵ���������ֲ����������ֵ�ˣ�
//�������е�����������գ���������֣�������λ�ڶ���ͷ����
//2��������������ֱȶ����е��������ֶ�С����ô�����п��ܳ�Ϊ֮�󻬶����ڵ����ֵ��
//������е�ĩβ��
//3��������������ֱȶ��������ֵС����Сֵ����ô������С���ֲ����ܳ�Ϊ���ֵ�ˣ�
//ɾ����С�����֣���������֡�
//4�����ڻ��������д�С����ˣ�����ͷ��������������±��뻬������ĩβ�ľ�����ڴ��ڴ�С��
//��ôҲɾ������ͷ�������֡�
//ע�������д�ŵ����±꣬���Ͻ��� ����ͷ�������� ��ָ ����ͷ�����±���ָ������֡�
//Deque˫�˶�����removeFirst,removeLast,getFirst,getLast���׳�NoSuchElementException
public class Offer59_MaxInSlidingWindow {
	/**
	 * 1.���ж�size - 1��Ԫ��
	 * 2.��������βԪ��,����num[deque.getLast()] < num[i]
	 * 3.���ֵ�������ڴ�С,��������ͷ
	 */
	public List<Integer> maxInWindows(int[] num, int size) {
		if (num == null || num.length <= 0 || size <= 0 || size > num.length)
			throw new RuntimeException("���벻�Ϸ���");

		List<Integer> max = new ArrayList<>();
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 0; i < size - 1; i++) {
			while (!deque.isEmpty() && num[i] > num[deque.getLast()]) {
				deque.removeLast();
			}
			deque.addLast(i);
		}

		for (int i = size - 1; i < num.length; i++) {
			while (!deque.isEmpty() && num[i] > num[deque.getLast()])
				deque.removeLast();
			if (!deque.isEmpty() && (i - deque.getFirst()) >= size)
				deque.removeFirst();
			deque.addLast(i);
			max.add(num[deque.getFirst()]);
		}

		return max;
	}

	public static void main(String[] args) {
		Offer59_MaxInSlidingWindow demo = new Offer59_MaxInSlidingWindow();
		int[] arr = new int[] { 2, 3, 4, 2, 6, 2, 5, 1 };
		List<Integer> maxInWindows = demo.maxInWindows(arr, 3);
		System.out.println(maxInWindows);
	}
}
