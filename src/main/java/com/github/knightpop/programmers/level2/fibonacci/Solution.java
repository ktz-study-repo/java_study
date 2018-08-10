package com.github.knightpop.programmers.level2.fibonacci;

import java.math.BigInteger;
import java.util.*;

class Solution {
    public int solution(int n) {
        List<BigInteger> acc = new ArrayList<>();
        acc.add(BigInteger.ZERO);
        acc.add(BigInteger.ONE);
        for(int i = 2; i <= n; i++) {
            acc.add(acc.get(i - 1).add(acc.get(i - 2)));
        }

        return acc.get(n).remainder(BigInteger.valueOf(1234567)).intValue();
    }
}