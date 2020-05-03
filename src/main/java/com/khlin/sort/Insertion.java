package com.khlin.sort;

import com.khlin.sort.utils.SortingHelper;

/**
 * �������� ����˼���ǣ��������ұ�����ÿ�α����󣬵�ǰ�±����඼�Ѿ����ź�����ˡ� <br>
 * �ڶ���������ٶ���ǰ�±�Ϊi������ǰ��Ԫ�أ����Ԫ�ر������򽻻���ֱ���ҵ�һ��С�ġ� <br>
 * ��������Ѿ��ź����ˣ�˵��ǰ���Ԫ�ض�����С��û��Ҫ������Ԫ�ش�i<strong>����</strong>��������ʵ�λ�á�
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
