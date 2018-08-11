package com.github.knightpop.programmers.level1.pny;

class Solution {
    boolean solution(String s) {
        int nOfP = 0;
        int nOfY = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(isP(c)) {
                nOfP += 1;
            } else if (isY(c)) {
                nOfY += 1;
            }
        }

        return nOfP == nOfY;
    }

    private boolean isP(char c) {
        return c == 'p' || c == 'P';
    }

    private boolean isY(char c) {
        return c == 'y' || c == 'Y';
    }
}