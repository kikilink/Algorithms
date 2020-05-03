package com.khlin.leetcode;

public class CountBits_338 {
    public int[] countBits(int num) {
        if (num == 0) return new int[]{0};
        int[] bits = new int[num + 1];
        bits[0] = 0;
        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0) {
                bits[i] = bits[i / 2];
            } else {
                bits[i] = bits[i - 1] + 1;
            }
        }
        return bits;
    }


}
