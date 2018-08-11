package com.github.knightpop.programmers.level3.workhard;

import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> remainWorks = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2) * -1;
            }
        });


        // n
        for(int work : works) {
            remainWorks.add(work);
        }

        // n^2log(n)
        for(int i = n; i > 0 && !remainWorks.isEmpty(); i--) {
            Integer maxWork = remainWorks.poll();
            maxWork--;
            if(maxWork != 0)
                remainWorks.add(maxWork);
        }

        return calculateTired(remainWorks);
    }

    private long calculateTired(PriorityQueue<Integer> remainWorks) {
        if(remainWorks.isEmpty()) return 0;

        double tired = 0;

        // n
        for (Integer remainWork : remainWorks) {
            tired += (Math.pow(remainWork, 2));
        }

        return (long)tired;
    }
}