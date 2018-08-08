package com.github.knightpop.programmers.strangechar;

class Solution {
    public String solution(String s) {
        int wordIdx = 0;
        StringBuilder stringBuilder = new StringBuilder(s);
        for(int i = 0; i < stringBuilder.length(); i++) {
            char c = stringBuilder.charAt(i);
            if(isBlank(c)) {
                wordIdx = 0;
            } else {
                stringBuilder.setCharAt(i, getStrangeChar(c, wordIdx));
                wordIdx++;
            }
        }

        return stringBuilder.toString();
    }

    private char getStrangeChar(char c, int wordIdx) {
        if(isEvenIdx(wordIdx)) return toCapital(c);
        else return toSmallLetter(c);
    }

    private boolean isEvenIdx(int idx) {
        return idx % 2 == 0;
    }

    private char toCapital(char c) {
        return String.valueOf(c).toUpperCase().charAt(0);
    }

    private char toSmallLetter(char c) {
        return String.valueOf(c).toLowerCase().charAt(0);
    }

    private boolean isBlank(char c) {
        return c == ' ';
    }
}