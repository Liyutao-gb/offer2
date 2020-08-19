package com.lyt.java;

import java.util.Stack;

// 输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
public class Offer06_PrintListInReversedOrder {
	class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
	
	// 采用栈
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
	
    //采用递归
    public void printListReversingly_Recursively(ListNode node) {
    	if(node == null)
    		return;
    	printListReversingly_Recursively(node.next);
    	System.out.println(node.val);
    }
    
    /**
     * 链表为空
     */
    public void test1() {
        ListNode aListNode = null;
        System.out.println("空链表采用栈：");
        printListReversingly_Iteratively(aListNode);
        System.out.println("空链表采用递归：");
        printListReversingly_Recursively(aListNode);
    }
     
    /**
     * 多个结点链表
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
        System.out.println("采用栈：");
        printListReversingly_Iteratively(ListNode1);
        System.out.println("采用递归：");
        printListReversingly_Recursively(ListNode1);
    }
     
    /**
     * 单个结点链表
     */
    public void test3() {
        ListNode ListNode1 = new ListNode(1);
        System.out.println("一个节点链表采用栈：");
        printListReversingly_Iteratively(ListNode1);
        System.out.println("一个节点链表采用递归：");
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
