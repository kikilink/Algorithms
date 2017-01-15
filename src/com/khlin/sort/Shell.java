package com.khlin.sort;

import com.khlin.sort.utils.SortingHelper;

/**
 * ϣ������ ����˼���ǣ���������������棬�������̲�����
 * 
 * @author kingsley
 *
 */
public class Shell {

	public static void sort(int[] numbers) {
		int size = numbers.length;
		int h = 1;
		// ȷ������
		while (h < size / 3) {
			h = h * 3 + 1;// 1, 4, 13, 40.....
		}

		while (h >= 1) {
			for (int i = h; i < size; i++) {
				//��numbers[i]��numbers[i-h], numbers[i-2h]....�ȱȽϲ�����
				for (int j = i; j >= h && numbers[j] < numbers[j - h]; j -= h) {
					SortingHelper.exchange(numbers, j, j - h);
				}
			}
			// �������̲���
			h = h / 3;
		}
	}
}
