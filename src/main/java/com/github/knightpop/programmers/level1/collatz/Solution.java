package com.github.knightpop.programmers.level1.collatz;

import java.math.BigInteger;

class Solution {
    public int solution(int num) {
        if(num == 1) return 0;

        BigInteger bigNum = BigInteger.valueOf(num);

        for(int i = 0 ; i < 500; i++) {
            if(isEven(bigNum)) {
                bigNum = bigNum.divide(BigInteger.valueOf(2));
            } else {
                bigNum = bigNum.multiply(BigInteger.valueOf(3)).add(BigInteger.ONE);
            }

            if(bigNum.intValue() == 1) {
                return i + 1;
            }
        }

        return -1;
    }

    private boolean isEven(BigInteger num) {
        return num.remainder(BigInteger.valueOf(2)).intValue() == 0;
    }
}