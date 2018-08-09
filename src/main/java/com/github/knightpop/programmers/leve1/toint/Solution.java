package com.github.knightpop.programmers.leve1.toint;

class Solution {
    public int solution(String s) {
        String numberString = getOnlyNumberString(s);
        int toIntResult = 0;
        int lastIdx = numberString.length() - 1;
        for(int i = lastIdx; i >= 0; i--) {
            int parsedInt = Integer.parseInt(numberString.charAt(i) + "");
            toIntResult += parsedInt * Math.pow(10, lastIdx - i);
        }

        return toIntResult * getBooho(s);
    }

    private boolean hasBooho(String s) {
        if(s.isEmpty()) return false;

        char headChar = s.charAt(0);
        return headChar == '-' || headChar == '+';
    }

    private int getBooho(String s) {
        if(s.isEmpty()) return 1;

        if(hasBooho(s) && s.charAt(0) == '-') {
            return -1;
        } else {
            return 1;
        }
    }

    private String getOnlyNumberString(String s) {
        if(hasBooho(s)) {
            return s.substring(1, s.length());
        } else {
            return s;
        }
    }
}