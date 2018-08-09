package com.github.knightpop.programmers.leve1.xofn;

class Solution {
    public long[] solution(int x, int n) {
        long mulX = x;
        long[] longs = new long[n];
        for(int i = 0; i < n; i++) {
            longs[i] = mulX * (i + 1);
        }

        return longs;
    }
}