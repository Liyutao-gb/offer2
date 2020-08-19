package com.lyt.java;

//��Ŀ
//	����һ������A[0, 1, ��, n-1]���빹��һ������B[0, 1, ��, n-1]������B�е�Ԫ��
//B[i] =A[0]��A[1]���� ��A[i-1]��A[i+1]������A[n-1]������ʹ�ó�����
//˼·
//	�޷�ʹ�ó������������˵Ļ�ʱ�临�Ӷ�ΪO(n^2)��Ч�ʷǳ��͡�
//	���ǵ�����ÿ��B[i]ʱ�������ظ���˼��B[i]֮�����ϵ���ҳ����ɣ����Ч�ʡ�
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
