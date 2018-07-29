package com.github.knightpop.algorithm.sort.merge;

import java.util.*;

public class MergeSort<T extends Comparable<T>> {
    public List<T> mergeSort(List<T> listToSort) {
        if(listToSort.size() > 1) {
            int pivotIdx = getPivotIdx(listToSort);
            return mergeList(mergeSort(listToSort.subList(0, pivotIdx)), mergeSort(listToSort.subList(pivotIdx, listToSort.size())));
        } else {
            return listToSort;
        }
    }

    private int getPivotIdx(List<T> listToSort) {
        return listToSort.size() / 2;
    }

    private List<T> mergeList(List<T> listA, List<T> listB) {
        List<T> mergedList = new ArrayList<T>();
        int aIdx = 0;
        int bIdx = 0;
        while (!isEmpty(listA, aIdx) || !isEmpty(listB, bIdx)) {
            if(compareTo(listA, aIdx, listB, bIdx) < 0) {
                mergedList.add(listA.get(aIdx));
                aIdx++;
            } else {
                mergedList.add(listB.get(bIdx));
                bIdx++;
            }
        }

        return mergedList;
    }

    private int compareTo(List<T> listA, int aIdx, List<T> listB, int bIdx) {
        if(isEmpty(listB, bIdx) || (!isEmpty(listA, aIdx) && listA.get(aIdx).compareTo(listB.get(bIdx)) < 0)) {
            return -1;
        } else {
            return 1;
        }
    }

    private boolean isEmpty(List<T> listA, int aIdx) {
        return aIdx >= listA.size();
    }

    public static void main(String[] args) {
        MergeSort<Integer> integerMergeSort = new MergeSort<>();

        List<Integer> mergedList = integerMergeSort.mergeSort(Arrays.asList(1, 12, 5, 26, 7, 14, 3, 7, 2));
        mergedList.forEach(System.out::println);
    }
}
