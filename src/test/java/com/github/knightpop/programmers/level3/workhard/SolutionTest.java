package com.github.knightpop.programmers.level3.workhard;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void ZeroTest() {
        Solution solution = new Solution();
        System.out.println(solution.solution(3, new int[]{1, 2}));
    }

    @Test
    public void rangeExample() {
        IntStream.rangeClosed(0, 10).forEach(System.out::println);
    }

}