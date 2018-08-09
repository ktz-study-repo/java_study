package com.github.knightpop.programmers.leve1.removemin;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> checkIntList = new ArrayList<>();

        int minValue = Integer.MAX_VALUE;
        int minIdx = -1;

        for(int i = 0; i < arr.length; i++) {
            if(minValue > arr[i]) {
                minValue = arr[i];
                minIdx = i;
            }
            checkIntList.add(arr[i]);
        }

        checkIntList.remove(minIdx);

        if(checkIntList.isEmpty()) return new int[]{-1};
        else return checkIntList.stream().mapToInt(i -> i).toArray();
    }
}