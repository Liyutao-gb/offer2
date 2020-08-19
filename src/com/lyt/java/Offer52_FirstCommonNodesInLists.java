package com.lyt.java;

import java.util.Stack;
//题目
//	输入两个链表，找出它们的第一个公共结点。
//思路
//	蛮力法：遍历第一个链表的结点，每到一个结点，就在第二个链表上遍历每个结点，判断是否相等
//时间复杂度为O(m*n)，效率低；
//	使用栈：由于公共结点出现在尾部，所以用两个栈分别放入两个链表中的结点，从尾结点开始出
//栈比较。时间复杂度O(m+n)，空间复杂度O(m+n)。
//	利用长度关系：计算两个链表的长度之差，长链表先走相差的步数，之后长短链表同时遍历，找
//到的第一个相同的结点就是第一个公共结点。
//	利用两个指针：一个指针顺序遍历list1和list2，另一个指针顺序遍历list2和list1，（这样
//两指针能够保证最终同时走到尾结点），两个指针找到的第一个相同结点就是第一个公共结点。
public class Offer52_FirstCommonNodesInLists {
	public class ListNode {
		int val;
		ListNode next ;

		ListNode(int val) {
			this.val = val;
		}
	}

	/**
	 * 方法1：利用长度关系
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
	 * 方法2：
	 * 		p1先遍历list1后遍历list2；p2先遍历list2后遍历list1；最终一定会相遇
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
	 * 方法3：利用栈
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
