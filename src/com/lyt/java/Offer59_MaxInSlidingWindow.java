package com.lyt.java;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
//题目
//	给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。例如，如果输入数组
//{2, 3, 4, 2, 6, 2, 5, 1}及滑动窗口的大小3，那么一共存在6个滑动窗口，它们的最大值分别
//为{4, 4, 6, 6, 6, 5}
//思路
//	我们考虑把每个可能成为最大值的数字记录下来，就可以快速的得到最大值。
//	建立一个两端开口的队列，放置所有可能是最大值的数字（存放的其实是对应的下标），
//且最大值位于队列开头。从头开始扫描数组，
//1）如果遇到的数字比队列中所有的数字都大，那么它就是最大值，其它数字不可能是最大值了，
//将队列中的所有数字清空，放入该数字，该数字位于队列头部；
//2）如果遇到的数字比队列中的所有数字都小，那么它还有可能成为之后滑动窗口的最大值，
//放入队列的末尾；
//3）如果遇到的数字比队列中最大值小，最小值大，那么将比它小数字不可能成为最大值了，
//删除较小的数字，放入该数字。
//4）由于滑动窗口有大小，因此，队列头部的数字如果其下标离滑动窗口末尾的距离大于窗口大小，
//那么也删除队列头部的数字。
//注：队列中存放的是下标，以上讲的 队列头部的数字 均指 队列头部的下标所指向的数字。
//Deque双端队列中removeFirst,removeLast,getFirst,getLast会抛出NoSuchElementException
public class Offer59_MaxInSlidingWindow {
	/**
	 * 1.先判断size - 1个元素
	 * 2.弹出队列尾元素,但凡num[deque.getLast()] < num[i]
	 * 3.最大值超过窗口大小,弹出队列头
	 */
	public List<Integer> maxInWindows(int[] num, int size) {
		if (num == null || num.length <= 0 || size <= 0 || size > num.length)
			throw new RuntimeException("输入不合法！");

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
