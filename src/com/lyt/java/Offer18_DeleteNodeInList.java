package com.lyt.java;

//题目
//	给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该结点。
//思路
//	通常那样从头开始查找删除需要的时间为O(n)，要在O(1)时间删除某结点，可以这样实现：
//设待删除结点i的下一个结点为j，把j的值复制到i，再把i的指针指向j的下一个结点，最后
//删除j，效果就相当于删除j。
//	注意特殊情况：1.当待删除结点i为尾结点时，无下一个结点，则只能从头到尾顺序遍历；
//2.当链表中只有一个结点时（即是头结点，又是尾结点），必须把头结点也设置为null。
//本题有个缺陷：要求O(1)时间删除，相当于隐藏了一个假设：待删除的结点的确在表中
public class Offer18_DeleteNodeInList {
	public class ListNode {
		int val;
		ListNode next;

		public ListNode(int value, ListNode nextNode) {
			val = value;
			next = nextNode;
		}
	}

	/**
	 * 1.待删除结点有下一个结点;
	 * 2.既是头结点，又是尾结点;
	 * 3.尾结点。
	 */
	public ListNode deleteNode(ListNode head, ListNode p) {
		if (head == null || p == null)
			return head;
		
		if (p.next != null) {
			p.val = p.next.val;
			p.next = p.next.next;
		} else if (head == p) {
			head = null;
		} else {
			ListNode pre = head;
			while (pre != null && pre.next != p) {
				pre = pre.next;
			}
			if (pre == null) {
				System.out.println("无法找到待删除结点！");
				return head;
			}
			pre.next = null;
			p = null;
		}
		return head;
	}

	// =========测试代码==========
	void test(ListNode head, ListNode PToBeDelete) {
		System.out.println("============");
		System.out.print("The original list is: ");
		ListNode curr = head;
		if (curr != null) {
			while (curr.next != null) {
				System.out.print(curr.val + ",");
				curr = curr.next;
			}
			System.out.println(curr.val);
		} else {
			System.out.println();
		}

		System.out.print("The node to be deleted is: ");
		if (PToBeDelete != null)
			System.out.println(PToBeDelete.val);
		else
			System.out.println();

		curr = deleteNode(head, PToBeDelete);
		System.out.print("The result list is: ");
		if (curr != null) {
			while (curr.next != null) {
				System.out.print(curr.val + ",");
				curr = curr.next;
			}
			System.out.println(curr.val);
		} else {
			System.out.println();
		}
		System.out.println("============");
	}

	/**
	 * 链表含多个结点，删除头结点
	 */
	void test1() {
		ListNode p4 = new ListNode(4, null);
		ListNode p3 = new ListNode(3, p4);
		ListNode p2 = new ListNode(2, p3);
		ListNode p1 = new ListNode(1, p2);
		test(p1, p1);
	}

	/**
	 * 链表含多个结点，删除中间结点
	 */
	void test2() {
		ListNode p4 = new ListNode(4, null);
		ListNode p3 = new ListNode(3, p4);
		ListNode p2 = new ListNode(2, p3);
		ListNode p1 = new ListNode(1, p2);
		test(p1, p3);
	}

	/**
	 * 链表含多个结点，删除尾结点
	 */
	void test3() {
		ListNode p4 = new ListNode(4, null);
		ListNode p3 = new ListNode(3, p4);
		ListNode p2 = new ListNode(2, p3);
		ListNode p1 = new ListNode(1, p2);
		test(p1, p4);
	}

	/**
	 * 链表含一个结点，删除结点
	 */
	void test4() {
		ListNode p4 = new ListNode(4, null);
		test(p4, p4);
	}

	/**
	 * 链表为空
	 */
	void test5() {
		test(null, null);
	}

	public static void main(String[] args) {
		Offer18_DeleteNodeInList demo = new Offer18_DeleteNodeInList();
		demo.test1();
		demo.test2();
		demo.test3();
		demo.test4();
		demo.test5();
	}
}
