package com.lyt.java;

//��Ŀ
//	��һ������������У����ɾ���ظ��Ľ�㣿
//˼·
//	����һ��preNode�����ڼ�¼��ǰ����ǰһ����㣬������һ����������needDelete�����
//��ǰ���ͺ�һ����ֵ��ͬ���Ǹ�ֵΪdupVal����needDelete��ֵΪ�档
//��needDeleteΪ��ʱ��ͨ��ѭ�������ҵ���һ����ΪdupVal�Ľ�㣬�Ѹý������Ϊ��ǰ��㣬
//����ֵ��preNode.next�����൱�������ɾ������������needDeleteΪ��ʱ���ѵ�ǰ����
//preNode������һλ���ɡ�
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
	 * 1.��ǰ��㲻�ظ� 
	 * 2.�н���ظ� ����ɾ����ʱ���漰ǰһ����������ʵ��Ҫ���ҳ������һ�����ظ����
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
					preNode.next = toBeDel;// ɾ���ظ����,preNode��ʱָ��toBelDel
				}
				curNode = toBeDel; // toBeDel������Ҳ�Ǵ�ɾ�����
			}
		}
		return pHead;
	}

	// ========���Դ���======
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
	 * �ظ����λ������ͷ��
	 */
	void test1() {
		ListNode p4 = new ListNode(3, null);
		ListNode p3 = new ListNode(2, p4);
		ListNode p2 = new ListNode(1, p3);
		ListNode p1 = new ListNode(1, p2);
		test(p1);
	}

	/**
	 * �ظ����λ������β��
	 */
	void test2() {
		ListNode p4 = new ListNode(3, null);
		ListNode p3 = new ListNode(3, p4);
		ListNode p2 = new ListNode(2, p3);
		ListNode p1 = new ListNode(1, p2);
		test(p1);
	}

	/**
	 * �ظ����λ�������в�
	 */
	void test3() {
		ListNode p4 = new ListNode(3, null);
		ListNode p3 = new ListNode(2, p4);
		ListNode p2 = new ListNode(2, p3);
		ListNode p1 = new ListNode(1, p2);
		test(p1);
	}

	/**
	 * ���������ظ����
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
	 * ����ظ����
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
	 * ���ظ����
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
	 * �������
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
