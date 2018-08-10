package com.github.knightpop.programmers.level2.maxmin;

import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public String solution(String s) {
        int max = toIntStream(s).max().getAsInt();
        int min = toIntStream(s).min().getAsInt();

        return min + " " + max;
    }

    private IntStream toIntStream(String s) {
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt);
    }
}