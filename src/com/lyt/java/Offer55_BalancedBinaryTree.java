package com.lyt.java;

//��Ŀ
//	����һ�ö������ĸ���㣬�жϸ����ǲ���ƽ������������ĳ�����������������������
//�����������1����ô������һ��ƽ���������
//˼·
//	����������ȣ��������=max(��������ȣ����������)+1��
//�ڱ��������У��ж����������������Ƿ񳬹�1�������ƽ�⣬����flagΪfalse��������ʾ��
//��ƽ�⡣
public class Offer55_BalancedBinaryTree {
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	/**
	 * ÿ���ڵ����һ�νⷨ��������ƽ���������
	 */
	boolean ans = true;

	public boolean isBalanced(TreeNode root) {
		height(root);
		return ans;
	}

	public int height(TreeNode root) {
		if (root == null)
			return 0;
		int left = height(root.left);
		int right = height(root.right);
		if (Math.abs(left - right) > 1)
			ans = false;
		return Math.max(left, right) + 1;
	}
}
