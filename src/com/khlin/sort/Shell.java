package com.khlin.sort;

import com.khlin.sort.utils.SortingHelper;

/**
 * 希尔排序。 核心思想是：插入排序的升级版，不断缩短步长。
 * 
 * @author kingsley
 *
 */
public class Shell {

	public static void sort(int[] numbers) {
		int size = numbers.length;
		int h = 1;
		// 确定步长
		while (h < size / 3) {
			h = h * 3 + 1;// 1, 4, 13, 40.....
		}

		while (h >= 1) {
			for (int i = h; i < size; i++) {
				//将numbers[i]与numbers[i-h], numbers[i-2h]....等比较并插入
				for (int j = i; j >= h && numbers[j] < numbers[j - h]; j -= h) {
					SortingHelper.exchange(numbers, j, j - h);
				}
			}
			// 不断缩短步长
			h = h / 3;
		}
	}
}
