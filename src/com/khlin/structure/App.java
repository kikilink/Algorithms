package com.khlin.structure;

import java.lang.reflect.Array;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) {
//        ArrayList<Integer> nodes = generateNumbersRandomly(8);
//        Integer[] nodes = new Integer[] {4, 3, 11, 12, 8, 0, 7};
        ArrayList<Integer> nodes = new ArrayList<>();
        nodes.add(4);
        nodes.add(3);
        nodes.add(11);
        nodes.add(12);
        nodes.add(8);
        nodes.add(0);
        nodes.add(7);
        System.out.println(nodes);
        Heap<Integer> heap = new MaxHeap<Integer>(nodes, new MyComparator());
        heap.print();
        heap.insert(19);
        heap.print();
        extractManyTimes(heap, 12);
    }

    private static void extractManyTimes(Heap<Integer> heap, int times) {
        for (int i = 1; i <= times; i++) {
            heap.extractRoot();
            heap.print();

        }
    }

    private static ArrayList<Integer> generateNumbersRandomly(int length) {
//        Integer[] numbers = new Integer[length];

        ArrayList<Integer> numbers = new ArrayList<>(length);
        try {
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            for (int i = 0; i <= length - 1; i++) {
                numbers.add(random.nextInt(length * 2));
            }
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return numbers;
    }

    private static class MyComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

}
