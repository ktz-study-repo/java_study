package com.github.knightpop.programmers.leve1.revernumber;

class Solution {
    public int[] solution(long n) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(n));
        stringBuilder.reverse();
        int[] intArrToReturn = new int[stringBuilder.length()];
        for(int i = 0; i < stringBuilder.length(); i++) {
            intArrToReturn[i] = Integer.parseInt(stringBuilder.charAt(i) + "");
        }

        return intArrToReturn;
    }
}