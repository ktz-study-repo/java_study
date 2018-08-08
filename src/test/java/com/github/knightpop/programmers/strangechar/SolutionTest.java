package com.github.knightpop.programmers.strangechar;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void HelloWorldStr() {
        Solution solution = new Solution();

        String hello = solution.solution("Hel     lo");

        System.out.println(hello);
    }
}