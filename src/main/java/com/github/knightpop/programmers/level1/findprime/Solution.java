package com.github.knightpop.programmers.level1.findprime;

import java.util.stream.IntStream;

class Solution {
    public int solution(int num) {
        int[] integerRange = getIntegerRange(num);
        integerRange[0] = 0;
        integerRange[1] = 0;

        for(int i = 2; i < Math.sqrt(num); i++) {
            for(int j = 2; i * j <= num; j++) {
                integerRange[i * j] = 0;
            }
        }

        return count(integerRange);
    }

    private int count(int[] ints) {
        int n = 0;
        for(int i : ints) {
            if(i != 0) n++;
        }

        return n;
    }

    private boolean canDivided(int numToDivide, int target) {
        return target != numToDivide && target % numToDivide == 0;
    }

    private int[] getIntegerRange(int num) {
        return IntStream.rangeClosed(0, num).toArray();
    }
}