package com.lyt.java;

//��Ŀ
//	����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ�������
//��������Ľ���ж������ظ������֡���������ǰ���������{1, 2, 4, 7, 3, 5, 6, 8}
//�������������{4, 7, 2, 1, 5, 3, 8, 6}�����ؽ�������������������ͷ���
//˼·
//	ǰ�������һ��ֵ���Ǹ�����ֵ�����ݸ�ֵ�����������λ�ã����������ҳ��ø��������
//������ǰ����������������֮���ֿ�����ͬ�����������������������Ը�����Բ��õݹ�ķ�
//����ɡ�
//	�տ�ʼ˼����ʱ������ǹ���һ����������������Ϊǰ���������������飬���Ϊ����㡣
//���������Ļ�ÿ�ζ���Ҫ�������������飬�ǳ��鷳��
//֮���뵽���ú��������벻һ��Ҫ�����飬��Ϊ�����ǰ���������������Ѿ����ˣ�
//��ֱ���ø�������±�����ʾ���������鼴�ɡ�
//����������construct(int[] pre, int[] in, int pStart, int pEnd, int iStart, 
//int iEnd)��pre��inʼ�������ǰ����������������������룬pStart��pEnd����ǰ����
//ǰ�����鿪ʼ�ͽ���λ�ã�iStart��iEnd�����������鿪ʼ�ͽ���λ�á�
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
			throw new RuntimeException("���鲻���Ϲ淶��");
		
		return construct(pre, in, 0, pre.length - 1, 0, in.length - 1);
	}

	/**
	 * @Description ��ǰ��������к�����������еõ������ pre��in��ʼ���������ǰ��
	 * 				��������������������pStart��pEnd����ǰ����ǰ�����鿪ʼ�ͽ���
	 * 				λ�� iStart��iEnd���������鿪ʼ�ͽ���λ��
	 */
	public TreeNode construct(int[] pre, int[] in, int pStart, int pEnd, int iStart, int iEnd) {
		TreeNode root = new TreeNode(pre[pStart]);
		if (pStart == pEnd && iStart == iEnd) { // ֻ��һ����������
			if (pre[pStart] != in[iStart])
				throw new RuntimeException("���鲻���Ϲ淶��");
			return root;
		}
		int index = iStart; // ���ڼ�¼������������и�����λ��
		while (root.val != in[index] && index <= iEnd) {
			index++;
		}
		if (index > iEnd)
			throw new RuntimeException("���鲻���Ϲ淶��");// ���������Ҳ��������
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
	 * ����������
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
	 * ��б��
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
	 * ��б��
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
	 * �������
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
	 * ����Ϊ��
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