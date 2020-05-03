package com.khlin.leetcode;

public class GrumpyBookstoreOwner_1052 {

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int from = 0;
        int to = X - 1;
        int previousCooledDownSatisfied = 0;
        for (int index = from; index <= to; index++) {
            previousCooledDownSatisfied += customers[index];
        }

        int previousNaturalSatisfied = 0;
        for (int index = to + 1; index <= customers.length - 1; index++) {
            if (grumpy[index] == 0) {
                previousNaturalSatisfied += customers[index];
            }
        }

        int maxSatified = previousCooledDownSatisfied + previousNaturalSatisfied;

        from++;
        to++;
        for (; to <= customers.length - 1; from++, to++) {
            int cooledDownSatisfiedOfThisTime = previousCooledDownSatisfied;
            int naturalSatisfiedOfThisTime = previousNaturalSatisfied;
            //实际上一个是生气的，但被算成了不生气，所以减掉
            if (grumpy[from - 1] == 1) {
                cooledDownSatisfiedOfThisTime -= customers[from - 1];
            }
            //这一次一定要加的
            cooledDownSatisfiedOfThisTime += customers[to];

            //不生气，说明上次加了，那要去掉
            if(0 == grumpy[to]){
                naturalSatisfiedOfThisTime -= customers[to];
            }

            maxSatified = Math.max(maxSatified, cooledDownSatisfiedOfThisTime + naturalSatisfiedOfThisTime);
            previousCooledDownSatisfied = cooledDownSatisfiedOfThisTime;
            previousNaturalSatisfied = naturalSatisfiedOfThisTime;
        }

        return maxSatified;
    }

    public static void main(String[] args) {
        System.out.println(new GrumpyBookstoreOwner_1052().maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
    }
}
