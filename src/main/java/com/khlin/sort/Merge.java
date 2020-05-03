package com.khlin.sort;

/**
 * 归并排序。
 * 核心思想是：在不断地把集合分化成两侧，递归下去。
 * <br>当分出来的元素只有一个的时候，可以认为该侧已经排序完，退出排另一侧。
 * <br>当两侧排序完，进行一次合并，再跳出外面一层继续上面的动作。
 * @author kingsley
 *
 */
public class Merge {

	private static int[] tmp;

	public static void sort(int[] numbers) {
		tmp = new int[numbers.length];
		sort(numbers, 0, numbers.length - 1);
	}

	private static void sort(int[] numbers, int low, int high) {
		// 只剩下一个或没有元素，不需要排序了。
		if (low >= high) {
			return;
		}

		int middle = (low + high) / 2;

		sort(numbers, low, middle);
		sort(numbers, middle + 1, high);

		merge(numbers, low, middle, high);
	}

	private static void merge(int[] numbers, int low, int middle, int high) {

		int i = low;
		// 这里的起点与上面分区相关，由于上面low-middle为一个分区
		// 另一个分区是middle+1 - high，所以这里是middle + 1;
		int j = middle + 1;

		//利用一个临时数组拷贝
		for (int index = low; index <= high; index++) {
			tmp[index] = numbers[index];
		}

		for (int k = low; k <= high; k++) {
			// 已经越界
			if (i > middle) {
				numbers[k] = tmp[j++];
			} else if (j > high) {
				numbers[k] = tmp[i++];
			} else if (tmp[i] <= tmp[j]) {
				numbers[k] = tmp[i++];
			} else {
				numbers[k] = tmp[j++];
			}
		}
	}
}
