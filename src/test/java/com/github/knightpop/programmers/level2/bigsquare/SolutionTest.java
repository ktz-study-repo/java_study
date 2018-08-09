package com.github.knightpop.programmers.level2.bigsquare;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void ArrayTest() {
        Solution solution = new Solution();
        solution.solution(new int[][]{{0, 0, 1, 1}, {1, 1, 1, 1}});
    }
}