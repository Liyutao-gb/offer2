package com.lyt.java;

//��Ŀ
//	�������������ͷָ���һ�����ָ�룬����һ��������O(1)ʱ��ɾ���ý�㡣
//˼·
//	ͨ��������ͷ��ʼ����ɾ����Ҫ��ʱ��ΪO(n)��Ҫ��O(1)ʱ��ɾ��ĳ��㣬��������ʵ�֣�
//���ɾ�����i����һ�����Ϊj����j��ֵ���Ƶ�i���ٰ�i��ָ��ָ��j����һ����㣬���
//ɾ��j��Ч�����൱��ɾ��j��
//	ע�����������1.����ɾ�����iΪβ���ʱ������һ����㣬��ֻ�ܴ�ͷ��β˳�������
//2.��������ֻ��һ�����ʱ������ͷ��㣬����β��㣩�������ͷ���Ҳ����Ϊnull��
//�����и�ȱ�ݣ�Ҫ��O(1)ʱ��ɾ�����൱��������һ�����裺��ɾ���Ľ���ȷ�ڱ���
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
	 * 1.��ɾ���������һ�����;
	 * 2.����ͷ��㣬����β���;
	 * 3.β��㡣
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
				System.out.println("�޷��ҵ���ɾ����㣡");
				return head;
			}
			pre.next = null;
			p = null;
		}
		return head;
	}

	// =========���Դ���==========
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
	 * ���������㣬ɾ��ͷ���
	 */
	void test1() {
		ListNode p4 = new ListNode(4, null);
		ListNode p3 = new ListNode(3, p4);
		ListNode p2 = new ListNode(2, p3);
		ListNode p1 = new ListNode(1, p2);
		test(p1, p1);
	}

	/**
	 * ���������㣬ɾ���м���
	 */
	void test2() {
		ListNode p4 = new ListNode(4, null);
		ListNode p3 = new ListNode(3, p4);
		ListNode p2 = new ListNode(2, p3);
		ListNode p1 = new ListNode(1, p2);
		test(p1, p3);
	}

	/**
	 * ���������㣬ɾ��β���
	 */
	void test3() {
		ListNode p4 = new ListNode(4, null);
		ListNode p3 = new ListNode(3, p4);
		ListNode p2 = new ListNode(2, p3);
		ListNode p1 = new ListNode(1, p2);
		test(p1, p4);
	}

	/**
	 * ����һ����㣬ɾ�����
	 */
	void test4() {
		ListNode p4 = new ListNode(4, null);
		test(p4, p4);
	}

	/**
	 * ����Ϊ��
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
