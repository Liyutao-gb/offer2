package com.lyt.java;

import java.util.Stack;
//题目　
//	输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的
//结点，只能调整树中结点指针的指向。
//思路
//	首先想一下中序遍历的大概代码结构（先处理左子树，再处理根结点，之后处理右子树），
//假设左子树处理完了，就要处理根结点，而根结点必须知道左子树的最大结点，所以要用函数
//返回值记录下来；之后处理右子树，右子树的最小结点（也用中序遍历得到）要和根结点链接。
public class Offer36_ConvertBinarySearchTree {
	 class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	/**
	 * 非递归版本:中序遍历
	 */
	public TreeNode convert1(TreeNode root) {
		TreeNode head = null;
		TreeNode pre = null;
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (head == null) {
				head = root;
				pre = root;
			} else {
				root.left = pre;
				pre.right = root;
				pre = root; // 指针后移, 别漏写
			}
			root = root.right;
		}
		return head;
	}

	/**
	 * 递归版本
	 *  1.已知函数返回的是转换好的双向链表头结点 
	 *  2.左子树处理完后与根结点连接
	 *  3.右子树处理，也与根结点连接 
	 *  4.最后返回头结点
	 */
	public TreeNode convert2(TreeNode root) {
		if (root == null)
			return root;
		// 处理左子树,获得左子树链表的头结点
		TreeNode left = convert2(root.left);
		TreeNode p = left;
		if (left != null) {
			// 找到左子树链表的末尾结点
			while (p.right != null)
				p = p.right;
			// 连接结点
			p.right = root;
			root.left = p;
		}
		// 处理右子树，获得右子树链表的头结点
		TreeNode right = convert2(root.right);
		// 连接结点
		if (right != null) {
			root.right = right;
			right.left = root;
		}
		return left == null ? root : left;
	}
	
	/**
	 * 方法三
	 */
	public TreeNode convert3(TreeNode head) {
		if (head == null)
			return head;
		
		TreeNode lastNodeInList = null;
		lastNodeInList = convertHelper(head, lastNodeInList);
		TreeNode firstNodeInList = lastNodeInList;
		while (firstNodeInList.left != null) {
			firstNodeInList = firstNodeInList.left;
		}
		return firstNodeInList;
	}

	// 将以node为根结点的树转化为排序链表，链表头部与lastNode链接，并返回最后一个结点
	private TreeNode convertHelper(TreeNode node, TreeNode lastNode) {
		// 处理左子树，获得最大结点
		if (node.left != null)
			lastNode = convertHelper(node.left, lastNode);
		// 链接最大结点和根结点
		node.left = lastNode;
		if (lastNode != null)
			lastNode.right = node;
		// 处理右子树
		lastNode = node;
		if (node.right != null)
			lastNode = convertHelper(node.right, lastNode);
		return lastNode;
	}
	
	public static void main(String[] args) {
		Offer36_ConvertBinarySearchTree demo = new Offer36_ConvertBinarySearchTree();
		TreeNode left = demo.new TreeNode(1);
		TreeNode root = demo.new TreeNode(2);
		TreeNode right = demo.new TreeNode(3);
		root.left = left;
		root.right = right;
		
	}
}