package com.lyt.java;

import java.util.Stack;
//��Ŀ
//	����һ����������������е�����k����㡣Ϊ�˷��ϴ�����˵�ϰ�ߣ������1��ʼ
//�������������β����ǵ�����1����㡣����һ��������6����㣬��ͷ��㿪ʼ���ǵ�ֵ
//������1��2��3��4��5��6���������ĵ�����3�������ֵΪ4�Ľ�㡣
//˼·
//	��һֱ�����ȴ�ͷ��ʼ�����������������n��Ȼ�����±�������n-k+1����㼴Ϊ����Ҫ��
//��㡣������Ҫ����2�Ρ����������ջ����ʵ�ָ÷������ռ临�ӶȱȽϴ����еķ�������
//:��������ָ�룬��һ��ָ���ȱ���k-1�����ӵ�k����ʼ���ڶ���ָ��ָ��ͷ��㣬�������
//ͬʱ�������������һ��ָ�뵽�����һ�����ʱ���ڶ���ָ��ָ��������ǵ�����k����㡣
public class Offer22_KthNodeFromEnd {
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	/**
	 * ����1������ջ
	 */
	public ListNode findKthToTail1(ListNode head, int k) {
		if (head == null || k <= 0)
			return null;

		Stack<ListNode> stack = new Stack<>();
		int numsOfNode = 0;
		ListNode cur = head;
		while (cur != null) {
			numsOfNode++;
			stack.push(cur);
			cur = cur.next;
		}
		if (k > numsOfNode)
			return null;
		
		for (int i = 1; i <= k; i++) {
			cur = stack.pop();
		}
		return cur;
	}

	/**
	 * ����2�������������Ϊk-1��ָ��
	 *  1.��ָ������k-1�� 
	 *  2.����ָ��һ����,ֱ����ָ���ߵ�ĩβ���Ϊֹ
	 */
	public ListNode findKthToTail2(ListNode head, int k) {
		if (head == null || k <= 0)
			return null;

		ListNode fast = head;
		for (int i = 0; i < k - 1; i++) {
			fast = fast.next;
			if (fast == null) // Key
				return null;
		}
		
		ListNode slow = head;
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}

	// =====================���Դ���=======================

	/*
	 * null
	 */
	void test1() {
		ListNode head = null;
		ListNode result = findKthToTail2(head, 1);
		if (result == null)
			System.out.println("test1 passed!");
		else
			System.out.println("test1 failed!");
	}

	/*
	 * k������Χ
	 */
	void test2() {
		ListNode head = new ListNode(2);
		ListNode result = findKthToTail2(head, 2);
		if (result == null)
			System.out.println("test2 passed!");
		else
			System.out.println("test2 failed!");
	}

	/*
	 * �������
	 */
	void test3() {
		ListNode head = new ListNode(1);
		ListNode result = findKthToTail2(head, 1);
		if (result.val == 1)
			System.out.println("test3 passed!");
		else
			System.out.println("test3 failed!");
	}

	/*
	 * β���
	 */
	void test4() {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		ListNode result = findKthToTail2(node1, 1);
		if (result.val == 4)
			System.out.println("test4 passed!");
		else
			System.out.println("test4 failed!");
	}

	/*
	 * �м���
	 */
	void test5() {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		ListNode result = findKthToTail2(node1, 2);
		if (result.val == 3)
			System.out.println("test5 passed!");
		else
			System.out.println("test5 failed!");
	}

	/*
	 * ͷ���
	 */
	void test6() {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		ListNode result = findKthToTail2(node1, 4);
		if (result.val == 1)
			System.out.println("test6 passed!");
		else
			System.out.println("test6 failed!");
	}

	public static void main(String[] args) {
		Offer22_KthNodeFromEnd demo = new Offer22_KthNodeFromEnd();
		demo.test1();
		demo.test2();
		demo.test3();
		demo.test4();
		demo.test5();
		demo.test6();
	}
}
