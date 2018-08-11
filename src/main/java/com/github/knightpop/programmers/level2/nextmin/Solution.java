package com.github.knightpop.programmers.level2.nextmin;

class Solution {
    public int solution(int n) {
        int nOfOneInN = getNOfOneInBinary(n);
        int targetN = n + 1;
        while(getNOfOneInBinary(targetN) != nOfOneInN) {
            targetN++;
        }

        return targetN;
    }

    public int getNOfOneInBinary(int n) {
        String binaryString = Integer.toBinaryString(n);
        int nOfOne = 0;

        for(int i = 0; i < binaryString.length(); i++) {
            if(binaryString.charAt(i) == '1') nOfOne++;
        }

        return nOfOne;
    }
}