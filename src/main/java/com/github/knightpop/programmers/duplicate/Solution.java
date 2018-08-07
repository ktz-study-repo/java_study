package com.github.knightpop.programmers.duplicate;

import java.util.*;

public class Solution {
    int prevNum = -1;

    public int[] solution(int []arr) {
        List<Integer> listToReturn = new ArrayList<>();

        for(int i : arr) {
            if(!isDuplicated(i)) {
                listToReturn.add(i);
                prevNum = i;
            }
        }


        return listToReturn.stream().mapToInt(i -> i).toArray();
    }

    private boolean isDuplicated(int i) {
        return prevNum != -1 && prevNum == i;
    }
}