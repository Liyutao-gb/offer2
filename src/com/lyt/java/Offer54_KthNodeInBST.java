package com.lyt.java;

import java.util.Stack;
//题目
//	给定一棵二叉搜索树，请找出其中的第k大的结点。
//思路
//	设置全局变量index=0，对BST进行中序遍历，每遍历一个结点，index+1，当index=k时，
//该结点即为所求结点。
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
	 * 方法一：利用辅助栈遍历二叉搜索树
	 */
	public TreeNode kthNode1(TreeNode root, int k) {
		if (root == null || k <= 0)
			throw new RuntimeException("输入不合法！");

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
	 * 方法二：递归
	 */
	public TreeNode KthNode(TreeNode pRoot, int k) {
		if (pRoot == null || k <= 0)
			return null;

		TreeNode pNode = null;
		pNode = getKthNode(pRoot, k);
		return pNode;
	}

	int index = 0;

	// 与和辅助栈遍历有相似之处
	private TreeNode getKthNode(TreeNode pRoot, int k) {
		if (pRoot == null)
			return null;

		TreeNode kthNode = null;
		kthNode = getKthNode(pRoot.left, k);
		index++;
		if (k == index)
			kthNode = pRoot;
		if (kthNode == null) // kthNode不为null直接返回即可
			kthNode = getKthNode(pRoot.right, k);

		return kthNode;
	}
}
