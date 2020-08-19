package com.lyt.java;

//��Ŀ��
//	����һ������������һ�������ͷ��㣬��ת�����������ת�������ͷ��㡣
//˼·
//	����һ��ʹ������ָ�루pre,p,next������ʵ�֡���pָ��pre��next�������ڷ�ֹ������ѡ�
//	���������ݹ飩���ҵ����һ�������Ϊ����ֵ���ݹ麯���У��ҵ�����ͷ���󣬿�ʼ����
//ÿ�����nextֵ��ת����
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
	 * �ǵݹ�
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
     * �ݹ�汾��
	 *    ������������Ϊ1��2��3��4��5��
	 *  5->next = 4��4->next = null		5->4->null			
	 *	4->next = 3��3->next = null		5->4->3->null			
	 *	3->next = 2��2->next = null		5->4->3->2->null		
	 *	2->next = 1��1->next = null		5->4->3->2->1->null	
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
			cur.last = newNext;// �͵�����Ĳ�֮ͬ��
			pre = cur;
			cur = newNext;
		}
		return pre;
	}
}

