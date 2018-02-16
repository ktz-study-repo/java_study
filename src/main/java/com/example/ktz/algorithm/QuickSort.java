package com.example.ktz.algorithm;


import java.util.*;

public class QuickSort {
    public static class Quicksort {
        public static List<Integer> sort(List<Integer> intsToSort) {
            return sortLoop(intsToSort, 0, intsToSort.size() - 1);
        }

        public static List<Integer> sortLoop(List<Integer> intsToSort, Integer low, Integer high) {
            Integer leftStart = low;
            Integer rightStart = high;
            Integer pivot = intsToSort.get((low + high)/2);

            while(leftStart <= rightStart) {
                while (intsToSort.get(leftStart) < pivot) leftStart++;
                while (intsToSort.get(rightStart) > pivot) rightStart--;
                if (leftStart <= rightStart) {
                    swap(intsToSort, leftStart, rightStart);
                    leftStart++;
                    rightStart--;
                }
            }

            if(low < rightStart)
                sortLoop(intsToSort, low, rightStart);
            if(leftStart < high)
                sortLoop(intsToSort, leftStart, high);

            return intsToSort;
        }

        public static void swap(List<Integer> intsToSwap, Integer i, Integer j) {
            Integer temp = intsToSwap.get(i);
            intsToSwap.set(i, intsToSwap.get(j));
            intsToSwap.set(j, temp);
        }
    }

    public static void main(String[] args){
        List<Integer> result = Quicksort.sort(new ArrayList<Integer>(Arrays.asList( 5, 5, 6, 6, 4, 4, 5, 5, 4, 4, 6, 6, 5, 5 )));
        System.out.println(result);
    }
}