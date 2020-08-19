package com.lyt.java;

//题目
//	给你一根长度为n绳子，请把绳子剪成m段（m、n都是整数，n＞1并且m＞1）。每段的绳子的长
//度记为k[0]、k[1]、……、k[m]。k[0]*k[1]*…*k[m]可能的最大乘积是多少？例如当绳子的长度
//是8时我们把它剪成长度分别为2、3、3的三段，此时得到最大的乘积18。
//思路
//	本题采用动态规划或者贪婪算法可以实现。一开始没有思路时，可以从简单的情况开始想，试着
//算以下比较短的绳子是如何剪的。
//当n=1时，最大乘积只能为0；
//当n=2时，最大乘积只能为1；
//当n=3时，最大乘积只能为2；
//当n=4时，可以分为如下几种情况:1*1*1*1，1*2*1，1*3，2*2，最大乘积为4；
//往下推时，发现n≥4时，可以把问题变成几个小问题，即：如果把长度n绳子的最大乘积记为f(n)，
//则有：f(n)=max(f(i)*f(n-1))，0<i<n。所以思路就很容易出来了：从下往上推，先算小的问
//题，再算大的问题，大的问题通过寻找小问题的最优组合得到。
//	其实这就是动态规划法，以下是动态规划法的几个特点：
//1.求一个问题的最优解
//2.整体问题的最优解依赖各子问题的最优解
//3.小问题之间还有相互重叠的更小的子问题
//4.为了避免小问题的重复求解，采用从上往下分析和从下往上求解的方法求解问题
//贪婪算法依赖于数学证明，当绳子大于5时，尽量多地剪出长度为3的绳子是最优解,还剩4不用剪。
public class Offer14_CuttingRope {
	/**
	 * 动态规划
	// 下面几个不是乘积，因为其本身长度比乘积大
	// 开始从下到上计算长度为i绳子的最大乘积值product[i]
	// 算不同子长度的乘积，找出最大的乘积
	 */
	public int maxProductAfterCutting_solution1(int length) {
        if (length <= 1)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;
        int[] product = new int[length + 1]; // 用于存放最大乘积值
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
	 * 贪婪算法
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
 
    // =====测试代码======
    void test(String testName, int length, int expected) {
        if (testName != null)
            System.out.println(testName + ":");
        if (maxProductAfterCutting_solution1(length) == expected) {
            System.out.print("    动态规划:" + "passed  ");
        } else {
            System.out.print("    动态规划:" + "failed  ");
        }
 
        if (maxProductAfterCutting_solution2(length) == expected) {
            System.out.println("贪婪算法:" + "passed  ");
        } else {
            System.out.println("贪婪算法:" + "failed  ");
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
