package com.github.knightpop.programmers.medium;

class Solution {
    public String solution(String s) {
        int midIdx = s.length() / 2;
        if(isEven(s.length())) {
            return s.substring(midIdx - 1, midIdx + 1);
        } else {
            return "" + s.charAt(midIdx);
        }
    }

    private boolean isEven(int length) {
        return length % 2 == 0;
    }
}