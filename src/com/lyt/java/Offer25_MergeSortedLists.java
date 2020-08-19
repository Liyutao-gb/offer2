package com.lyt.java;

//题目　
//	输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的。
//思路
//	递归实现：合并过程中，每次都是从两个链表中找出较小的一个来链接，因此可以采用递归来
//实现：当任意一个链表为null时，直接链接另一个链表即可；其余情况只需要在两个链表中找出较小
//的一个结点进行链接，该结点的next值继续通过递归函数来链接。
//	非递归实现：非递归实现比较容易想到，直接进行分情况讨论即可，要稍微注意下后面代码中头
//结点的赋值过程。
public class Offer25_MergeSortedLists {
	public class ListNode {
		int val;
		ListNode next = null;

		public ListNode(int val) {
			this.val = val;
		}
	}

	/**
	 * 递归
	 */
	public ListNode merge(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		if (l1.val < l2.val) {
			l1.next = merge(l1.next, l2);
			return l1;
		} else {
			l2.next = merge(l1, l2.next);
			return l2;
		}
	}

	/**
	 * 非递归
	 */
	public ListNode merge2(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode cur = dummyHead;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}
		cur.next = l1 == null ? l2 : l1;
		return dummyHead.next;
	}
}
