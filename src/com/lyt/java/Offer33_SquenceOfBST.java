package com.lyt.java;

//��Ŀ��
//	����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����������򷵻�true��
//���򷵻�false���������������������������ֶ�������ͬ��
//˼·
//	���������������������һ����Ϊ����㣬ʣ�������У�С�ڸ��������֣������������֣�
//������ǰ�棬���ڸ��������֣������������֣������ں��档���ݱ��������������ԣ�����
//��д��һ���ݹ麯��������ʵ����Ŀ��Ҫ����жϹ��ܡ�
public class Offer33_SquenceOfBST {
	/**
	 * ����������֤��
	 * 	1.�ж������� 
	 * 	2.�ж������� 
	 * 	3.�ݹ���ж���������
	 */
	public boolean verifySquenceOfBST(int[] sequence) {
		if (sequence == null || sequence.length <= 0)
			throw new RuntimeException("���벻�Ϸ�");
		return verifyCore(sequence, 0, sequence.length - 1);
	}
	
	private boolean verifyCore(int[] sequence, int start, int end) {
		if (start >= end)
			return true;
		int mid = start;
		while (sequence[mid] < sequence[end])
			mid++;
		for (int i = mid; i < end; i++) {
			if (sequence[i] < sequence[end])
				return false;
		}
		return verifyCore(sequence, start, mid - 1) && verifyCore(sequence, mid, end - 1);
	}
	
//	ǰ��������֤
//	private boolean verifyCore(int[] sequence, int start, int end) {
//		if (start + 1 >= end)
//			return true;
//		int mid = start + 1;
//		while (sequence[mid] < sequence[start])
//			mid++;
//		for (int i = mid; i <= end; i++) {
//			if (sequence[i] < sequence[start])
//				return false;
//		}
//		return verifyCore(sequence, start + 1, mid - 1) && verifyCore(sequence, mid, end);
//	}

	public static void main(String[] args) {
		Offer33_SquenceOfBST demo = new Offer33_SquenceOfBST();
		boolean bst = demo.verifySquenceOfBST(new int[] {  5, 7, 6, 9, 11, 10, 8 });
//		boolean bst1 = demo.verifySquenceOfBST(new int[] {  8,5, 7, 6, 9, 11, 10 });
		System.out.println("�����������֤��" + bst);
//		System.out.println("ǰ���������֤��" + bst1);
	}
}
