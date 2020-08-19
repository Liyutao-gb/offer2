package com.lyt.java;

import java.util.LinkedList;

//��Ŀ
//	0, 1, ��, n-1��n�������ų�һ��ԲȦ��������0��ʼÿ�δ����ԲȦ��ɾ����m�����֡�
//������ԲȦ��ʣ�µ����һ�����֡�
//˼·
//	����һ������������������ݣ�ÿ�ζԳ���ȡ����ʵ��ѭ��
//	���������ַ���LinkedList�����У�LinkedList��ArrayList���ʺ���ɾ�����������赱ǰɾ��
//�Ľ���±�ΪremoveIndex������һ��Ҫɾ���Ľ����±�Ϊ��(removeIndex+m-1)%list.size()
//ͨ��ȡ����ſ���ʵ������ѭ���Ĳ�����
//ע��û��Ҫ��ѭ��������������鷳�ˡ�
//	����������ѧ�Ƶ�����
//	n�����ֵ�ԲȦ������ɾ����m�����֣����ǰ����ʣ�µ����ּ�Ϊf(n,m)��
//n�������е�һ����ɾ����������(m-1)%n�� ���Ǽ���k��k=(m-1)%n��
//��ôʣ�µ�n-1�����־ͱ���ˣ�0,1,����k-1,k+1,����,n-1�����ǰ���һ�ֵ�һ������������ǰ�棬
//���ҽ��������Ϊn-1������ӳ�䵽0~n-2��
//ԭʼ���֣�k+1,����,   n-1,       0,    1,����k-1
//ӳ�����֣�0    ,����,n-k-2, n-k-1, n-k,����n-2
//��ӳ�����ּ�Ϊx��ԭʼ���ּ�Ϊy����ôӳ�����ֱ��ԭʼ���ֵĹ�ʽΪ y=(x+k+1)%n��
//��ӳ�������У�n-1�����֣�����ɾ����m�����֣��ɶ������֪�������ʣ�µ�����Ϊf(n-1,m)��
//���ǰ������ԭʼ���֣�����һ����ʽ���Եõ����ʣ�µ�ԭʼ�����ǣ�f(n-1,m)+k+1)%n��
//��������־���Ҳ����һ��ʼ���Ǳ��Ϊ��f(n,m)�����Կ����Ƶõݹ鹫ʽ���£�
//����������������f(n,m) =��f(n-1,m)+k+1)%n
//��k=(m-1)%n���룬����õ���
//����������������f(n,m) =��f(n-1,m)+m)%n
//����������������f(1,m) = 0
//�����п��Բ���ѭ�����ߵݹ�ķ���ʵ�ָõݹ鹫ʽ��ʱ�临�Ӷ�ΪO(n)���ռ临�Ӷ�ΪO(1)��
public class Offer62_LastNumberInCircle {
	/*
	 * ����һ�������Ƶ������ķ��� 0,1,2 ... n - 1
	 */
	public int LastRemaining_Solution(int n, int m) {
		if (n < 1 || m < 1)
			return -1; // ����

		int last = 0;
		for (int i = 2; i <= n; i++) {
			last = (last + m) % i; // ������i����n!!!
		}
		return last;
	}

	/*
	 * ��������������������ţ�ÿ�ζԳ���ȡ����ʵ��ѭ��
	 */
	public int LastRemaining_Solution2(int n, int m) {
		if (n < 1 || m < 1)
			return -1; // ����

		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < n; i++)
			list.add(i);
		
		int removeIndex = 0;
		while (list.size() > 1) {
			removeIndex = (removeIndex + m - 1) % list.size();
			list.remove(removeIndex);
		}
		return list.getFirst();
	}

	public static void main(String[] args) {
		Offer62_LastNumberInCircle demo = new Offer62_LastNumberInCircle();
		int remaining = demo.LastRemaining_Solution(5, 3);
		int remaining2 = demo.LastRemaining_Solution2(5, 3);
		System.out.println(remaining == remaining2);
	}
}
