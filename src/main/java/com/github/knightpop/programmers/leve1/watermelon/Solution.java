package com.github.knightpop.programmers.leve1.watermelon;

class Solution {
    public String solution(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < n; i++) {
            if(isEven(i)) {
                stringBuilder.append('수');
            } else {
                stringBuilder.append('박');
            }
        }

        return stringBuilder.toString();
    }

    private boolean isEven(int idx) {
        return idx % 2 == 0;
    }
}