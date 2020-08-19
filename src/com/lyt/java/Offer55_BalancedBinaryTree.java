package com.lyt.java;

//题目
//	输入一棵二叉树的根结点，判断该树是不是平衡二叉树。如果某二叉树中任意结点的左右子树
//的深度相差不超过1，那么它就是一棵平衡二叉树。
//思路
//	计算树的深度，树的深度=max(左子树深度，右子树深度)+1。
//在遍历过程中，判断左右子树深度相差是否超过1，如果不平衡，则令flag为false，用来表示树
//不平衡。
public class Offer55_BalancedBinaryTree {
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	/**
	 * 每个节点遍历一次解法。空树是平衡二叉树。
	 */
	boolean ans = true;

	public boolean isBalanced(TreeNode root) {
		height(root);
		return ans;
	}

	public int height(TreeNode root) {
		if (root == null)
			return 0;
		int left = height(root.left);
		int right = height(root.right);
		if (Math.abs(left - right) > 1)
			ans = false;
		return Math.max(left, right) + 1;
	}
}
