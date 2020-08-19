package com.lyt.java;

//题目
//	给定一个数组A[0, 1, …, n-1]，请构建一个数组B[0, 1, …, n-1]，其中B中的元素
//B[i] =A[0]×A[1]×… ×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
//思路
//	无法使用除法，正常连乘的话时间复杂度为O(n^2)，效率非常低。
//	考虑到计算每个B[i]时都会有重复，思考B[i]之间的联系，找出规律，提高效率。
public class Offer66_ConstuctArray {
	public int[] multiply(int[] A) {
		if (A == null || A.length < 2)
			return null;

		int[] B = new int[A.length];
		B[0] = 1;
		for (int i = 1; i < A.length; i++)
			B[i] = B[i - 1] * A[i - 1];
		int temp = 1;
		for (int i = A.length - 2; i >= 0; i--) {
			temp *= A[i + 1];
			B[i] *= temp;
		}
		return B;
	}

	public static void main(String[] args) {
		Offer66_ConstuctArray demo = new Offer66_ConstuctArray();
		int[] A = new int[] {};
		int[] multiply = demo.multiply(A);
		System.out.println(multiply.toString());
	}
}
