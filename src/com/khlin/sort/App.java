package com.khlin.sort;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		int[] numbers = generateNumbersRandomly(100);
		System.out.println("before sorted.");
		System.out.println(Arrays.toString(numbers));

//		SelectionSort.sort(numbers);
//		InsertionSort.sort(numbers);
//		Merge.sort(numbers);
//		Bubble.sort(numbers);
//		Shell.sort(numbers);
		Quick.sort(numbers);

		System.out.println("after sorted.");
		System.out.println(Arrays.toString(numbers));
	}

	private static int[] generateNumbersRandomly(int length) {
		int[] numbers = new int[length];

		try {
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			for (int i = 0; i <= numbers.length - 1; i++) {
				numbers[i] = random.nextInt(length * 2);
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return numbers;
	}
}
