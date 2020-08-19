package com.lyt.java;

//	写一个函数，输入n，求斐波那契（Fibonacci）数列的第n项。
//思路
//	如果直接写递归函数，由于会出现很多重复计算，效率非常底，不采用。
//要避免重复计算，采用从下往上计算，可以把计算过了的保存起来，下次要计算时就不必
//重复计算了：先由f(0)和f(1)计算f(2)，再由f(1)和f(2)计算f(3)……以此类推就行了，
//计算第n个时，只要保存第n-1和第n-2项就可以了。
//青蛙跳台阶问题
//	题目1：
//		一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总
//共有多少种跳法。
//	将跳法总数记为f(n)，可以知道f(1)=1，f(2)=2。当n>2时，第一次跳1级的话，还有f(n-1)种跳
//法;第一次跳2级的话，还有f(n-2)种跳法，所以可以推得f(n) = f(n-1)+f(n-2)，即为斐波那契数列。
//	题目2：
//		一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳
//上一个n级的台阶总共有多少种跳法。
//解法1：
//	当n=1时，f(1)=1。
//	当n大于1时，归纳总结可知：跳上n级台阶，第一次跳1级的话，有f(n-1)种方法；第一次跳2级
//的话，有f(n-2)种方法……第一次跳n-1级的话，有f(1)种方法；直接跳n级的话，有1种方法，
//所以可以得到
//如下公式：
//	f(n) = f(n-1)+f(n-2)+......f(1)+1　　（n≥2）
//	f(n-1) = f(n-2)+f(n-3)+.....f(1)+1　　（n>2）
//由上面两式相减可得，f(n)-f(n-1)=f(n-1)，即f(n) = 2*f(n-1)  (n>2)
//最终结合f(1)和f(2)，可以推得：f(n)=2^(n-1)
//	解法2：
//		假设跳到第n级总共需要k次，说明要在中间n-1级台阶中选出任意k-1个台阶，即
//C(n-1,k-1)种方法。所以：跳1次就跳上n级台阶，需要C(n-1,0)种方法；跳2次需要C(n-1,1)
//种方法……跳n次需要C(n-1,n-1)种方法总共需要跳C(n-1,0)+C(n-1,1)+C(n-1,2)+……
//C(n-1,n-1)=2^(n-1)种方法。
//	解法3：
//		除了必须到达最后一级台阶，第1级到第n-1级台阶都可以有选择的跳，也就是说对于这
//n-1个台阶来说，每个台阶都有跳上和不跳上2种情况，所以一共有   2^(n-1) 种方法。
//	矩形覆盖问题
//	题目：用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
//	当n = 1时，有一种方法。
//	当n = 2时，有两种方法。
//	当n >= 3时，和斐波那契数列类似。第一步竖着放，有f(n-1)种方法；第一步横着放，
//	有f(n-2)种方法。所以f(n)=f(n-1)+f(n-2)。
public class Offer10_Fibonacci {
	/**
	 * 递归： 
	 * 	斐波那契数：0,1,1,2,3,5..... 
	 * 	青蛙跳台阶：1,2,3,5,8.....
	 */
	public long fibonacci1(long n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return fibonacci1(n - 1) + fibonacci1(n - 2);
	}

	/**
	 * 循环
	 */
	public long fibonacci2(long n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		long result = 1, pre = 1, prePre = 0;
		for (long i = 2; i <= n; i++) {
			result = prePre + pre;
			prePre = pre; // 注意顺序
			pre = result;
		}
		return result;
	}

	public static void main(String[] args) {
		Offer10_Fibonacci demo = new Offer10_Fibonacci();
		System.out.println(demo.fibonacci2(0));
		System.out.println(demo.fibonacci2(1));
		System.out.println(demo.fibonacci2(2));
		System.out.println(demo.fibonacci2(8));
		System.out.println(demo.fibonacci2(50));
		System.out.println(demo.fibonacci2(100));
		System.out.println(demo.fibonacci2(-5));
	}
}