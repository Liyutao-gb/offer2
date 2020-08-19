package com.lyt.java;

import java.util.Comparator;
import java.util.PriorityQueue;

//��Ŀ��
//	��εõ�һ���������е���λ����������������ж�����������ֵ����ô��λ������������ֵ
//����֮��λ���м����ֵ��������������ж���ż������ֵ����ô��λ������������ֵ����֮��
//�м���������ƽ��ֵ��
//˼·
//	��ν�����������ǲ���һ���Զ����������ݣ�ֻ��һ��һ����ȡ��ÿһ����Ҫ���ܼ�����λ����
//����������ݷ�Ϊ�����֣�һ��������С����һ���ִ�С��һ���ֲ��ô󶥶Ѵ�ţ����
//һ���ֲ���С���Ѵ�š����ܸ���Ϊż��ʱ��ʹ�����ѵ���Ŀ��ͬ������λ��=�󶥶ѵ��������
//��С���ѵ���С���ֵ�ƽ��ֵ�����ܸ���Ϊ����ʱ��ʹС���ѵĸ����ȴ󶥶Ѷ�һ����
//��λ��=С���ѵ���С���֡�
//��ˣ�����Ĳ������£�
//1.���Ѷ�ȡ�ĸ���Ϊż��������0��ʱ�������ѵ���Ŀ�Ѿ���ͬ�����¶�ȡ�������뵽С�����У�
//�Ӷ�ʵ��С���ѵĸ�����һ�����ǣ�����¶�ȡ�����ֱȴ󶥶����������ֻ�С���Ͳ���ֱ��
//���뵽С�������� ����ʱ���뽫�����ֲ��뵽�󶥶��У������󶥶��е�������ֲ��뵽С�����У�
//�Ӷ�ʵ��С���ѵĸ�����һ��
//2���Ѷ�ȡ�ĸ���Ϊ����ʱ��С���ѵĸ�����һ������Ҫ���¶�ȡ���ֲ��뵽�󶥶��У���ʱ����
//���������ơ�
public class Offer41_StreamMedian {

	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); // С���ѣ�Ĭ������Ϊ11
	PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11, new Comparator<Integer>() { // �󶥶ѣ�����11
		public int compare(Integer i1, Integer i2) {
			return i2 - i1;
		}
	});

	public void Insert(Integer num) {
		if (((minHeap.size() + maxHeap.size()) & 1) == 0) {// ż��ʱ,�¸����ּ���С����
			if (!maxHeap.isEmpty() && maxHeap.peek() > num) {
				maxHeap.offer(num);
				num = maxHeap.poll();
			}
			minHeap.offer(num);
		} else {// ����ʱ����һ�����ַ���󶥶�
			if (!minHeap.isEmpty() && minHeap.peek() < num) {
				minHeap.offer(num);
				num = minHeap.poll();
			}
			maxHeap.offer(num);
		}
	}

	public Double GetMedian() {
		if ((minHeap.size() + maxHeap.size()) == 0)
			throw new RuntimeException();
		double median;
		if ((minHeap.size() + maxHeap.size() & 1) == 0) {
			median = (maxHeap.peek() + minHeap.peek()) / 2.0;
		} else {
			median = minHeap.peek();
		}
		return median;
	}
}
