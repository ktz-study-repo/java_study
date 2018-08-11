package com.github.knightpop.programmers.level1.issqrt;

class Solution {
    public long solution(long n) {
        double sqrtResult = Math.sqrt(n);
        if(isInteger(sqrtResult)) {
            return (long) Math.pow(sqrtResult + 1, 2);
        } else {
            return -1L;
        }
    }

    public boolean isInteger(double n) {
        return n % 1 == 0;
    }
}