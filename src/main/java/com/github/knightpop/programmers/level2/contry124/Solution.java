package com.github.knightpop.programmers.level2.contry124;

import java.util.*;

class Solution {
    public String solution(int n) {
        Stack<Integer> thirdStack = mkThirdStack(n + 1);
        for(int i = 0; i < thirdStack.size(); i++) {
            thirdStack.set(i, convertTo124(thirdStack.get(i)));
        }

        return stackToString(thirdStack);
    }

    private Stack<Integer> mkThirdStack(int n) {
        Stack<Integer> thirdStack = new Stack<>();
        while(n >= 3) {
            thirdStack.push(n % 3);
            n = n / 3;
        }

        thirdStack.push(n);

        return thirdStack;
    }

    private int convertTo124(int n) {
        if(n == 0) return 1;
        else if(n == 1) return 2;
        else return 4;
    }

    private String stackToString(Stack<Integer> s) {
        StringBuilder stringBuilder = new StringBuilder();
        while(s.isEmpty()) {
            stringBuilder.append(s.pop());
        }

        return stringBuilder.toString();
    }
}