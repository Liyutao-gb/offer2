package com.lyt.java;

//��Ŀ��
//	����һ������n�����1��n��n��������ʮ���Ʊ�ʾ��1���ֵĴ�������������12����1��12��Щ
//�����а���1 ��������1��10��11��12��1һ��������5�Ρ�
//˼·
//	����Ǵ�ͷ��β����(n��)����ÿһ�����ֶ�������1�ĸ�����lgn�Σ�����ʱ�临�Ӷ�ΪO(nlogn)
//,����Ч��̫�͡���˱����ܽ���ɣ����Ч�ʡ�
//	�ܽ�������£�˼·�ȡ���ָOFFER��һ��򵥣���
//	��������n�����ǽ����������Ϊ�����֣���ǰλ����cur������λ����high������λ����low��
//�磺����n=21034����λ����ʮλʱ��cur=3��high=210��low=4��
//	���ǴӸ�λ�����λ ���μ���ÿ��λ�ó���1�Ĵ�����
//	1����ǰλ�����ֵ���0ʱ������n=21034���ڰ�λ�ϵ�����cur=0����λ����1�����
//�У�00100~00199��01100~01199��������20100~20199��һ����21*100���������high*100;
//	2����ǰλ�����ֵ���1ʱ������n=21034����ǧλ�ϵ�����cur=1��ǧλ����1�����
//�У�01000~01999��11000~11999��21000~21034��һ����2*1000+��34+1���������
//��high*1000+(low+1)��
//	3����ǰλ�����ִ���1ʱ������n=21034����ʮλ�ϵ�����cur=3��ʮλ����1�����
//�У�00010~00019��������21010~21019��һ���У�210+1��*10���������(high+1)*10��
//�������ֻ��Ҫ����ÿ��λ������������n����λ��һ����lgn��������ʱ�临�Ӷ�ΪO(logn)��
public class Offer43_NumberOf1 {
	/**
	 * �ⷨһ����ͨ�ⷨ
	 */
	public int numberOf1Between1AndN_Solution1(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			count += NumberOf1(i);
		}
		return count;
	}
	
	private int NumberOf1(int n) {
		int count = 0;
		while (n != 0) {
			if(n % 10 == 1)
				count++;
			n /= 10;
		}
		return count;
	}
	
	/**
	 * �ⷨ�����ҹ���
	 */
	public int numberOf1Between1AndN_Solution2(int n) {
		int count = 0;
		for (long i = 1; i <= n; i *= 10) { // i����ڼ�λ��
			long high = n / (i * 10);// ��λ����
			long cur = (n / i) % 10; // ��ǰλ����
			long low = n % i; 		// ��λ����
			if (cur == 0) {		
				count += high * i;
			} else if (cur == 1) {
				count += high * i + (low + 1);
			} else {
				count += (high + 1) * i;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Offer43_NumberOf1 demo = new Offer43_NumberOf1();
		int i1 = demo.numberOf1Between1AndN_Solution2(12);
		int i2 = demo.numberOf1Between1AndN_Solution1(12);
		System.out.println(i1 == 5);
		System.out.println(i2 == 5);
	}
}
