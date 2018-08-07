package com.github.knightpop.programmers.findprime;

import java.util.*;

import static java.lang.Math.*;

class Solution {
    public int solution(int num) {

        boolean[] bArr = new boolean[num+1];

        for (int i=2; i<=num; ++i)
            bArr[i] = true;

        for (int i=2; i<=sqrt(num); ++i) {
            if (bArr[i]) {
                for (int j=i*i; j<=num; j+=1)
                    bArr[j] = false;
            }

        }

        int nOfPrime = 0;

        for (int i = 2; i<num; ++i) {
            if (bArr[i]) {
                nOfPrime++;
            }
        }

        return nOfPrime;
    }
}