package com.github.knightpop.programmers.leve1.sorteachint;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public long solution(long n) {
        List<Integer> ascIntList = toSortedAscList(n);
        long numToReturn = 0;
        for(int i = 0; i < ascIntList.size(); i++) {
            numToReturn += ascIntList.get(i) * Math.pow(10, i);
        }

        return numToReturn;
    }

    private List<Integer> toSortedAscList(long n) {
        String s = String.valueOf(n);
        List<Integer> listToReturn = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            listToReturn.add(Integer.parseInt(s.charAt(i) + ""));
        }

        listToReturn.sort(Integer::compareTo);

        return listToReturn;
    }
}