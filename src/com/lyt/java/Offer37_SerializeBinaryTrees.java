package com.lyt.java;

import java.util.LinkedList;
import java.util.Queue;
//题目　
//	请实现两个函数，分别用来序列化和反序列化二叉树。
//思路
//	   一般情况下，需要采用前/后序遍历和中序遍历才能确定一个二叉树，但是其实可以只采用
//前序遍历（从根结点开始），将空结点(null)输出为一个特殊符号（如“$”），就可以确定一个
//二叉树了。
//	将二叉树序列化为字符串，就是前序遍历的过程，遇见空结点时，序列化为“$”，每个结点间
//使用逗号分隔开。
//	将字符串反序列化为二叉树，也使用前序遍历，遇见一个新数字(或者$)就建立一个新结点，
//不过需要注意的是，数字可能不只是个位数字，因此创建了一个全局Int变量index（在字符串上
//的移动的指针），以便于截取字符串中当前的结点值。
public class Offer37_SerializeBinaryTrees {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	// 序列化
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
			index++; // 这条语句位置别放错
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
		// 序列化
		String string = demo.serialize(root);
		System.out.println("前序序列化：" + string);
	}
}
