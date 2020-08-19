package com.lyt.java;

//题目
//	统计一个数字在排序数组中出现的次数。例如输入排序数组{1, 2, 3, 3,3, 3, 4, 5}和数字3，
//由于3在这个数组中出现了4次，因此输出4。
//思路
//	分析：对于例子来说，如果采用二分法找到某一个3后，再往前遍历和往后遍历到第一个和
//最后一个3，在长度为n的数组中有可能出现O(n)个3，因此这样的扫描方法时间复杂度为O(n)，
//效率与从头到尾扫描一样，速度太慢。
//	这题关键是找到第一个和最后一个3，因此我们尝试改进二分法：中间数字比3大或者小的情况
//与之前类似，关键是中间数字等于3的情况，这时可以分类讨论如下：
//	1）如果中间数字的前一个数字也等于3，说明第一个3在前面，继续在前半段查找第一个3；
//	2）如果中间数字的前一个数字不等于3，说明该位置是第一个3；
//	3）如果中间数字的后一个数字也等于3，说明最后一个3在后面，继续在后半段查找最后一个3；
//	4）如果中间数字的后一个数字不等于3，说明该位置是最后一个3；
public class Offer53_NumberOfK {
	public int getNumberOfK(int[] arr, int k) {
		if (arr == null || arr.length <= 0)
			throw new RuntimeException("数组不合法");
		
		int firstK = getFirstK(arr, 0, arr.length - 1, k);
		if (firstK == -1)
			throw new RuntimeException("不存在该数字");
		
		int lastK = getLastK(arr, firstK, arr.length - 1, k);
		return lastK - firstK + 1;
	}

	private int getFirstK(int[] arr, int start, int end, int k) {
		if (start > end)
			return -1;
		
		int mid = (start + end) >> 1;
		if (arr[mid] == k) {
			if (mid == 0 || arr[mid - 1] != k)
				return mid;
			else
				end = mid - 1;
		} else if (arr[mid] < k) {
			start = mid + 1;
		} else {
			end = mid - 1;
		}
		return getFirstK(arr, start, end, k);
	}

	private int getLastK(int[] arr, int start, int end, int k) {
		if (start > end)
			return -1;
		
		int mid = (start + end) >> 1;
		if (arr[mid] == k) {
			if (mid == arr.length - 1 || arr[mid + 1] != k)
				return mid;
			else
				start = mid + 1;
		} else if (arr[mid] < k) {
			start = mid + 1;
		} else {
			end = mid - 1;
		}
		return getLastK(arr, start, end, k);
	}

	public static void main(String[] args) {
		Offer53_NumberOfK demo = new Offer53_NumberOfK();
		int[] arr = { 1, 2, 3, 3, 3, 3, 4, 5 };
		int i = demo.getNumberOfK(arr, 3);
		System.out.println(i);
	}
}
