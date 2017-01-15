package com.khlin.sort;

import com.khlin.sort.utils.SortingHelper;

/**
 * ѡ������ <br>
 * ����˼���ǣ�<br>
 * �ӵ�һ��Ԫ��(�±�index)��ʼ��һ��������ڶ����index��ʼ����Ԫ�أ�����<strong>ѡ��</strong>��СԪ�ص�λ�� ��
 * ����СԪ�ص�λ����index��ͬ��˵���ڶ����������СԪ�ؾ���index��������index����λ�á�
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
