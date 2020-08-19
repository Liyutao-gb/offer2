package com.lyt.java;

//题目
//	输入一棵二叉树的根结点，求该树的深度。从根结点到叶结点依次经过的/结点（含根、叶结点）
//形成树的一条路径，最长路径的长度为树的深度。
//思路
//	简洁理解：树的深度 = max(左子树深度，右子树深度) + 1。采用递归实现。
public class Offer55_TreeDepth {
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public int treeDepth(TreeNode root) {
		if (root == null)
			return 0;
		int left = treeDepth(root.left);
		int right = treeDepth(root.right);
		return Math.max(left, right) + 1;
		// return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
	}
}
