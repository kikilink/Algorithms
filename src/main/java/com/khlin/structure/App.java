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
        ArrayList<Integer> nodes = new ArrayList<>();
        nodes.add(4);
        nodes.add(3);
        nodes.add(11);
        nodes.add(12);
        nodes.add(8);
        nodes.add(0);
        nodes.add(7);
        //最大堆
        Heap<Integer> heap = new MaxHeap<>(nodes, new MyComparator());
        System.out.println(nodes);
        List<Integer> sortedList = new ArrayList<>(nodes.size());
        for (int i = nodes.size() - 1; i >= 0; i--) {
            sortedList.add(heap.extractRoot());
        }

        System.out.println(sortedList);

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
