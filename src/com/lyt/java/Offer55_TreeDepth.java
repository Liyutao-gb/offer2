package com.lyt.java;

//��Ŀ
//	����һ�ö������ĸ���㣬���������ȡ��Ӹ���㵽Ҷ������ξ�����/��㣨������Ҷ��㣩
//�γ�����һ��·�����·���ĳ���Ϊ������ȡ�
//˼·
//	�����⣺������� = max(��������ȣ����������) + 1�����õݹ�ʵ�֡�
public class Offer55_TreeDepth {
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public int treeDepth(TreeNode root) {
		if (root == null)
			return 0;
		int left = treeDepth(root.left);
		int right = treeDepth(root.right);
		return Math.max(left, right) + 1;
		// return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
	}
}
