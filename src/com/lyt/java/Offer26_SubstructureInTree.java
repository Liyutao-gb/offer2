package com.lyt.java;

//��Ŀ��
//	�������ö�����A��B���ж�B�ǲ���A���ӽṹ(���м���)��
//˼·
//	1���ȶ�A�����б������ҵ���B���ĸ����ֵ��ͬ�Ľ��R��
//	2���ж�A������RΪ�����������Ƿ����B��һ���Ľṹ��
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
	 * �����򣬶�ÿ���������ж�
	 */
	public boolean hasSubtree(TreeNode root1, TreeNode root2) {
		if (root1 == null || root2 == null)
			return false;
		return doesTree1HasTree2(root1, root2) || hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
	}

	/**
	 * �ж�root��㿪ʼ�������и�������Ƿ���ͬ
	 */
	private boolean doesTree1HasTree2(TreeNode root1, TreeNode root2) {
		if (root2 == null) // root2�����޽��,���ü��������ж���,���ؼ���
			return true;
		if (root1 == null)
			return false;
		if (root1.val != root2.val)
			return false;
		return doesTree1HasTree2(root1.left, root2.left) && doesTree1HasTree2(root1.right, root2.right);
	}
}
