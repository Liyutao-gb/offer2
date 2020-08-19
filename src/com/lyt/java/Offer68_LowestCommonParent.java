package com.lyt.java;

//��Ŀ
//	������������㣬�����ǵ���͹������ȡ�
//˼·
//	��������Ҫ�����Թ�ȷ���Ƿ�Ϊ���������õ��϶��𸴺󣬻�Ҫȷ���Ƿ�Ϊ�������������Ƿ�
//�и�ָ�룬���߽�������ͨ��������
//	1.��Ϊ����������ʱ����͹������Ƚ��Ĵ�С������������С���м䡣
//	2.��Ϊ��ͨ��ʱ��ʹ�ñ������ӽ�����Ϣ���ϴ��ݡ������������н��в����Ƿ����������
//��㣬������������ֱ������������ϣ�˵���ø����������ǵ���͹������ȡ�
public class Offer68_LowestCommonParent {
	
	/**
	 * ����������: ���ö���������
	 */
	public TreeNode getLowestCommonParentBST(TreeNode root, TreeNode p, TreeNode q) {
		while (true) {
			if (root == null)
				return root;
			if (root.val < p.val && root.val < q.val)
				root = root.right;
			else if (root.val > p.val && root.val > q.val)
				root = root.left;
			else
				return root;
		}
	}

	/**
	 * ��ͨ������: �����������Ϣ���õݹ����ϴ���
	 */
	public TreeNode getLowestCommonParent(TreeNode root, TreeNode node1, TreeNode node2) {
		if (root == null || root == node1 || root == node2)
			return root;
		TreeNode left = getLowestCommonParent(root.left, node1, node2);
		TreeNode right = getLowestCommonParent(root.right, node1, node2);
		if (left != null && right != null)
			return root;
		return left == null ? right : left;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(1);
		TreeNode node4 = new TreeNode(2);
		TreeNode node3 = new TreeNode(6);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node4.left = new TreeNode(7);
		node4.right = new TreeNode(4);
		node2.left = new TreeNode(0);
		node2.right = new TreeNode(8);
		Offer68_LowestCommonParent demo = new Offer68_LowestCommonParent();
		TreeNode node = demo.getLowestCommonParent(root, node3, node4);
		System.out.println(node.val);
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int val) {
		this.val = val;
	}
}
