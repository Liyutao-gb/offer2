package com.lyt.java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
//��Ŀ��
//��һ���������´�ӡ����������ÿ����㣬ͬһ��Ľ�㰴�մ����ҵ�˳���ӡ��
//���������ϵ��°����ӡ��������ͬһ��Ľ�㰴�����ҵ�˳���ӡ��ÿһ���ӡ��һ�С�
//��������ʵ��һ����������֮����˳���ӡ������������һ�а��մ����ҵ�˳���ӡ���ڶ���
//���մ��ҵ����˳���ӡ���������ٰ��մ����ҵ�˳���ӡ���������Դ����ơ�
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
	 * �������(����㲻����϶):
	 *     ��������Ƚ��ȳ���ԭ�򣬲��ö��С�ÿ�Ӷ�����ȡ��ͷ����㲢��ӡ���������ӽ�㣬
	 * ���ӽ��������β����ֱ�����н���ӡ��ϡ� 
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
		System.out.println();// ���Է���֮�����
	}

	/**
	 * �������(����)����¼ÿһ�еĳ��ȣ�������֮��ָ����
	 */
	public void printTree2(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int count = 0; // ��ǰ������Ŀ
		int nextCount = 1; // ��һ������Ŀ
		while (!queue.isEmpty()) {
			count = nextCount;
			nextCount = 0;
			// ��ӡ��ǰ�����֣���������һ������Ŀ    int length = queue.size();
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
	 * �� ֮����  ��(ZigZag)����:
	 *     һ��ջ��������洢��һ��ջ��������洢����ӡ�������������෴����
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

	// ============���Դ���==============
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

	// �������
	private void test2() {
		TreeNode node = new TreeNode(1);
		test(2, node);
	}

	// ��б
	private void test3() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		node1.left = node2;
		node2.left = node3;
		test(3, node1);
	}

	// ��б
	private void test4() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		node1.right = node2;
		node2.right = node3;
		test(4, node1);
	}

	// ��ȫ������
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
