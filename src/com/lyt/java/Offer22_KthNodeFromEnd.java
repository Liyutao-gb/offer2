package com.lyt.java;

import java.util.Stack;
//题目
//	输入一个链表，输出该链表中倒数第k个结点。为了符合大多数人的习惯，本题从1开始
//计数，即链表的尾结点是倒数第1个结点。例如一个链表有6个结点，从头结点开始它们的值
//依次是1、2、3、4、5、6。这个链表的倒数第3个结点是值为4的结点。
//思路
//	第一直觉是先从头开始遍历，计算链表个数n，然后重新遍历，第n-k+1个结点即为所需要的
//结点。但是需要遍历2次。后面采用了栈进行实现该方法，空间复杂度比较大。书中的方法则是
//:设置两个指针，第一个指针先遍历k-1步；从第k步开始，第二个指针指向头结点，两个结点
//同时往后遍历，当第一个指针到达最后一个结点时，第二个指针指向的正好是倒数第k个结点。
public class Offer22_KthNodeFromEnd {
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	/**
	 * 方法1：利用栈
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
	 * 方法2：利用两个相距为k-1的指针
	 *  1.快指针先走k-1步 
	 *  2.两个指针一起走,直到快指针走到末尾结点为止
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

	// =====================测试代码=======================

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
	 * k超出范围
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
	 * 单个结点
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
	 * 尾结点
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
	 * 中间结点
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
	 * 头结点
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
