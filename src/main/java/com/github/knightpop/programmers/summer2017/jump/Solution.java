package com.github.knightpop.programmers.summer2017.jump;

import java.util.*;

public class Solution {
    public int solution(int n) {
        return getMinJump(n);
    }

    public int getMinJump(int n) {
        if(n == 1) {
            return 1;
        }

        if(n % 2 == 0) {
            return getMinJump(n / 2);
        } else {
            return 1 + getMinJump((n - 1) / 2);
        }
    }
}