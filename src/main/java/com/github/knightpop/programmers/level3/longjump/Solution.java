package com.github.knightpop.programmers.level3.longjump;

import java.math.BigInteger;
import java.util.*;

class Solution {
    private Map<Integer, BigInteger> nOfJumps;

    public Solution() {
        this.nOfJumps = new HashMap<>();
        this.nOfJumps.put(0, BigInteger.ONE);
        this.nOfJumps.put(1, BigInteger.ONE);
    }

    public long solution(int n) {
        return getNOfJump(n).remainder(BigInteger.valueOf(1234567)).longValue();
    }

    private BigInteger getNOfJump(int n) {
        if(nOfJumps.containsKey(n)) {
            return nOfJumps.get(n);
        }

        BigInteger nOfJump = getNOfJump(n - 1).add(getNOfJump(n - 2));
        this.nOfJumps.put(n, nOfJump);
        return nOfJump;
    }
}