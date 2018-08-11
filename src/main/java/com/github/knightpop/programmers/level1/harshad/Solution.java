package com.github.knightpop.programmers.level1.harshad;

class Solution {
    public boolean solution(int x) {
        int sumOfAll = mkAllSum(x);
        return x % sumOfAll == 0;
    }

    private int mkAllSum(int x) {
        int sumOfAll = 0;
        String s = String.valueOf(x);
        for(int i = 0; i < s.length(); i++) {
            sumOfAll += (Integer.parseInt(s.charAt(i) + ""));
        }

        return sumOfAll;
    }
}
