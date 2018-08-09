package com.github.knightpop.programmers.leve1.strangechar;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void HelloWorldStr() {
        Solution solution = new Solution();

        String hello = solution.solution("Hel     lo");

        System.out.println(hello);
    }
}