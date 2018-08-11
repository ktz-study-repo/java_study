package com.github.knightpop.programmers.level1.divide;

import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> intList = new ArrayList<>();
        for(int i : arr) {
            if(i % divisor == 0)
                intList.add(i);
        }

        if(intList.isEmpty()) {
            return new int[]{-1};
        } else {
            intList.sort(Integer::compareTo);
            return intList.stream().mapToInt(i -> i).toArray();
        }
    }
}