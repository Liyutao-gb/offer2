package com.lyt.java;

import java.util.ArrayList;
import java.util.List;

//��Ŀ��
//	����һ�ö�������һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·���������ĸ����
//��ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
//˼·
//	ͨ��ǰ��������Ӹ���������ÿ���������д洢�������Ľ�㣬������Ҷ�ӽ�㣬���������
//���ĺ��Ƿ����������������ж��Ƿ��ӡ������ڵ�ǰ�����ʽ����󣬵ݹ麯�����᷵�ص�
//���ĸ���㣬�����ں����˳�֮ǰ��Ҫɾ�������еĵ�ǰ��㣬��ȷ�����ظ����ʱ�������·��
//�պ��ǴӸ���㵽����㡣
public class Offer34_PathInTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	/**
	 * ����һ����������һ��Ŀ��ͣ��жϸ������Ƿ���ڸ��ڵ㵽Ҷ�ӽڵ��·��������·��
	 * �����нڵ�ֵ��ӵ���Ŀ��͡�
	 * ˵��: Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		sum -= root.val;
		if (sum == 0 && root.left == null && root.right == null)
			return true;
		return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
	}

	/**
	 * 1.�����ҵ�������һ��·�����ﵽҶ��������û��ָ�򸸽���ָ�룬���Ա�����ǰ
	 * ����һ������洢ǰ�澭���Ľ�㡣
	 * 2.�����ǴӸ�������������Ҫ�뵽ʹ��ǰ����� 
	 * 3.��������洢��㣬�ڸý���������������·�������󣨼��ݹ麯�����������ص���
	 * �����֮ǰ����Ҫɾ���ý�㣬�Ӷ���¼���·����
	 */
	public void findPath(TreeNode root, int target) {
		if (root == null)
			return;

		List<Integer> list = new ArrayList<>();
		printPath(root, target, list);
	}

	private void printPath(TreeNode node, int target, List<Integer> list) {
		if (node == null)
			return;

		list.add(node.val);
		target -= node.val;
		if (target == 0 && node.left == null && node.right == null) {
			for (int i : list)
				System.out.print(i + " ");
			System.out.println();
		}
		printPath(node.left, target, list);
		printPath(node.right, target, list);
		list.remove(list.size() - 1);
	}
}