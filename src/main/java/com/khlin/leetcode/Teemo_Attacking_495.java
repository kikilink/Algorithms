package com.khlin.leetcode;

public class Teemo_Attacking_495 {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length == 0) {
            return 0;
        }
        int totalDuration = 0;
        for (int index = 0; index <= timeSeries.length - 2; index++) {
            int thisTime = timeSeries[index];
            int nextTime = timeSeries[index + 1];
            if (thisTime + duration > nextTime) {
                totalDuration += (nextTime - thisTime);
            } else {
                totalDuration += duration;
            }
        }
        totalDuration += duration;
        return totalDuration;
    }

    public static void main(String[] args) {
        System.out.println(new Teemo_Attacking_495().findPoisonedDuration(new int[]{1, 4}, 2));
    }
}
