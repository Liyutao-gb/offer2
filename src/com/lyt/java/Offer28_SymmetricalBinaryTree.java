package com.lyt.java;

import java.util.LinkedList;
import java.util.Queue;
//��Ŀ��
//	��ʵ��һ�������������ж�һ�ö������ǲ��ǶԳƵġ����һ�ö����������ľ���һ������ô
//���ǶԳƣ�Symmetry���ġ�
//˼·
//	���ǻ�ͼ���������÷�������㣬ֻ��Ҫ�����������������Կ��������������պ��ǳʾ���
//�����Ŷ����������ԣ������������ã���-��-�ң���ǰ����������������ã���-��-�󣩵�ǰ��
//����������ʱ�ж��������λ�õ�ֵ�Ƿ���ȼ��ɡ���Ҳ����������⣺��������������������
//������������������������������������������Ӧλ�øպ��෴���ж��������෴λ���ϵ�ֵ��
//����ȼ��ɣ�
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
	 * 1.���ڵ�Ϊ��,Ĭ���ǶԳƵ�;
	 * 2.���ڵ㲻Ϊ�ա�
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
	
	// ����
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
