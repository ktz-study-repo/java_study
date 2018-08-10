package com.github.knightpop.programmers.level2.expressnumber;

class Solution {
    public int solution(int n) {
        int nOfPossible = 0;

        for(int i = 1; n <= sumAll(i, n); i++) {
            if(isPossible(n, i)) nOfPossible++;
        }

        return nOfPossible;
    }

    private boolean isPossible(int targetNum, int from) {
        int sum = 0;
        for(int i = from; sum < targetNum; i++) {
            sum += i;
        }

        return sum == targetNum;
    }

    private int sumAll(int from, int to) {
        return (to - from + 1) * (from + to) / 2;
    }
}