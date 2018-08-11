package com.github.knightpop.programmers.level1.sorteachint;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SolutionTest {

    @Test
    public void WrongTest() {
        Solution solution = new Solution();
        System.out.println(solution.solution(118372));
    }

    @Test
    public void SortDuplicated() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 3, 4, 5);

        integers.sort(Integer::compareTo);
        integers.forEach(System.out::println);
    }

    @Test
    public void SortStream() {
        IntStream stream = Arrays.stream(new int[]{1, 2, 3, 3, 4, 5});
        int[] ints = stream.sorted().toArray();

        for(int i : ints) {
            System.out.println(i);
        }
    }

    @Test
    public void removeInOther() {
        List<Integer> integerList = Arrays.stream(new int[]{1, 2, 3, 3, 4, 5}).boxed().collect(Collectors.toList());
        popLast(integerList);

        integerList.forEach(System.out::println);
    }

    public int popLast(List<Integer> a) {
        Integer integer = a.get(a.size() - 1);

        a.remove(a.size() - 1);

        return integer;
    }

    @Test
    public void toBinaryString() {
        System.out.println(Integer.toBinaryString(3));
    }
}