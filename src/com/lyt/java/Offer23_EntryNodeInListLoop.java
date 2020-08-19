package com.lyt.java;

//题目　
//	一个链表中包含环，如何找出环的入口结点？
//思路
//	1.确定链表是否有环：通过两个不同速度的指针确定，当两个指针指向同一个结点时，该结点
//为环中的一个结点。
//	2.确定环中结点的数目n：指针走一圈，边走边计数
//	3.找到环的入口：从头结点开始，通过两个相差为n的指针来得到(即寻找链表中倒数第n个结点)
public class Offer23_EntryNodeInListLoop {
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
	
	// 判断是否有环
	public boolean hasCycle(ListNode head) {
		if (head == null)
			return false;
		ListNode p1 = head;
		ListNode p2 = head;
		while (p2.next != null && p2.next.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;
			if (p1 == p2) {
				return true;
			}
		}
		return false;
	}
	
	// 环入口结点
	public ListNode detectCycle(ListNode head) {
		if (head == null)
			return null;
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}
		if (fast.next == null || fast.next.next == null) // 无环
			return null;

		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

	/**
	 * 剑指Offer解法：
	 *     确定链表是否有环，采用快慢指针确定 返回值代表快慢指针相遇时的结点，
	 * 返回null代表链表无环
	 */
	private ListNode meetingNode(ListNode head) {
		if (head == null)
			return null;
		ListNode pSlow = head;
		ListNode pFast = head;
		while (pFast != null) {
			pSlow = pSlow.next;
			pFast = pFast.next;
			if (pFast != null)
				pFast = pFast.next;
			if (pSlow != null && pSlow == pFast)
				return pSlow;
		}
		return null;
	}

	/**
	 * 计算环中入口结点
	 */
	public ListNode entryNodeOfLoop(ListNode head) {
		ListNode meetingNode = meetingNode(head);
		if (meetingNode == null)
			return null;

		// 计算环中结点的数目
		int count = 1; // 环中结点的数目
		ListNode pNode1 = meetingNode.next;
		while (pNode1 != meetingNode) {
			count++;
			pNode1 = pNode1.next;
		}

		// 先移动pNode1，次数为count
		pNode1 = head;
		for (int i = 1; i <= count; i++) {
			pNode1 = pNode1.next;
		}
		ListNode pNode2 = head;
		while (pNode1 != pNode2) {
			pNode1 = pNode1.next;
			pNode2 = pNode2.next;
		}
		return pNode1;
	}
}
