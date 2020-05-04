package com.khlin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PrintWordsVertically_1324 {

    public List<String> printVertically(String s) {
        if (s.trim().length() == 0) {
            return Collections.emptyList();
        }
        String[] words = s.split(" ");
        int rowsCount = Arrays.stream(words).map(word -> word.length()).sorted((o1, o2) -> o2 - o1).findFirst().get();
        int columnCount = words.length;
        List<List<String>> results = new ArrayList<>(rowsCount);
        for (int rowIndex = 0; rowIndex <= rowsCount - 1; rowIndex++) {
            results.add(new ArrayList<>(columnCount));
        }

        for (String word : words) {
            char[] chars = word.toCharArray();
            for (int i = 0; i <= rowsCount - 1; i++) {
                if (i <= chars.length - 1) {
                    char c = chars[i];
                    results.get(i).add(String.valueOf(c));
                } else {
                    results.get(i).add(" ");
                }
            }
        }

        return results.stream().map(row -> row.stream().collect(Collectors.joining()).replaceAll("(\\s*$)", "")).collect(Collectors.toList());
    }
}
