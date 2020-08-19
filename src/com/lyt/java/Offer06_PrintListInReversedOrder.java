package com.lyt.java;

import java.util.Stack;

// ����һ�������ͷ��㣬��β��ͷ��������ӡ��ÿ������ֵ��
public class Offer06_PrintListInReversedOrder {
	class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
	
	// ����ջ
    public void printListReversingly_Iteratively(ListNode node) {
    	Stack<ListNode> stack = new Stack<>();
    	while (node != null) {
			stack.push(node);
			node = node.next;
		}
    	while (!stack.isEmpty()) {
			System.out.println(stack.pop().val);
		}
    }
	
    //���õݹ�
    public void printListReversingly_Recursively(ListNode node) {
    	if(node == null)
    		return;
    	printListReversingly_Recursively(node.next);
    	System.out.println(node.val);
    }
    
    /**
     * ����Ϊ��
     */
    public void test1() {
        ListNode aListNode = null;
        System.out.println("���������ջ��");
        printListReversingly_Iteratively(aListNode);
        System.out.println("��������õݹ飺");
        printListReversingly_Recursively(aListNode);
    }
     
    /**
     * ����������
     */
    public void test2() {
        ListNode ListNode1 = new ListNode(1);
        ListNode ListNode2 = new ListNode(2);
        ListNode ListNode3 = new ListNode(3);
        ListNode ListNode4 = new ListNode(4);
        ListNode ListNode5 = new ListNode(5);
        ListNode1.next=ListNode2;
        ListNode2.next=ListNode3;
        ListNode3.next=ListNode4;
        ListNode4.next=ListNode5;
        System.out.println("����ջ��");
        printListReversingly_Iteratively(ListNode1);
        System.out.println("���õݹ飺");
        printListReversingly_Recursively(ListNode1);
    }
     
    /**
     * �����������
     */
    public void test3() {
        ListNode ListNode1 = new ListNode(1);
        System.out.println("һ���ڵ��������ջ��");
        printListReversingly_Iteratively(ListNode1);
        System.out.println("һ���ڵ�������õݹ飺");
        printListReversingly_Recursively(ListNode1);
    }
     
    public static void main(String[] args) {
    	Offer06_PrintListInReversedOrder demo = new Offer06_PrintListInReversedOrder();
        System.out.println("test1:");
        demo.test1();
        System.out.println("test2:");
        demo.test2();
        System.out.println("test3:");
        demo.test3();
    }
}
