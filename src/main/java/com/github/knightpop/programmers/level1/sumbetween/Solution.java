package com.github.knightpop.programmers.level1.sumbetween;

class Solution {
    public long solution(int a, int b) {
        if(a == b) return a;

        long min = Integer.min(a, b);
        long max = Integer.max(a, b);
        long n = getN(min, max);

        return n * (min + max) / 2;
    }

    private long getN(long min, long max) {
        return max - min + 1;
    }
}