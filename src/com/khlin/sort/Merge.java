package com.khlin.sort;

/**
 * �鲢����
 * ����˼���ǣ��ڲ��ϵذѼ��Ϸֻ������࣬�ݹ���ȥ��
 * <br>���ֳ�����Ԫ��ֻ��һ����ʱ�򣬿�����Ϊ�ò��Ѿ������꣬�˳�����һ�ࡣ
 * <br>�����������꣬����һ�κϲ�������������һ���������Ķ�����
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
		// ֻʣ��һ����û��Ԫ�أ�����Ҫ�����ˡ�
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
		// �������������������أ���������low-middleΪһ������
		// ��һ��������middle+1 - high������������middle + 1;
		int j = middle + 1;

		//����һ����ʱ���鿽��
		for (int index = low; index <= high; index++) {
			tmp[index] = numbers[index];
		}

		for (int k = low; k <= high; k++) {
			// �Ѿ�Խ��
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
