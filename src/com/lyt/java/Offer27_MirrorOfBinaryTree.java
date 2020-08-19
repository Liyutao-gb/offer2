package com.lyt.java;

import java.util.LinkedList;
import java.util.Queue;
//题目　
//	请完成一个函数，输入一个二叉树，该函数输出它的镜像。
//思路
//	画图可以很清晰地得到思路：先前序遍历，对每个结点交换左右子结点。
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
	 * 1.用第三个结点来交换左右子结点;
	 * 2.左右递归交换。
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
