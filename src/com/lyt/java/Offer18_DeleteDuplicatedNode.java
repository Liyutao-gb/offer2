package com.lyt.java;

//题目
//	在一个排序的链表中，如何删除重复的结点？
//思路
//	设置一个preNode，用于记录当前结点的前一个结点，再设置一个布尔变量needDelete，如果
//当前结点和后一结点的值相同（记该值为dupVal），needDelete赋值为真。
//当needDelete为真时，通过循环往后找到第一个不为dupVal的结点，把该结点设置为当前结点，
//并赋值给preNode.next，即相当于完成了删除操作；而当needDelete为假时，把当前结点和
//preNode往后移一位即可。
public class Offer18_DeleteDuplicatedNode {
	class ListNode {
		int val;
		ListNode next ;

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = head;
		ListNode pre = dummy;
		while (cur != null && cur.next != null) {
			if (cur.val == cur.next.val) {
				int val = cur.val;
				while (cur != null && cur.val == val) {
					cur = cur.next;
				}
				pre.next = cur;
			} else {
				pre = cur;
				cur = cur.next;
			}
		}
		return dummy.next;
	}

	/**
	 * 1.当前结点不重复 
	 * 2.有结点重复 这里删除暂时不涉及前一结点操作，其实主要是找出后面第一个不重复结点
	 */
	public ListNode deleteDuplication(ListNode pHead) {
		if (pHead == null || pHead.next == null)
			return pHead;

		ListNode preNode = null;
		ListNode curNode = pHead;
		while (curNode != null) {
			boolean needDelete = false;
			if (curNode.next != null && curNode.val == curNode.next.val)
				needDelete = true;
			if (!needDelete) {
				preNode = curNode;
				curNode = curNode.next;
			} else {
				int dupValue = curNode.val;
				ListNode toBeDel = curNode;
				while (toBeDel != null && toBeDel.val == dupValue) {
					toBeDel = toBeDel.next;
				}
				if (preNode == null) {
					pHead = toBeDel;
				} else {
					preNode.next = toBeDel;// 删除重复结点,preNode暂时指向toBelDel
				}
				curNode = toBeDel; // toBeDel结点可能也是待删除结点
			}
		}
		return pHead;
	}

	// ========测试代码======
	void test(ListNode pHead) {
		System.out.println("-----------");
		System.out.print("The original list is: ");
		ListNode curr = pHead;
		if (curr != null) {
			while (curr.next != null) {
				System.out.print(curr.val + ",");
				curr = curr.next;
			}
			System.out.println(curr.val);
		} else {
			System.out.println();
		}
		pHead = deleteDuplication(pHead);
		System.out.print("The result list is: ");
		curr = pHead;
		if (curr != null) {
			while (curr.next != null) {
				System.out.print(curr.val + ",");
				curr = curr.next;
			}
			System.out.println(curr.val);
		} else {
			System.out.println();
		}
		System.out.println("-----------");
	}

	/**
	 * 重复结点位于链表头部
	 */
	void test1() {
		ListNode p4 = new ListNode(3, null);
		ListNode p3 = new ListNode(2, p4);
		ListNode p2 = new ListNode(1, p3);
		ListNode p1 = new ListNode(1, p2);
		test(p1);
	}

	/**
	 * 重复结点位于链表尾部
	 */
	void test2() {
		ListNode p4 = new ListNode(3, null);
		ListNode p3 = new ListNode(3, p4);
		ListNode p2 = new ListNode(2, p3);
		ListNode p1 = new ListNode(1, p2);
		test(p1);
	}

	/**
	 * 重复结点位于链表中部
	 */
	void test3() {
		ListNode p4 = new ListNode(3, null);
		ListNode p3 = new ListNode(2, p4);
		ListNode p2 = new ListNode(2, p3);
		ListNode p1 = new ListNode(1, p2);
		test(p1);
	}

	/**
	 * 连续出现重复结点
	 */
	void test4() {
		ListNode p6 = new ListNode(3, null);
		ListNode p5 = new ListNode(3, p6);
		ListNode p4 = new ListNode(2, p5);
		ListNode p3 = new ListNode(2, p4);
		ListNode p2 = new ListNode(1, p3);
		ListNode p1 = new ListNode(1, p2);
		test(p1);
	}

	/**
	 * 多个重复结点
	 */
	void test5() {
		ListNode p6 = new ListNode(3, null);
		ListNode p5 = new ListNode(3, p6);
		ListNode p4 = new ListNode(3, p5);
		ListNode p3 = new ListNode(2, p4);
		ListNode p2 = new ListNode(1, p3);
		ListNode p1 = new ListNode(1, p2);
		test(p1);
	}

	/**
	 * 无重复结点
	 */
	void test6() {
		ListNode p6 = new ListNode(6, null);
		ListNode p5 = new ListNode(5, p6);
		ListNode p4 = new ListNode(4, p5);
		ListNode p3 = new ListNode(3, p4);
		ListNode p2 = new ListNode(2, p3);
		ListNode p1 = new ListNode(1, p2);
		test(p1);
	}

	/**
	 * 单个结点
	 */
	void test7() {
		ListNode p1 = new ListNode(6, null);
		test(p1);
	}

	/**
	 * null
	 */
	void test8() {
		ListNode p1 = null;
		test(p1);
	}

	public static void main(String[] args) {
		Offer18_DeleteDuplicatedNode demo = new Offer18_DeleteDuplicatedNode();
		demo.test1();
		demo.test2();
		demo.test3();
		demo.test4();
		demo.test5();
		demo.test6();
		demo.test7();
		demo.test8();
	}
}
