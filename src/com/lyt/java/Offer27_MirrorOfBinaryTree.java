package com.lyt.java;

import java.util.LinkedList;
import java.util.Queue;
//��Ŀ��
//	�����һ������������һ�����������ú���������ľ���
//˼·
//	��ͼ���Ժ������صõ�˼·����ǰ���������ÿ����㽻�������ӽ�㡣
public class Offer27_MirrorOfBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	/**
	 * 1.�õ�������������������ӽ��;
	 * 2.���ҵݹ齻����
	 */
	public void mirror1(TreeNode root) {
		if (root == null)
			return;
		
		TreeNode tempNode = root.left;
		root.left = root.right;
		root.right = tempNode;
		
		mirror1(root.left);
		mirror1(root.right);
	}

	public void mirror2(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			TreeNode temp = cur.left;
			cur.left = cur.right;
			cur.right = temp;
			if (cur.left != null)
				queue.add(cur.left);
			if (cur.right != null)
				queue.add(cur.right);
		}
	}
}
