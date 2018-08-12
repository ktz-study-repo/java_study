package com.github.knightpop.programmers.tipsdown.predict;

class Solution {
    public int solution(int n, int a, int b) {
        int nOfMatch = 1;
        while(getNextNum(a) != getNextNum(b)) {
            nOfMatch++;
            a = getNextNum(a);
            b = getNextNum(b);
        }

        return nOfMatch;
    }

    private int getNextNum(int a) {
        return (int)Math.ceil((double) a / 2);
    }
}