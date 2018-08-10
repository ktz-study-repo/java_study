package com.github.knightpop.programmers.level2.bracket;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void Test100000() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < 50000 - 2; i++) {
            stringBuilder.append('(');
        }

        for(int i = 0; i < 50000 - 2; i++) {
            stringBuilder.append(')');
        }

        stringBuilder.append(')');
        stringBuilder.append('(');
        stringBuilder.append('(');
        stringBuilder.append(')');
        Solution solution = new Solution();
        System.out.println(stringBuilder.length());
        System.out.println(solution.solution(stringBuilder.toString()));
    }

}