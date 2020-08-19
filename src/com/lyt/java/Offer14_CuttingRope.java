package com.lyt.java;

//��Ŀ
//	����һ������Ϊn���ӣ�������Ӽ���m�Σ�m��n����������n��1����m��1����ÿ�ε����ӵĳ�
//�ȼ�Ϊk[0]��k[1]��������k[m]��k[0]*k[1]*��*k[m]���ܵ����˻��Ƕ��٣����統���ӵĳ���
//��8ʱ���ǰ������ɳ��ȷֱ�Ϊ2��3��3�����Σ���ʱ�õ����ĳ˻�18��
//˼·
//	������ö�̬�滮����̰���㷨����ʵ�֡�һ��ʼû��˼·ʱ�����ԴӼ򵥵������ʼ�룬����
//�����±Ƚ϶̵���������μ��ġ�
//��n=1ʱ�����˻�ֻ��Ϊ0��
//��n=2ʱ�����˻�ֻ��Ϊ1��
//��n=3ʱ�����˻�ֻ��Ϊ2��
//��n=4ʱ�����Է�Ϊ���¼������:1*1*1*1��1*2*1��1*3��2*2�����˻�Ϊ4��
//������ʱ������n��4ʱ�����԰������ɼ���С���⣬��������ѳ���n���ӵ����˻���Ϊf(n)��
//���У�f(n)=max(f(i)*f(n-1))��0<i<n������˼·�ͺ����׳����ˣ����������ƣ�����С����
//�⣬���������⣬�������ͨ��Ѱ��С�����������ϵõ���
//	��ʵ����Ƕ�̬�滮���������Ƕ�̬�滮���ļ����ص㣺
//1.��һ����������Ž�
//2.������������Ž�����������������Ž�
//3.С����֮�仹���໥�ص��ĸ�С��������
//4.Ϊ�˱���С������ظ���⣬���ô������·����ʹ����������ķ����������
//̰���㷨��������ѧ֤���������Ӵ���5ʱ��������ؼ�������Ϊ3�����������Ž�,��ʣ4���ü���
public class Offer14_CuttingRope {
	/**
	 * ��̬�滮
	// ���漸�����ǳ˻�����Ϊ�䱾���ȱȳ˻���
	// ��ʼ���µ��ϼ��㳤��Ϊi���ӵ����˻�ֵproduct[i]
	// �㲻ͬ�ӳ��ȵĳ˻����ҳ����ĳ˻�
	 */
	public int maxProductAfterCutting_solution1(int length) {
        if (length <= 1)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;
        int[] product = new int[length + 1]; // ���ڴ�����˻�ֵ
        product[0] = 0;
        product[1] = 1;
        product[2] = 2;
        product[3] = 3;
 
        for (int i = 4; i <= length; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
            	max = Math.max(max, product[j] * product[i - j]);
            }
            product[i] = max;
        }
        return product[length];
    }
	
	/**
	 * ̰���㷨
	 */
    public int maxProductAfterCutting_solution2(int length) {
        if (length <= 1)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;
        int timesOf3 = length / 3;
        if (length % 3 == 1) 
            timesOf3--;
        int timesOf2 = (length - timesOf3 * 3) / 2;
        return (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
    }
 
    // =====���Դ���======
    void test(String testName, int length, int expected) {
        if (testName != null)
            System.out.println(testName + ":");
        if (maxProductAfterCutting_solution1(length) == expected) {
            System.out.print("    ��̬�滮:" + "passed  ");
        } else {
            System.out.print("    ��̬�滮:" + "failed  ");
        }
 
        if (maxProductAfterCutting_solution2(length) == expected) {
            System.out.println("̰���㷨:" + "passed  ");
        } else {
            System.out.println("̰���㷨:" + "failed  ");
        }
    }
 
    void test1() {
        test("test1", 1, 0);
    }
 
    void test2() {
        test("test2", 2, 1);
    }
 
    void test3() {
        test("test3", 3, 2);
    }
 
    void test4() {
        test("test4", 4, 4);
    }
 
    void test5() {
        test("test5", 5, 6);
    }
 
    void test6() {
        test("test6", 10, 36);
    }
 
    void test7() {
        test("test7", 50, 86093442);
    }
 
    public static void main(String[] args) {
    	Offer14_CuttingRope demo = new Offer14_CuttingRope();
        demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
        demo.test6();
        demo.test7();
    }
}
