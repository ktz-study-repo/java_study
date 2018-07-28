package com.github.knightpop.algorithm.sort.quick;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class QuickSortTest {
    @Test
    public void ArrayTest() {
        int[] a = new int[]{1,2};
        List<Integer> b = Arrays.asList(1,2);
        swapPrimitive(a);
        swapArray(b);
        assertEquals(new Integer(a[0]), b.get(0));
        assertEquals(new Integer(a[1]), b.get(1));
    }

    public void swapPrimitive(int arr[]) {
        int tmp = arr[0];
        arr[0] = arr[1];
        arr[1] = tmp;
    }

    public void swapArray(List<Integer> arr) {
        int tmp = arr.get(0);
        arr.set(0, arr.get(1));
        arr.set(1, tmp);
    }
}