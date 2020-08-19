package com.lyt.java;

import java.util.Stack;
//��Ŀ��
//	����һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µ�
//��㣬ֻ�ܵ������н��ָ���ָ��
//˼·
//	������һ����������Ĵ�Ŵ���ṹ���ȴ������������ٴ������㣬֮��������������
//�����������������ˣ���Ҫ�������㣬����������֪��������������㣬����Ҫ�ú���
//����ֵ��¼������֮����������������������С��㣨Ҳ����������õ���Ҫ�͸�������ӡ�
public class Offer36_ConvertBinarySearchTree {
	 class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	/**
	 * �ǵݹ�汾:�������
	 */
	public TreeNode convert1(TreeNode root) {
		TreeNode head = null;
		TreeNode pre = null;
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (head == null) {
				head = root;
				pre = root;
			} else {
				root.left = pre;
				pre.right = root;
				pre = root; // ָ�����, ��©д
			}
			root = root.right;
		}
		return head;
	}

	/**
	 * �ݹ�汾
	 *  1.��֪�������ص���ת���õ�˫������ͷ��� 
	 *  2.�����������������������
	 *  3.����������Ҳ���������� 
	 *  4.��󷵻�ͷ���
	 */
	public TreeNode convert2(TreeNode root) {
		if (root == null)
			return root;
		// ����������,��������������ͷ���
		TreeNode left = convert2(root.left);
		TreeNode p = left;
		if (left != null) {
			// �ҵ������������ĩβ���
			while (p.right != null)
				p = p.right;
			// ���ӽ��
			p.right = root;
			root.left = p;
		}
		// ��������������������������ͷ���
		TreeNode right = convert2(root.right);
		// ���ӽ��
		if (right != null) {
			root.right = right;
			right.left = root;
		}
		return left == null ? root : left;
	}
	
	/**
	 * ������
	 */
	public TreeNode convert3(TreeNode head) {
		if (head == null)
			return head;
		
		TreeNode lastNodeInList = null;
		lastNodeInList = convertHelper(head, lastNodeInList);
		TreeNode firstNodeInList = lastNodeInList;
		while (firstNodeInList.left != null) {
			firstNodeInList = firstNodeInList.left;
		}
		return firstNodeInList;
	}

	// ����nodeΪ��������ת��Ϊ������������ͷ����lastNode���ӣ����������һ�����
	private TreeNode convertHelper(TreeNode node, TreeNode lastNode) {
		// ��������������������
		if (node.left != null)
			lastNode = convertHelper(node.left, lastNode);
		// ���������͸����
		node.left = lastNode;
		if (lastNode != null)
			lastNode.right = node;
		// ����������
		lastNode = node;
		if (node.right != null)
			lastNode = convertHelper(node.right, lastNode);
		return lastNode;
	}
	
	public static void main(String[] args) {
		Offer36_ConvertBinarySearchTree demo = new Offer36_ConvertBinarySearchTree();
		TreeNode left = demo.new TreeNode(1);
		TreeNode root = demo.new TreeNode(2);
		TreeNode right = demo.new TreeNode(3);
		root.left = left;
		root.right = right;
		
	}
}