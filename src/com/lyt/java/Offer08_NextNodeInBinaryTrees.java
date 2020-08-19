package com.lyt.java;

//��Ŀ
//	����һ�ö����������е�һ����㣬����ҳ��������˳�����һ����㣿 ���еĽ��
//�����������ֱ�ָ�������ӽ���ָ�����⣬����һ��ָ�򸸽���ָ�롣
//˼·
//	�����Լ��ڲݸ�ֽ�ϻ�ͼ�����з���������չ���������Է�����һ�����Ĺ���Ϊ��
//1.����ǰ�����������ʱ������һ�����Ϊ�������������ӽ�㣻
//2.����ǰ�����������ʱ��
//������1������ǰ���Ϊ�丸�������ӽ��ʱ������һ�����Ϊ�丸��㣻
//������2������ǰ���Ϊ�丸�������ӽ��ʱ���������ϱ��������ĸ���㣬ֱ��
//		      �ҵ�һ��������丸�������ӽ�㣨�루1�����ж���ͬ�����ý�㼴Ϊ��һ��㡣
public class Offer08_NextNodeInBinaryTrees {
	private class TreeLinkNode {
		int val;
		TreeLinkNode left;
		TreeLinkNode right;
		TreeLinkNode parent;

		TreeLinkNode(int val) {
			this.val = val;
		}
	}

	/**
	 * 1.�ڵ������������;
	 * 2.�ڵ������������,�����������(1)û�и���㣻(2)�и����
	 */
	public TreeLinkNode getNext(TreeLinkNode pNode) {
		if (pNode == null) 
			return null;
		
		if (pNode.right != null) {
			pNode = pNode.right;
			while (pNode.left != null)
				pNode = pNode.left;
			return pNode;
		}
		while (pNode.parent != null) {	// ѭ���ҵ�һ��������丸�������ӽ��
			if (pNode == pNode.parent.left)
				return pNode.parent;
			pNode = pNode.parent;
		}
		return null;
	}

	public void test1() {
		TreeLinkNode node = null;
		TreeLinkNode nextNode = getNext(node);
		if (nextNode != null)
			System.out.println(nextNode.val);
		else
			System.out.println("����һ���");
	}

	public void test2() {
		TreeLinkNode node1 = new TreeLinkNode(1);
		TreeLinkNode node2 = new TreeLinkNode(2);
		TreeLinkNode node3 = new TreeLinkNode(3);
		TreeLinkNode node4 = new TreeLinkNode(4);
		node1.left = node2;
		node1.right = node3;
		node2.parent = node1;
		node3.parent = node1;
		node4.left = node1;
		node1.parent = node4;
		TreeLinkNode nextNodeOf1 = getNext(node1);
		TreeLinkNode nextNodeOf2 = getNext(node2);
		TreeLinkNode nextNodeOf3 = getNext(node3);
		TreeLinkNode nextNodeOf4 = getNext(node4);
		if (nextNodeOf1 != null)
			System.out.println("1������һ�����ֵΪ��" + nextNodeOf1.val);
		else
			System.out.println("1�������һ���");
		if (nextNodeOf2 != null)
			System.out.println("2������һ�����ֵΪ��" + nextNodeOf2.val);
		else
			System.out.println("2�������һ���");
		if (nextNodeOf3 != null)
			System.out.println("3������һ�����ֵΪ��" + nextNodeOf3.val);
		else
			System.out.println("3�������һ���");
		if (nextNodeOf4 != null)
			System.out.println("4������һ�����ֵΪ��" + nextNodeOf4.val);
		else
			System.out.println("4�������һ���");
	}

	public static void main(String[] args) {
		Offer08_NextNodeInBinaryTrees demo = new Offer08_NextNodeInBinaryTrees();
		System.out.print("test1:");
		demo.test1();
		System.out.print("test2:");
		demo.test2();
	}
}
