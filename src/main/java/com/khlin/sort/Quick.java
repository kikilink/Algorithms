package com.khlin.sort;

/**
 * �������� ����˼���ǣ�ÿһ�˱���(sortUnit)֮�󣬴���һ���±꣬����߶�����С���ұ߶����������˼����ݹ���ȥ�� <br>
 * �ؼ��ǵ�һ����Ҫ��ĳ��Ԫ���������Ϊ�Ƚ϶�����������һ���ô��������Ա����ǣ��൱�ڿ���һ��λ�á�
 * 
 * @author kingsley
 *
 */
public class Quick {

	public static void sort(int[] numbers) {
		sort(numbers, 0, numbers.length - 1);
	}

	private static int sortUnit(int[] datalist, int low, int high) {
		int key = datalist[low];// �ѵ�һ����������׼��
		while (low < high)// ����ָ��һ��ʼӦ�ò��ȣ�ÿһ�η�����Ľ����Ȼ������ָ��ͬһ�±�
		{
			while (low < high && datalist[high] >= key)
				// �ȴӸ������ң��ҵ��Ȼ�׼��С�ģ��Ͱ���������С�±�ģ�����ǵ�һ�β��ң���Ϊ��С�±�����Ѿ����ɻ�׼��������ֱ�Ӹ��ǲ���������ݶ�ʧ��������ǵ�һ�β��ң����ϴ�ѭ����С�±������Ҳ�����˸���
				high--;
			datalist[low] = datalist[high];
			while (low < high && datalist[low] <= key)
				// �ٴӵʹ������ң��ҵ��Ȼ�׼����ģ��Ͱ��������ϴ��±�ģ���ϴ��±�����Ѿ����ϴβ������˸��ƣ�����ֱ�Ӹ���
				low++;
			datalist[high] = datalist[low];
		}

		datalist[high] = key;// �˴�low��highӦ����ָ��ͬһ�±꣬����ʹ��low��high�����һ����
		return high;
	}

	private static void sort(int[] datalist, int low, int high) {
		if (low >= high)
			return;
		else {
			int index = sortUnit(datalist, low, high);// ���η����ֳ���������ÿ��SortUnit�����������������׼����С��ϵ���кã�����׼����ߵĶ��Ǳ���С�ģ��ұ����෴
			sort(datalist, low, index - 1);// ��׼����index�Ѿ������ߵı߽磬���������Բ��μ�������
			sort(datalist, index + 1, high);
		}
	}
}
