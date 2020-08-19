package com.lyt.java;

import java.util.Stack;
//��Ŀ
//	�������������ҳ����ǵĵ�һ��������㡣
//˼·
//	��������������һ������Ľ�㣬ÿ��һ����㣬���ڵڶ��������ϱ���ÿ����㣬�ж��Ƿ����
//ʱ�临�Ӷ�ΪO(m*n)��Ч�ʵͣ�
//	ʹ��ջ�����ڹ�����������β��������������ջ�ֱ�������������еĽ�㣬��β��㿪ʼ��
//ջ�Ƚϡ�ʱ�临�Ӷ�O(m+n)���ռ临�Ӷ�O(m+n)��
//	���ó��ȹ�ϵ��������������ĳ���֮��������������Ĳ�����֮�󳤶�����ͬʱ��������
//���ĵ�һ����ͬ�Ľ����ǵ�һ��������㡣
//	��������ָ�룺һ��ָ��˳�����list1��list2����һ��ָ��˳�����list2��list1��������
//��ָ���ܹ���֤����ͬʱ�ߵ�β��㣩������ָ���ҵ��ĵ�һ����ͬ�����ǵ�һ��������㡣
public class Offer52_FirstCommonNodesInLists {
	public class ListNode {
		int val;
		ListNode next ;

		ListNode(int val) {
			this.val = val;
		}
	}

	/**
	 * ����1�����ó��ȹ�ϵ
	 */
	public ListNode findFirstCommonNode1(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;

		int len1 = getLength(headA);
		int len2 = getLength(headB);
		int Diff = len1 - len2;
		ListNode fast = headA;
		ListNode slow = headB;
		if (Diff < 0) {
			fast = headB;
			slow = headA;
			Diff = -Diff;
		}
		
		for (int i = 0; i < Diff; i++)
			fast = fast.next;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
	}

	private int getLength(ListNode head) {
		int len = 0;
		while (head != null) {
			len++;
			head = head.next;
		}
		return len;
	}

	/**
	 * ����2��
	 * 		p1�ȱ���list1�����list2��p2�ȱ���list2�����list1������һ��������
	 */
	public ListNode findFirstCommonNode2(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;

		ListNode p1 = headA;
		ListNode p2 = headB;
		while (p1 != p2) {
			p1 = p1 == null ? headB : p1.next;
			p2 = p2 == null ? headA : p2.next;
		}
		return p1;
	}

	/**
	 * ����3������ջ
	 */
	public ListNode findFirstCommonNode3(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;

		ListNode p1 = headA;
		ListNode p2 = headB;
		Stack<ListNode> stack1 = new Stack<>();
		Stack<ListNode> stack2 = new Stack<>();
		while (p1 != null) {
			stack1.push(p1);
			p1 = p1.next;
		}
		while (p2 != null) {
			stack2.push(p2);
			p2 = p2.next;
		}

		ListNode common = null;
		while (!stack1.empty() && !stack2.empty()) {
			ListNode node1 = stack1.pop();
			ListNode node2 = stack2.pop();
			if (node1 == node2)
				common = node1;
			else
				break;
		}
		return common;
	}
}
