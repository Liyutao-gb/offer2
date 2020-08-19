package com.lyt.java;

//��Ŀ��
//	����һ�����֣����ǰ������¹����������Ϊ�ַ�����0�����"a"��1�����"b"��������
//11�����"l"��������25�����"z"��һ�����ֿ����ж�����롣����12258��5�ֲ�ͬ�ķ��룬
//���Ƿֱ�"bccfi", "bwfi", "bczi", "mcfi" ��"mzi" ������ʵ��һ��������������һ��
//�����ж����ֲ�ͬ�ķ��뷽����
//˼·
//	������Ŀ���������뵽ʹ�õݹ飺��f(i)����ʾ�ӵ�iλ��ʼ�Ĳ�ͬ������Ŀ�����Եõ��У�
//f(i)=f(i+1)+g(i,i+1)*f(i+2)��i��i+1λ����ƴ������10~25��Χ��ʱg(i,i+1)��ֵΪ1��
//����Ϊ0��
//���Ǵ����ظ��������⣬���Եݹ鲢����ѷ��������Ǵ����ֵ�ĩβ��ʼ����f(i)�����¶���
//������⣬�Ϳ��������ظ����������ˡ�����f(len-1)��f(len-2)���ٸ��ݹ�ʽ
//f(i)=f(i+1)+g(i,i+1)*f(i+2)��ǰ���Ƶ���f(0)�����������Ҫ��Ľ����
public class Offer46_TranslateNumbersToStrings {
	public int getTranslationCount(int number) {
		if (number < 0)
			return 0;

		String sNumber = String.valueOf(number);
		int len = sNumber.length();
		int[] counts = new int[len];
		counts[len - 1] = 1;
		for (int i = len - 2; i >= 0; i--) {
			counts[i] = counts[i + 1];
			if (canBeTrans(sNumber, i)) {
				if (i == len - 2) {
					counts[i] += 1;
				} else {
					counts[i] += counts[i + 2];
				}
			}
		}
		return counts[0];
	}

	private boolean canBeTrans(String sNumber, int i) {
		int a = sNumber.charAt(i) - '0';
		int b = sNumber.charAt(i + 1) - '0';
		int convert = a * 10 + b;
		return convert >= 10 && convert <= 25;// ��10��25��Χ����һ����ĸ
	}

	public static void main(String[] args) {
		Offer46_TranslateNumbersToStrings demo = new Offer46_TranslateNumbersToStrings();
		System.out.println(demo.getTranslationCount(12258) == 5);
		System.out.println(demo.getTranslationCount(0) == 1);
		System.out.println(demo.getTranslationCount(10) == 2);
		System.out.println(demo.getTranslationCount(101) == 2); // 01 ֻ�ܷ���Ϊa,b
	}
}
