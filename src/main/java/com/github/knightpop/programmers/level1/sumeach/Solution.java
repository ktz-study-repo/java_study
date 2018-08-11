package com.github.knightpop.programmers.level1.sumeach;

public class Solution {
    public int solution(int n) {

        int nOfJari = getNOfJari(n);
        int sumOfN = 0;
        for(int i = 0; i < nOfJari; i++) {
            sumOfN += getNByIdx(n, i);
        }

        return sumOfN;
    }

    private int getNOfJari(int n) {
        return String.valueOf(n).length();
    }

    private int getNByIdx(int n, int idx) {
        return Integer.parseInt(String.valueOf(n).charAt(idx) + "");
    }
}