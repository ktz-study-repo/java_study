package com.github.knightpop.algorithm.sort.quick;

public class QuickSort<T extends Comparable<T>> {
    int partition(T[] arr, int startIdx, int endIdx) {
        int i = startIdx;
        int j = endIdx;

        T pivot = getPivot(arr, startIdx, endIdx);

        while(i <= j) {
            while(arr[i].compareTo(pivot) < 0) {
                i++;
            }
            while(arr[j].compareTo(pivot) > 0) {
                j--;
            }

            if(i <= j) {
                T tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }

        return i;
    }

    void quickSork(T[] arr, int startIdx, int endIdx) {
        int idx = partition(arr, startIdx, endIdx);

        if(startIdx < idx - 1) {
            quickSork(arr, startIdx, idx - 1);
        }
        if(idx < endIdx) {
            quickSork(arr, idx, endIdx);
        }
    }

    T getPivot(T[] arr, int startIdx, int endIdx) {
        return arr[(startIdx + endIdx) / 2];
    }

    public static void main(String[] args) {
        QuickSort<Integer> integerQuickSort = new QuickSort<>();
        Integer[] arr = new Integer[]{1, 12, 5, 26, 7, 14, 3, 7, 2};
        integerQuickSort.quickSork(arr, 0, arr.length - 1);
        for(Integer i : arr) {
            System.out.println(i);
        }
    }
}
