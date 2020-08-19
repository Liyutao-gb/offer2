package com.lyt.java;

import java.util.ArrayList;
import java.util.List;

//题目　
//	输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。从树的根结点
//开始往下一直到叶结点所经过的结点形成一条路径。
//思路
//	通过前序遍历，从根结点出发，每次在链表中存储遍历到的结点，若到达叶子结点，则根据所有
//结点的和是否等于输入的整数，判断是否打印输出。在当前结点访问结束后，递归函数将会返回到
//它的父结点，所以在函数退出之前，要删除链表中的当前结点，以确保返回父结点时，储存的路径
//刚好是从根结点到父结点。
public class Offer34_PathInTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	/**
	 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径
	 * 上所有节点值相加等于目标和。
	 * 说明: 叶子节点是指没有子节点的节点。
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		sum -= root.val;
		if (sum == 0 && root.left == null && root.right == null)
			return true;
		return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
	}

	/**
	 * 1.假设找到了其中一条路径，达到叶结点后，由于没有指向父结点的指针，所以必须提前
	 * 创建一个链表存储前面经过的结点。
	 * 2.由于是从根结点出发，所以要想到使用前序遍历 
	 * 3.利用链表存储结点，在该结点完成左右子树的路径搜索后（即递归函数结束，返回到其
	 * 父结点之前），要删除该结点，从而记录别的路径。
	 */
	public void findPath(TreeNode root, int target) {
		if (root == null)
			return;

		List<Integer> list = new ArrayList<>();
		printPath(root, target, list);
	}

	private void printPath(TreeNode node, int target, List<Integer> list) {
		if (node == null)
			return;

		list.add(node.val);
		target -= node.val;
		if (target == 0 && node.left == null && node.right == null) {
			for (int i : list)
				System.out.print(i + " ");
			System.out.println();
		}
		printPath(node.left, target, list);
		printPath(node.right, target, list);
		list.remove(list.size() - 1);
	}
}