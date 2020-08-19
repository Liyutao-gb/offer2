package com.lyt.java;

import java.text.NumberFormat;

//��Ŀ
//	��n���������ڵ���,�������ӳ���һ��ĵ���֮��Ϊs������n,��ӡ��s�����п��ܵ�ֵ���ֵĸ���
//˼·
//	����n�����ӣ�Ҫ�����ÿ�ֵ����͵ĸ��ʣ�����֪��Ͷ��n�����ӵ������һ����6^n�֣�
//���ֻ��Ҫ�����ĳ�����͵����һ���м��֣���������õ���֮�͵ĸ��ʡ�
//	����һ�����ڵݹ�ķ�����Ч�ʽϵ�
//	��֪������֮��s����СֵΪn�����ֵΪ6*n��������ǿ�����һ����СΪ��6*n-n+1��������
//��Ų�ͬ����֮�͵������������ô���������֮��Ϊx����ô�������ֵ�����ܴ�������������
//�±�Ϊx-n��Ԫ���
//ȷ����δ�Ų�ͬ����֮�͵Ĵ���������Ҫ�������Щ���������ǰ�n�����ӷ�Ϊ1�����Ӻ�
//n-1�����ӣ���1�����ӿ��ܳ���1~6���������ɸ����ӵĵ��������n-1�����ӵĵ������Լ����
//�ܵ������������n-1�������ֿ��Է�Ϊ1����n-2�������ϴεĵ�����������������ӵĵ�����ӣ�
//�ٺ�ʣ�µ�n-2�����ӵĵ�����ӿ��Եõ��ܵ����������������õݹ�ʵ�֡��ڻ�����һ�����ӵ�
//��������Լ�����������ӵ��ܵ������������и��ܵ������������+1�����ɽ���������
//	������������ѭ�������ӵ�����ʱ�����ܺ�
//	��������ÿ�����ӵ����ͳ��ֵĴ��������������±�Ϊn��Ԫ�ش�ŵ�����Ϊn�Ĵ���������
//����ѭ����ÿ��ѭ����Ͷ��һ�����ӣ�����ĳһ��ѭ���У�������֪�˸��ֵ����ͳ��ֵĴ�������
//��һ��ѭ��ʱ��������Ͷ����һ�����ӣ���ô��ʱ������Ϊn��������ֵĴ����͵�����һ�ֵ�����
//Ϊn-1,n-2,n-3,n-4,n-5,n-6��������ִ������ܺ͡��ӵ�һ�����ӿ�ʼ��ѭ��n�Σ��Ϳ������
//��n������ʱ���ֵ����ͳ��ֵĴ�����
//���������������������ֱ��ű���ѭ������һ��ѭ���ĸ��ֵ����ͳ��ֵĴ��������Ͻ���ʹ�á�
public class Offer60_DicesProbability {
	private static final int maxValue = 6;

	/**
	 * ����һ���ݹ�ⷨ
	 */
	public static void printProbability1(int number) {
		if (number <= 0)
			return; // ����
		
		int[] probabilities = new int[maxValue * number - number + 1];
		// �±�Ϊi����Ӧ��ֵ�������֮��Ϊi+number�ܹ����ֵ��������
		// ������number~maxValue*number�����������СΪ6*number-number+1
		for (int i = 0; i < probabilities.length; i++)
			probabilities[i] = 0;

		// ���㲻ͬ�������ֵĴ���
		for (int i = 1; i <= maxValue; i++)
			calP(probabilities, number, number - 1, i); // ��һ�������ӣ��ܵ���ֻ����1~maxValue(��6)

		int totalP = (int) Math.pow(maxValue, number); // ��������ܹ����ֵĴ���
		for (int i = 0; i < probabilities.length; i++) {
			double ratio = (double) probabilities[i] / totalP;
			NumberFormat format = NumberFormat.getPercentInstance();
			format.setMaximumFractionDigits(2);// ���ñ�����λС��
			System.out.println("������Ϊ" + (i + number) + "�ĸ���Ϊ:" + format.format(ratio));
		}
	}

	/**
	 * ����ÿ�ֵ������ֵĴ���
	 * 
	 * @param number:�����ܸ���
	 * @param curNumber:��ǰʣ�����Ӹ���
	 * @param sum:�������Ӽ��������ܵ���
	 */
	private static void calP(int[] probabilities, int number, int curNumber, int sum) {
		if (curNumber == 0) {
			probabilities[sum - number]++; // ����Ϊsum����������sum-number�±���
			return;
		}
		for (int i = 1; i <= maxValue; i++)
			calP(probabilities, number, curNumber - 1, sum + i); // �൱��ʣ���������һ�����ܵ������ӡ�
	}

	// ===========================================
	/**
	 * ������������ѭ�������ӵ�����ʱ�����ܺ�
	 */
	public static void printProbability2(int number) {
		if (number <= 0)
			return; // ����
		int[][] probabilities = new int[2][number * maxValue + 1];
		// [2]�������������齻�汣�棬[number*maxValue+1]��ָ����Ϊ�����±�ʱ���õ������ֵ��ܴ�����
		// probabilities[*][0]��û�õģ�ֻ��Ϊ�����±��Ӧ����
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < number * maxValue; j++) {
				probabilities[i][j] = 0;
			}
		}

		for (int i = 1; i <= 6; i++)
			probabilities[0][i] = 1; // ��һ�����ӳ��ֵ����

		int flag = 0;
		for (int curNumber = 2; curNumber <= number; curNumber++) { // ��ǰ�ǵڼ�������
			for (int i = 0; i < curNumber; i++)
				probabilities[1 - flag][i] = 0; // ǰ�����������

			for (int i = curNumber; i <= curNumber * maxValue; i++) {
				for (int j = 1; j <= 6 && j <= i; j++) {
					probabilities[1 - flag][i] += probabilities[flag][i - j];
				}
			}
			flag = 1 - flag;

		}

		int totalP = (int) Math.pow(maxValue, number); // ��������ܹ����ֵĴ���
		for (int i = number; i <= number * 6; i++) {
			double ratio = (double) probabilities[flag][i] / totalP;
			NumberFormat format = NumberFormat.getPercentInstance();
			format.setMaximumFractionDigits(8);// ���ñ�����λС��
			System.out.println("������Ϊ" + (i + number) + "�ĸ���Ϊ:" + format.format(ratio));
		}
	}

	public static void main(String[] args) {
		System.out.println("=========����һ============");
		for (int i = 0; i <= 3; i++) {
			System.out.println("-----������Ϊ" + i + "ʱ-----");
			printProbability1(i);
		}
		System.out.println("-----������Ϊ" + 11 + "ʱ-----");
		printProbability1(11);

		System.out.println("=========������============");
		for (int i = 0; i <= 3; i++) {
			System.out.println("-----������Ϊ" + i + "ʱ-----");
			printProbability2(i);
		}
		System.out.println("-----������Ϊ" + 11 + "ʱ-----");
		printProbability1(11);
	}
}
