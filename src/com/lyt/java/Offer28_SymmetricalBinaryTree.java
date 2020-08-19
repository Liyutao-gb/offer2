package com.lyt.java;

import java.util.LinkedList;
import java.util.Queue;
//题目　
//	请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么
//它是对称（Symmetry）的。
//思路
//	还是画图分析，不用分析根结点，只需要分析左右子树。可以看出，左右子树刚好是呈镜像
//的两颗二叉树，所以：对左子树采用（父-左-右）的前序遍历，右子树采用（父-右-左）的前序
//遍历，遍历时判断两个结点位置的值是否相等即可。（也可以这样理解：左树的左子树等于右树
//的右子树，左树的右子树等于右树的左子树，对应位置刚好相反，判断两子树相反位置上的值是
//否相等即可）
public class Offer28_SymmetricalBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	/**
	 * 1.根节点为空,默认是对称的;
	 * 2.根节点不为空。
	 */
	public boolean isSymmetrical(TreeNode pRoot) {
		if (pRoot == null)
			return true;
		return isEqual(pRoot.left, pRoot.right);
	}

	private boolean isEqual(TreeNode pRoot1, TreeNode pRoot2) {
		if (pRoot1 == null && pRoot2 == null)
			return true;
		if (pRoot1 == null || pRoot2 == null)
			return false;
		if(pRoot1.val != pRoot2.val)
			return false;
		return isEqual(pRoot1.left, pRoot2.right) && isEqual(pRoot1.right, pRoot2.left);
	}
	
	// 迭代
	public boolean isSymmetric(TreeNode root) {
		if(root == null)
			return true;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root.left);
		queue.add(root.right);
		while (!queue.isEmpty()) {
			TreeNode root1 = queue.poll();
			TreeNode root2 = queue.poll();
			if (root1 == null && root2 == null)
				continue;
			if (root1 == null || root2 == null)
				return false;
			if (root1.val != root2.val)
				return false;
			queue.add(root1.left);
			queue.add(root2.right);
			queue.add(root1.right);
			queue.add(root2.left);
		}
		return true;
	}
}
