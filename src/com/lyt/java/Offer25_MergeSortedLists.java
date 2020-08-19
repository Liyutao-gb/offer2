package com.lyt.java;

//��Ŀ��
//	����������������������ϲ�����������ʹ�������еĽ����Ȼ�ǰ��յ�������ġ�
//˼·
//	�ݹ�ʵ�֣��ϲ������У�ÿ�ζ��Ǵ������������ҳ���С��һ�������ӣ���˿��Բ��õݹ���
//ʵ�֣�������һ������Ϊnullʱ��ֱ��������һ�������ɣ��������ֻ��Ҫ�������������ҳ���С
//��һ�����������ӣ��ý���nextֵ����ͨ���ݹ麯�������ӡ�
//	�ǵݹ�ʵ�֣��ǵݹ�ʵ�ֱȽ������뵽��ֱ�ӽ��з�������ۼ��ɣ�Ҫ��΢ע���º��������ͷ
//���ĸ�ֵ���̡�
public class Offer25_MergeSortedLists {
	public class ListNode {
		int val;
		ListNode next = null;

		public ListNode(int val) {
			this.val = val;
		}
	}

	/**
	 * �ݹ�
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
	 * �ǵݹ�
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
