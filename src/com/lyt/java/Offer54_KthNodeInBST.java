package com.lyt.java;

import java.util.Stack;
//��Ŀ
//	����һ�ö��������������ҳ����еĵ�k��Ľ�㡣
//˼·
//	����ȫ�ֱ���index=0����BST�������������ÿ����һ����㣬index+1����index=kʱ��
//�ý�㼴Ϊ�����㡣
public class Offer54_KthNodeInBST {
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	/**
	 * ����һ�����ø���ջ��������������
	 */
	public TreeNode kthNode1(TreeNode root, int k) {
		if (root == null || k <= 0)
			throw new RuntimeException("���벻�Ϸ���");

		int index = 0;
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.empty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			index++;
			if (index == k)
				return root;
			root = root.right;
		}
		
		return null;
	}

	/**
	 * ���������ݹ�
	 */
	public TreeNode KthNode(TreeNode pRoot, int k) {
		if (pRoot == null || k <= 0)
			return null;

		TreeNode pNode = null;
		pNode = getKthNode(pRoot, k);
		return pNode;
	}

	int index = 0;

	// ��͸���ջ����������֮��
	private TreeNode getKthNode(TreeNode pRoot, int k) {
		if (pRoot == null)
			return null;

		TreeNode kthNode = null;
		kthNode = getKthNode(pRoot.left, k);
		index++;
		if (k == index)
			kthNode = pRoot;
		if (kthNode == null) // kthNode��Ϊnullֱ�ӷ��ؼ���
			kthNode = getKthNode(pRoot.right, k);

		return kthNode;
	}
}
