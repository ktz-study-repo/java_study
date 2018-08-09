package com.github.knightpop.programmers.leve1.isnumber;

class Solution {
    public boolean solution(String s) {
        if(s.length() == 4 || s.length() == 6) {


            for (int i = 0; i < s.length(); i++) {
                if (!isNumber(s.charAt(i)))
                    return false;
            }

            return true;
        }

        return false;
    }

    private boolean isNumber(char c) {
        return '0' <= c && c <= '9';
    }
}