package com.khlin.sort;

import com.khlin.sort.utils.SortingHelper;

/**
 * 插入排序。 核心思想是：从左往右遍历，每次遍历后，当前下标的左侧都已经是排好序的了。 <br>
 * 第二层遍历，假定当前下标为i，则往前找元素，如果元素比它大，则交换，直到找到一个小的。 <br>
 * 由于左侧已经排好序了，说明前面的元素都比它小，没必要继续，元素从i<strong>插入</strong>到这个合适的位置。
 * 
 * @author kingsley
 *
 */
public class Insertion {

	public static void sort(int[] numbers) {
		int numbersSize = numbers.length;

		for (int index = 1; index <= numbersSize - 1; index++) {
			int cursor = index;
			for (int index2compare = index - 1; index2compare >= 0; index2compare--) {
				if (numbers[index2compare] > numbers[cursor]) {
					SortingHelper.exchange(numbers, index2compare, cursor);
					cursor = index2compare;
				} else {
					break;
				}
			}
		}
	}
}
