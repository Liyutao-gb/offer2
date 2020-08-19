package com.lyt.java;

//题目　
//	定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
//思路
//	方法一：使用三个指针（pre,p,next）进行实现。令p指向pre，next则是用于防止链表断裂。
//	方法二（递归）：找到最后一个结点作为返回值，递归函数中，找到最后的头结点后，开始进行
//每个结点next值的转换。
public class Offer24_ReverseList {
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
	
	public class DoubleNode {
		int val;
		DoubleNode next;
		DoubleNode last;
		
		DoubleNode(int val){
			this.val = val;
		}
	}

	/**
	 * 非递归
	 */
	public ListNode reverseList(ListNode head) {
		ListNode pre = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}

	/**
     * 递归版本：
	 *    不妨假设链表为1，2，3，4，5。
	 *  5->next = 4，4->next = null		5->4->null			
	 *	4->next = 3，3->next = null		5->4->3->null			
	 *	3->next = 2，2->next = null		5->4->3->2->null		
	 *	2->next = 1，1->next = null		5->4->3->2->1->null	
	 */
	public ListNode reverseList1(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode newHead = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
	
	public DoubleNode reverseList(DoubleNode head) {
		DoubleNode cur = head;
		DoubleNode pre = null;
		while (cur != null) {
			DoubleNode newNext = cur.next;
			cur.next = pre;
			cur.last = newNext;// 和单链表的不同之处
			pre = cur;
			cur = newNext;
		}
		return pre;
	}
}

