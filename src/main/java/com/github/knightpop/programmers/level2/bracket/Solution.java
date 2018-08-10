package com.github.knightpop.programmers.level2.bracket;

import java.util.*;

class Solution {
    boolean solution(String s) {
        if(!isValid(s)) return false;

        Stack<Character> brackets = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(isOpened(c)) {
                brackets.push(c);
            } else if(brackets.isEmpty()) {
              return false;
            } else {
                char oldC = brackets.pop();
                if(!isOpened(oldC)) {
                    return false;
                }
            }
        }

        return brackets.isEmpty();
    }

    private boolean isOpened(char c) {
        return c == '(';
    }

    private boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;
        if(!s.isEmpty()) {
            return isOpened(s.charAt(0)) && !isOpened(s.charAt(s.length() - 1));
        } else {
            return true;
        }

    }
}