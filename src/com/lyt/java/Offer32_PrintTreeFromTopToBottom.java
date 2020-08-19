package com.lyt.java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
//题目　
//（一）从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印。
//（二）从上到下按层打印二叉树，同一层的结点按从左到右的顺序打印，每一层打印到一行。
//（三）请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层
//按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
public class Offer32_PrintTreeFromTopToBottom {
	public class TreeNode {
		int val;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}
	/**
	 * 层序遍历(层与层不留间隙):
	 *     结点满足先进先出的原则，采用队列。每从队列中取出头部结点并打印，若其有子结点，
	 * 把子结点放入队列尾部，直到所有结点打印完毕。 
	 */
	public void printTree1(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (queue.size() != 0) {
			TreeNode node = queue.poll();
			System.out.print(node.val + " ");
			if (node.left != null)
				queue.offer(node.left);
			if (node.right != null)
				queue.offer(node.right);
		}
		System.out.println();// 测试方法之间空行
	}

	/**
	 * 层序遍历(分行)：记录每一行的长度，行与行之间分割开来。
	 */
	public void printTree2(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int count = 0; // 当前层结点数目
		int nextCount = 1; // 下一层结点数目
		while (!queue.isEmpty()) {
			count = nextCount;
			nextCount = 0;
			// 打印当前层数字，并计算下一层结点数目    int length = queue.size();
			for (int i = 1; i <= count; i++) {
				TreeNode node = queue.poll();
				System.out.print(node.val + " ");
				if (node.left != null) {
					queue.offer(node.left);
					nextCount++;
				}
				if (node.right != null) {
					queue.offer(node.right);
					nextCount++;
				}
			}
			System.out.println();
		}
	}
	
	/**
	 * “ 之字形  ”(ZigZag)遍历:
	 *     一个栈用于正向存储，一个栈用于逆向存储，打印出来就正好是相反方向。
	 */
	public void printTree3(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		stack1.push(root);
		while (!stack1.empty() || !stack2.empty()) {
			while (!stack1.empty()) {
				TreeNode node = stack1.pop();
				System.out.print(node.val + " ");
				if (node.left != null)
					stack2.push(node.left);
				if (node.right != null)
					stack2.push(node.right);
			}
			System.out.println();
			while (!stack2.empty()) {
				TreeNode node = stack2.pop();
				System.out.print(node.val + " ");
				if (node.right != null)
					stack1.push(node.right);
				if (node.left != null)
					stack1.push(node.left);
			}
			System.out.println();
		}
	}

	// ============测试代码==============
	private void test(int testNum, TreeNode root) {
		System.out.println("=========test" + testNum + "===========");
		System.out.println("method1:");
		printTree1(root);
		System.out.println("method2:");
		printTree2(root);
		System.out.println("method3:");
		printTree3(root);
	}

	// null
	private void test1() {
		TreeNode node = null;
		test(1, node);
	}

	// 单个结点
	private void test2() {
		TreeNode node = new TreeNode(1);
		test(2, node);
	}

	// 左斜
	private void test3() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		node1.left = node2;
		node2.left = node3;
		test(3, node1);
	}

	// 右斜
	private void test4() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		node1.right = node2;
		node2.right = node3;
		test(4, node1);
	}

	// 完全二叉树
	private void test5() {
		TreeNode[] nodes = new TreeNode[15];
		for (int i = 0; i < 15; i++) {
			nodes[i] = new TreeNode(i + 1);
		}
		for (int i = 0; i < 7; i++) {
			nodes[i].left = nodes[2 * i + 1];
			nodes[i].right = nodes[2 * i + 2];
		}
		test(5, nodes[0]);
	}

	public static void main(String[] args) {
		Offer32_PrintTreeFromTopToBottom demo = new Offer32_PrintTreeFromTopToBottom();
		demo.test1();
		demo.test2();
		demo.test3();
		demo.test4();
		demo.test5();
	}
}
