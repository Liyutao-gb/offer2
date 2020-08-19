package com.lyt.java;

//题目　
//	输入两棵二叉树A和B，判断B是不是A的子结构(含有即可)。
//思路
//	1）先对A树进行遍历，找到与B树的根结点值相同的结点R；
//	2）判断A树中以R为根结点的子树是否包含B树一样的结构。
public class Offer26_SubstructureInTree {
	public class TreeNode {
		double val;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	/**
	 * 主程序，对每个结点遍历判断
	 */
	public boolean hasSubtree(TreeNode root1, TreeNode root2) {
		if (root1 == null || root2 == null)
			return false;
		return doesTree1HasTree2(root1, root2) || hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
	}

	/**
	 * 判断root结点开始的子树中各个结点是否相同
	 */
	private boolean doesTree1HasTree2(TreeNode root1, TreeNode root2) {
		if (root2 == null) // root2下面无结点,不用继续往下判断了,返回即可
			return true;
		if (root1 == null)
			return false;
		if (root1.val != root2.val)
			return false;
		return doesTree1HasTree2(root1.left, root2.left) && doesTree1HasTree2(root1.right, root2.right);
	}
}
