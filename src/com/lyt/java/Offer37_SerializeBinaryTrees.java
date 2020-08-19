package com.lyt.java;

import java.util.LinkedList;
import java.util.Queue;
//��Ŀ��
//	��ʵ�������������ֱ��������л��ͷ����л���������
//˼·
//	   һ������£���Ҫ����ǰ/��������������������ȷ��һ����������������ʵ����ֻ����
//ǰ��������Ӹ���㿪ʼ�������ս��(null)���Ϊһ��������ţ��硰$�������Ϳ���ȷ��һ��
//�������ˡ�
//	�����������л�Ϊ�ַ���������ǰ������Ĺ��̣������ս��ʱ�����л�Ϊ��$����ÿ������
//ʹ�ö��ŷָ�����
//	���ַ��������л�Ϊ��������Ҳʹ��ǰ�����������һ��������(����$)�ͽ���һ���½�㣬
//������Ҫע����ǣ����ֿ��ܲ�ֻ�Ǹ�λ���֣���˴�����һ��ȫ��Int����index�����ַ�����
//���ƶ���ָ�룩���Ա��ڽ�ȡ�ַ����е�ǰ�Ľ��ֵ��
public class Offer37_SerializeBinaryTrees {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	// ���л�
	public String serialize(TreeNode node) {
		StringBuilder sb = new StringBuilder();
		if (node == null) {
			sb.append("$,");
		} else {
			sb.append(node.val + ",");
			sb.append(serialize(node.left));
			sb.append(serialize(node.right));
		}
		return sb.toString();
	}

//	public String serialize1(TreeNode node) {
//		if (node == null)
//			return "$,";
//		String s = node.val + ",";
//		s += serialize1(node.left);
//		s += serialize1(node.right);
//		return s;
//	}

	int index = 0;

	public TreeNode deSerialize(String str) {
		if (str == null || str.length() == 0)
			return null;

		TreeNode node = null;
		int start = index;
		while (str.charAt(index) != ',')
			index++;
		if (!str.substring(start, index).equals("$")) {
			node = new TreeNode(Integer.parseInt(str.substring(start, index)));
			index++; // �������λ�ñ�Ŵ�
			node.left = deSerialize(str);
			node.right = deSerialize(str);
		} else {
			index++;
		}
		return node;
	}

//	public TreeNode deSerialize1(String data) {
//		String[] val = data.split(",");
//		Queue<String> queue = new LinkedList<>();
//		for (String s: val) {
//			queue.add(s);
//		}
//		return reconPreOrder(queue);
//	}
//
//	public TreeNode reconPreOrder(Queue<String> queue) {
//		String val = queue.poll();
//		if (val.equals("#"))
//			return null;
//		TreeNode node = new TreeNode(Integer.parseInt(val));
//		node.left = reconPreOrder(queue);
//		node.right = reconPreOrder(queue);
//		return node;
//	}

	public static void main(String[] args) {
		Offer37_SerializeBinaryTrees demo = new Offer37_SerializeBinaryTrees();
		TreeNode root = demo.deSerialize("1,2,$,$,3,$,$,");
		// ���л�
		String string = demo.serialize(root);
		System.out.println("ǰ�����л���" + string);
	}
}
