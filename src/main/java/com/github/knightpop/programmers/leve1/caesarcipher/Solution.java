package com.github.knightpop.programmers.leve1.caesarcipher;

class Solution {

    private final static int N_OF_CHAR = 'z' - 'a' + 1;

    public String solution(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder(s);

        for(int i = 0; i < stringBuilder.length(); i++) {
            char pushedChar = pushChar(s.charAt(i), n);
            stringBuilder.setCharAt(i, pushedChar);
        }

        return stringBuilder.toString();
    }

    private char pushChar(char c, int n) {
        if(isBlank(c)) {
            return c;
        } else {
            return (char)(getPivotChar(c) + getIdxOfChar(c, n));
        }
    }

    private int getIdxOfChar(char c, int n) {
        char pivotChar = getPivotChar(c);

        return (c - pivotChar + n) % N_OF_CHAR;
    }

    private char getPivotChar(char c) {
        if(isBlank(c)) return ' ';
        else if(isCapital(c)) return 'A';
        else return 'a';
    }

    private boolean isCapital(char c) {
        return 'A' <= c && c <= 'Z';
    }

    private boolean isBlank(char c) {
        return c == ' ';
    }
}