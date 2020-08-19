package com.lyt.java;

//��Ŀ��
//	һ�������а�����������ҳ�������ڽ�㣿
//˼·
//	1.ȷ�������Ƿ��л���ͨ��������ͬ�ٶȵ�ָ��ȷ����������ָ��ָ��ͬһ�����ʱ���ý��
//Ϊ���е�һ����㡣
//	2.ȷ�����н�����Ŀn��ָ����һȦ�����߱߼���
//	3.�ҵ�������ڣ���ͷ��㿪ʼ��ͨ���������Ϊn��ָ�����õ�(��Ѱ�������е�����n�����)
public class Offer23_EntryNodeInListLoop {
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
	
	// �ж��Ƿ��л�
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
	
	// ����ڽ��
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
		if (fast.next == null || fast.next.next == null) // �޻�
			return null;

		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

	/**
	 * ��ָOffer�ⷨ��
	 *     ȷ�������Ƿ��л������ÿ���ָ��ȷ�� ����ֵ�������ָ������ʱ�Ľ�㣬
	 * ����null���������޻�
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
	 * ���㻷����ڽ��
	 */
	public ListNode entryNodeOfLoop(ListNode head) {
		ListNode meetingNode = meetingNode(head);
		if (meetingNode == null)
			return null;

		// ���㻷�н�����Ŀ
		int count = 1; // ���н�����Ŀ
		ListNode pNode1 = meetingNode.next;
		while (pNode1 != meetingNode) {
			count++;
			pNode1 = pNode1.next;
		}

		// ���ƶ�pNode1������Ϊcount
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
