package com.lyt.java;

//题目
//	输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和
//中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1, 2, 4, 7, 3, 5, 6, 8}
//和中序遍历序列{4, 7, 2, 1, 5, 3, 8, 6}，则重建出其二叉树并输出它的头结点
//思路
//	前序遍历第一个值就是根结点的值，根据该值在中序遍历的位置，可以轻松找出该根结点左右
//子树的前序遍历和中序遍历，之后又可以用同样方法构建左右子树，所以该题可以采用递归的方
//法完成。
//	刚开始思考的时候，想的是构建一个遍历函数，输入为前序和中序遍历的数组，输出为根结点。
//但是这样的话每次都需要构建子树的数组，非常麻烦。
//之后想到，该函数的输入不一定要用数组，因为最初的前序和中序遍历数组已经有了，
//就直接用该数组的下标来表示子树的数组即可。
//即构建函数construct(int[] pre, int[] in, int pStart, int pEnd, int iStart, 
//int iEnd)，pre和in始终用最初前序遍历和中序遍历的数组代入，pStart、pEnd代表当前树的
//前序数组开始和结束位置，iStart、iEnd代表中序数组开始和结束位置。
public class Offer07_ConstructBinaryTree {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if (pre == null || in == null || pre.length <= 0 || in.length <= 0 || pre.length != in.length)
			throw new RuntimeException("数组不符合规范！");
		
		return construct(pre, in, 0, pre.length - 1, 0, in.length - 1);
	}

	/**
	 * @Description 由前序遍历序列和中序遍历序列得到根结点 pre、in：始终用最初的前序
	 * 				遍历和中序遍历数组代入pStart、pEnd：当前树的前序数组开始和结束
	 * 				位置 iStart、iEnd：中序数组开始和结束位置
	 */
	public TreeNode construct(int[] pre, int[] in, int pStart, int pEnd, int iStart, int iEnd) {
		TreeNode root = new TreeNode(pre[pStart]);
		if (pStart == pEnd && iStart == iEnd) { // 只有一个根结点情况
			if (pre[pStart] != in[iStart])
				throw new RuntimeException("数组不符合规范！");
			return root;
		}
		int index = iStart; // 用于记录中序遍历序列中根结点的位置
		while (root.val != in[index] && index <= iEnd) {
			index++;
		}
		if (index > iEnd)
			throw new RuntimeException("数组不符合规范！");// 中序数组找不到根结点
		int leftLength = index - iStart;
		if (leftLength > 0) {
			root.left = construct(pre, in, pStart + 1, pStart + leftLength, iStart, index - 1);
		}
		if (leftLength < iEnd - iStart) {
			root.right = construct(pre, in, pStart + leftLength + 1, pEnd, index + 1, iEnd);
		}
		return root;
	}

	private void preOrderTraverse(TreeNode node) {
		if (node == null)
			return;
		System.out.print(node.val);
		preOrderTraverse(node.left);
		preOrderTraverse(node.right);
	}

	private void inOrderTraverse(TreeNode node) {
		if (node == null)
			return;
		inOrderTraverse(node.left);
		System.out.print(node.val);
		inOrderTraverse(node.right);
	}

	/**
	 * 正常二叉树
	 */
	public void test1() {
		int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
		TreeNode root = reConstructBinaryTree(pre, in);
		System.out.print("test1:");
		preOrderTraverse(root);
		System.out.print("//");
		inOrderTraverse(root);
		System.out.println();
	}

	/**
	 * 左斜树
	 */
	public void test2() {
		int[] pre = { 1, 2, 3, 4, 5 };
		int[] in = { 5, 4, 3, 2, 1 };
		TreeNode root = reConstructBinaryTree(pre, in);
		System.out.print("test2:");
		preOrderTraverse(root);
		System.out.print("//");
		inOrderTraverse(root);
		System.out.println();
	}

	/**
	 * 右斜树
	 */
	public void test3() {
		int[] pre = { 1, 2, 3, 4, 5 };
		int[] in = { 1, 2, 3, 4, 5 };
		TreeNode root = reConstructBinaryTree(pre, in);
		System.out.print("test3:");
		preOrderTraverse(root);
		System.out.print("//");
		inOrderTraverse(root);
		System.out.println();
	}

	/**
	 * 单个结点
	 */
	public void test4() {
		int[] pre = { 1 };
		int[] in = { 1 };
		TreeNode root = reConstructBinaryTree(pre, in);
		System.out.print("test4:");
		preOrderTraverse(root);
		System.out.print("//");
		inOrderTraverse(root);
		System.out.println();
	}

	/**
	 * 数组为空
	 */
	public void test5() {
		int[] pre = {};
		int[] in = {};
		TreeNode root = reConstructBinaryTree(pre, in);
		System.out.print("test5:");
		preOrderTraverse(root);
		System.out.print("//");
		inOrderTraverse(root);
		System.out.println();
	}

	public static void main(String[] args) {
		Offer07_ConstructBinaryTree demo = new Offer07_ConstructBinaryTree();
		demo.test1();
		demo.test2();
		demo.test3();
		demo.test4();
		demo.test5();
	}
}