package com.khlin.sort;

import com.khlin.sort.utils.SortingHelper;

/**
 * ð������ ����˼���ǣ�ÿ�α��������Ԫ���Ѿ������Ҳࡣ
 * <br>ÿ�αȽϺ󣬽ϴ��߷����Ҳ࣬�������Ҳ�ð������ѡ���������ơ�
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
