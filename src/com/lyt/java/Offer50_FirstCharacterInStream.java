package com.lyt.java;

//��Ŀ��
//	��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ������磬�����ַ�����ֻ����ǰ
//�����ַ�"go"ʱ����һ��ֻ����һ�ε��ַ���'g'�����Ӹ��ַ����ж���ǰ�����ַ�"google"ʱ��
//��һ��ֻ����һ�ε��ַ���'l'��
//˼·
//	�ַ�ֻ��һ��һ�����ַ����ж����������Ҫ����һ�������������ַ��Լ������ַ����е�λ�á�
//Ϊ�����ܸ�Ч������⣬Ҫ��O(1)ʱ���������������в����ַ��������Ӧ��λ�ã�����������
//���������ù�ϣ����ʵ�֣����ַ���ASCII����Ϊ��ϣ��ļ�ֵkey���ַ���Ӧ��λ����Ϊ��ϣ���
//ֵvalue��
//	��ʼʱ����ϣ���ֵ����ʼ��Ϊ-1������ȡ��ĳ���ַ�ʱ����λ�ô���value�У����֮ǰ��ȡ��
//���ַ�����value>=0������value��ֵΪ-2�������ظ����ֹ������Թ�ϣ���������value>=0��
//��ֵ�����ҵ���С��value����value��Ϊ��һ��ֻ����һ�ε��ַ���ASCII��Ϊkey���ַ���Ϊ����
//�ַ���
public class Offer50_FirstCharacterInStream {
	private int index;
	private int[] occurence;

	public Offer50_FirstCharacterInStream() { // �ڹ��캯���г�ʼ����Ա����
		index = 0;
		occurence = new int[256];
		for (int i = 0; i < 256; i++) {
			occurence[i] = -1;
		}
	}

	public void insert(char ch) {
		if (occurence[(int) ch] == -1) {
			occurence[(int) ch] = index; // ��һ�γ���
		} else if (occurence[(int) ch] >= 0) {
			occurence[(int) ch] = -2; // �Ѿ����ֹ���
		}
		index++;
	}

	public char getFirst() {
		int minIndex = Integer.MAX_VALUE; // ����integer
		char ch = '#';
		for (int i = 0; i < 256; i++) {
			if (occurence[i] >= 0 && occurence[i] < minIndex) {
				ch = (char) i;
				minIndex = occurence[i];
			}
		}
		return ch;
	}
}
