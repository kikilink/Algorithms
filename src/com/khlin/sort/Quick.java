package com.khlin.sort;

/**
 * 快速排序。 核心思想是：每一趟遍历(sortUnit)之后，存在一个下标，其左边都比它小，右边都比它大，依此继续递归下去。 <br>
 * 关键是第一步，要把某个元素拎出来作为比较对象，这样还有一个好处是它可以被覆盖，相当于空了一个位置。
 * 
 * @author kingsley
 *
 */
public class Quick {

	public static void sort(int[] numbers) {
		sort(numbers, 0, numbers.length - 1);
	}

	private static int sortUnit(int[] datalist, int low, int high) {
		int key = datalist[low];// 把第一个数当作基准数
		while (low < high)// 两个指针一开始应该不等，每一次分区间的结果必然是两者指向同一下标
		{
			while (low < high && datalist[high] >= key)
				// 先从高往低找，找到比基准数小的，就把它赋给较小下标的，如果是第一次查找，因为较小下标的数已经当成基准数，所以直接覆盖不会造成数据丢失，如果不是第一次查找，在上次循环较小下标的数据也已做了复制
				high--;
			datalist[low] = datalist[high];
			while (low < high && datalist[low] <= key)
				// 再从低处往高找，找到比基准数大的，就把它赋给较大下标的，因较大下标的数已经在上次操作做了复制，所以直接覆盖
				low++;
			datalist[high] = datalist[low];
		}

		datalist[high] = key;// 此处low和high应该是指向同一下标，所以使用low和high结果是一样的
		return high;
	}

	private static void sort(int[] datalist, int low, int high) {
		if (low >= high)
			return;
		else {
			int index = sortUnit(datalist, low, high);// 分治法，分成两边排序，每次SortUnit都会把数组的数按与基准数大小关系排列好，即基准数左边的都是比它小的，右边则相反
			sort(datalist, low, index - 1);// 基准数的index已经是两边的边界，所以它可以不参加排序了
			sort(datalist, index + 1, high);
		}
	}
}
