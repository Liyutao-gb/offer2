package com.lyt.java;

//题目
//	输入两个树结点，求它们的最低公共祖先。
//思路
//	该题首先要和面试官确定是否为二叉树，得到肯定答复后，还要确定是否为二叉搜索树，是否
//有父指针，或者仅仅是普通二叉树。
//	1.树为二叉搜索树时，最低公共祖先结点的大小在两个树结点大小的中间。
//	2.树为普通树时，使用遍历将子结点的信息往上传递。在左右子树中进行查找是否存在两个树
//结点，如果两个树结点分别在左右子树上，说明该根结点就是它们的最低公共祖先。
public class Offer68_LowestCommonParent {
	
	/**
	 * 二叉搜索树: 利用二叉树性质
	 */
	public TreeNode getLowestCommonParentBST(TreeNode root, TreeNode p, TreeNode q) {
		while (true) {
			if (root == null)
				return root;
			if (root.val < p.val && root.val < q.val)
				root = root.right;
			else if (root.val > p.val && root.val > q.val)
				root = root.left;
			else
				return root;
		}
	}

	/**
	 * 普通二叉树: 将下面结点的信息利用递归往上传递
	 */
	public TreeNode getLowestCommonParent(TreeNode root, TreeNode node1, TreeNode node2) {
		if (root == null || root == node1 || root == node2)
			return root;
		TreeNode left = getLowestCommonParent(root.left, node1, node2);
		TreeNode right = getLowestCommonParent(root.right, node1, node2);
		if (left != null && right != null)
			return root;
		return left == null ? right : left;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(1);
		TreeNode node4 = new TreeNode(2);
		TreeNode node3 = new TreeNode(6);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node4.left = new TreeNode(7);
		node4.right = new TreeNode(4);
		node2.left = new TreeNode(0);
		node2.right = new TreeNode(8);
		Offer68_LowestCommonParent demo = new Offer68_LowestCommonParent();
		TreeNode node = demo.getLowestCommonParent(root, node3, node4);
		System.out.println(node.val);
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int val) {
		this.val = val;
	}
}
