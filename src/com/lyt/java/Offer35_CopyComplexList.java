package com.lyt.java;

//��Ŀ��
//	��ʵ�ֺ���ComplexListNode* Clone(ComplexListNode* pHead)������һ����������
//�ڸ��������У�ÿ����������һ��m_pNextָ��ָ����һ�����⣬����һ��m_pSibling ָ��
//�����е����������nullptr��
//˼·
//	˼·1���ȸ��ƽ�㣬��next���ӣ�������ԭʼ����siblingָ��ȷ����sibling������
//ͷ����λ�ã��Ӷ��Ը��ƽ������siblingָ�롣���Ǹ�˼·����n����������ÿ������
//sibling����ҪO(n)��ʱ�䲽�����ҵ�������ʱ�临�Ӷ�ΪO(n^2)
//	˼·2������ԭʼ���N����N������next���ӡ���<N,N'>�������Ϣ�����һ����ϣ���У�
//������siblingʱ��ͨ����ϣ��ֻ��Ҫ��O(1)��ʱ�伴���ҵ����ƽ���sibling���÷�����
//ʱ�临�Ӷ�ΪO(n)�����ռ临�Ӷ�ΪO(n)��
//	˼·3������ԭʼ���N����N������N'���ӵ�N�ĺ��棻����ԭʼ���N��sibling���Կ�������N'
//����sibling���������������ֳ�ԭʼ����͸�������������żλ�ã�
public class Offer35_CopyComplexList {
	public class ComplexListNode {
		int val;
		ComplexListNode next;
		ComplexListNode sibling;

		ComplexListNode(int val) {
			this.val = val;
		}
	}

	/*
	 * �����򣨰���������
	 */
	public ComplexListNode cloneList(ComplexListNode head) {
		cloneNodes(head); // 1.���ƽ��
		connectSiblingNodes(head); // 2.����sibling
		return reconnectNodes(head);// 3.��ֳ�����
	}

	/*
	 * ��һ��������ÿ����㣬�����뵽ԭʼ�ڵ�ĺ���
	 */
	private void cloneNodes(ComplexListNode head) {
		ComplexListNode pNode = head;
		while (pNode != null) {
			ComplexListNode clonedNode = new ComplexListNode(pNode.val);
			clonedNode.next = pNode.next;
			pNode.next = clonedNode;
			pNode = clonedNode.next;
		}
	}

	/*
	 * �ڶ���������ԭ����sibling�����ø��ƽ���sibling
	 */
	private void connectSiblingNodes(ComplexListNode head) {
		ComplexListNode pNode = head;
		while (pNode != null) {
			if (pNode.sibling != null) // ���뿼�ǵ�siblingNode==null�������
				pNode.next.sibling = pNode.sibling.next;
			pNode = pNode.next.next;
		}
	}

	/*
	 * �����������������ֳ�ԭʼ����͸�������������żλ�ã�
	 */
	private ComplexListNode reconnectNodes(ComplexListNode head) {
		ComplexListNode clonedHead = null;
		ComplexListNode clonedNode = null;
		ComplexListNode pNode = head;
		if (head != null) {
			clonedHead = head.next;
			clonedNode = pNode.next;
			pNode.next = clonedNode.next;
			pNode = pNode.next; // ��ǰ��pNodeָ����һ����㣬�����ж��Ƿ�Ϊnull
		}
		while (pNode != null) {
			clonedNode.next = pNode.next;
			clonedNode = clonedNode.next;
			pNode.next = clonedNode.next;
			pNode = pNode.next;
		}
		return clonedHead;
	}
	
//	���������򻯰�
//	private ComplexListNode reconnectNodes(ComplexListNode head) {
//		if(head == null)
//			return null;
//		ComplexListNode clonedHead = head.next;
//		ComplexListNode clonedNode = head.next;
//		ComplexListNode pNode = head;
//		while (clonedNode.next != null) {
//			pNode.next = clonedNode.next;
//			pNode = pNode.next;
//			clonedNode.next = pNode.next;
//			clonedNode = clonedNode.next;
//		}
//		return clonedHead;
//	}
	
}
