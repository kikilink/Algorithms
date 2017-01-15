package com.khlin.sort.utils;

public class SortingHelper {
	
	public static void exchange(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
