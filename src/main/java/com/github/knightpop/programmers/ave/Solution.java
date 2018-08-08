package com.github.knightpop.programmers.ave;

class Solution {
    public double solution(int[] arr) {
        if (arr.length == 0) return 0;

        double sumOfInt = 0;
        for (int anArr : arr) {
            sumOfInt += anArr;
        }
        return sumOfInt / arr.length;
    }
}