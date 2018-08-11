package com.github.knightpop.programmers.level1.findkim;

class Solution {
    public String solution(String[] seoul) {
        for(int i = 0; i < seoul.length; i++) {
            if(isKim(seoul[i])) {
                return mkSentence(i);
            }
        }

        return "";
    }

    private boolean isKim(String name) {
        return name.equals("Kim");
    }

    private String mkSentence(int idx) {
        return "김서방은 " + idx + "에 있다";
    }
}