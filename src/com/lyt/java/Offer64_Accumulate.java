package com.lyt.java;

//��Ŀ
//	��1+2+��+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ�����
//�ж���䣨A?B:C����
//˼·
//	����ʹ�ó˳���������ʹ��ѭ����䡢�ж���䡣���Կ��ǵ���   ��Ŀ�������++��--,
//˫Ŀ�������+,-����λ�����<<��>>����ϵ�����>,<�ȣ��߼������&&��||,&,|,^����ֵ= 
//���п���ʹ�õ��ľ����߼�������ˡ�����ǵ������ж�·���ԵĻ����Ϳ��Ե���if��ʹ�á�
//	���磺����A && B�����AΪ�٣���ô�Ͳ�ִ��B�ˣ������AΪ�棬�ͻ�ִ��B��
//������A || B�����AΪ�棬��ô�ͻ᲻ִ��B�ˣ������AΪ�٣��ͻ�ִ��B��
//�������ʹ�õݹ�������ѭ�������߼������&&����||�������ж���䡣
//����ʵ�ֹ���Ϊ����n����1ʱ����Ϊf(n)=f(n-1)+n��n=1ʱ��f(n)=1
public class Offer64_Accumulate {
	public int getSum(int n) {
		boolean flag = (n > 1) && ((n += getSum(n - 1)) > 0);
		// boolean flag = (n == 1) || ((n += getSum(n - 1)) > 0);

		// ������仰�൱�����棺�����õݹ�������ѭ��)
		// if (n > 1)
		// 		n += getSum(n - 1);
		return n;
	}

	public static void main(String[] args) {
		Offer64_Accumulate demo = new Offer64_Accumulate();
		int sum = demo.getSum(5);
		System.out.println(sum);
	}
}
