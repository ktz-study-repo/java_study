package com.github.knightpop.programmers.level2.mkmin;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int []A, int []B) {
        List<Integer> sortedA = sortArray(A);
        List<Integer> sortedB = sortArray(B);
        int nOfSum = 0;
        while(!sortedA.isEmpty()) {
            if(compareMaxTo(sortedA, sortedB) < 0) {
                nOfSum += (popHead(sortedA) * popLast(sortedB));
            } else {
                nOfSum += (popLast(sortedA) * popHead(sortedB));
            }
        }

        return nOfSum;
    }

    private int compareMaxTo(List<Integer> ascSortedListA, List<Integer> ascSortedListB) {
        return Integer.compare(ascSortedListA.get(ascSortedListA.size() - 1), ascSortedListB.get(ascSortedListB.size() - 1));
    }

    private int popHead(List<Integer> listToPop) {
        Integer integer = listToPop.get(0);
        listToPop.remove(0);

        return integer;
    }

    private int popLast(List<Integer> listToPop) {
        Integer integer = listToPop.get(listToPop.size() - 1);
        listToPop.remove(listToPop.size() - 1);

        return integer;
    }

    private List<Integer> sortArray(int[] arr) {
        return Arrays.stream(arr).sorted().boxed().collect(Collectors.toList());
    }
}