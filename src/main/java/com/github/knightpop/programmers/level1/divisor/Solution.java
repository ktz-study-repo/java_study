package com.github.knightpop.programmers.level1.divisor;

import java.util.*;

class Solution {
    public int solution(int n) {
        if(n == 1) return 1;

        Integer[] divisorSet = getDivisorSet(n);
        int sumOfDivisor = 0;
        for(int i = 0; i < divisorSet.length; i++) {
            sumOfDivisor += divisorSet[i];
        }

        return sumOfDivisor;
    }

    private Integer[] getDivisorSet(int n) {
        Set<Integer> divisorSet = new HashSet<>();
        for(int i = 1; i < n / 2; i++) {
            if(n % i == 0) {
                divisorSet.add(i);
                divisorSet.add(n / i);
            }
        }

        return divisorSet.toArray(new Integer[divisorSet.size()]);
    }
}