package com.github.knightpop.programmers.collatz;

class Solution {
    public int solution(int num) {
        long bigNum = num;

        for(int i = 0 ; i < 500; i++) {
            if(isEven(bigNum)) {
                bigNum = bigNum / 2;
            } else {
                bigNum = (bigNum * 3) + 1;
            }

            if(bigNum == 1) {
                return i + 1;
            }
        }

        return -1;
    }

    private boolean isEven(long num) {
        return num % 2 == 0;
    }
}