package com.github.knightpop.programmers.level1.phone;

class Solution {
    public String solution(String phone_number) {
        StringBuilder stringBuilder = new StringBuilder(phone_number);
        int idx = 0;

        for(int i = phone_number.length() - 1; i >= 0; i--) {
            if(idx >= 4) {
                stringBuilder.setCharAt(i, '*');
            }
            idx++;
        }

        return stringBuilder.toString();
    }
}