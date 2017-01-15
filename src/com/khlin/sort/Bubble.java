package com.khlin.sort;

import com.khlin.sort.utils.SortingHelper;

/**
 * 冒泡排序。 核心思想是：每次遍历后，最大元素已经在最右侧。
 * <br>每次比较后，较大者放在右侧，不断往右侧冒出。与选择排序类似。
 * 
 * @author kingsley
 *
 */
public class Bubble {

	public static void sort(int[] numbers) {
		for (int times = 0; times <= numbers.length - 1; times++) {
			for (int i = 0; i <= numbers.length - 2 - times; i++) {
				if (numbers[i] > numbers[i + 1]) {
					SortingHelper.exchange(numbers, i, i + 1);
				}
			}
		}
	}
}
