package com.github.knightpop.programmers.leve1.divide;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void WrongTest() {
        Solution solution = new Solution();
        int[] solution1 = solution.solution(new int[]{2, 36, 1, 3}, 1);
        System.out.println(solution);
    }

    @Test
    public void getIntegerTest() {
        Assert.assertTrue(1.00 % 1 == 0);
        Assert.assertFalse(1.1 % 1 == 0);
    }

}