package com.khlin.sort;

import com.khlin.sort.utils.SortingHelper;

/**
 * 选择排序。 <br>
 * 核心思想是：<br>
 * 从第一个元素(下标index)开始第一层遍历，第二层从index开始遍历元素，从中<strong>选择</strong>最小元素的位置 。
 * 若最小元素的位置与index相同，说明第二层遍历的最小元素就是index，否则与index交换位置。
 * 
 * @author kingsley
 */
public class Selection {

	public static void sort(int[] numbers) {
		for (int index = 0; index <= numbers.length - 2; index++) {
			int minNumberIndex = index;
			for (int index2compare = index + 1; index2compare <= numbers.length - 1; index2compare++) {
				if (numbers[index2compare] < numbers[minNumberIndex]) {
					minNumberIndex = index2compare;
				}
			}

			if (minNumberIndex != index) {
				SortingHelper.exchange(numbers, minNumberIndex, index);
			}
		}
	}

}
