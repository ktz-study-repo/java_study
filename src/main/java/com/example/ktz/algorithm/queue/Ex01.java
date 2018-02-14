package com.example.ktz.algorithm.queue;

import java.util.List;
import java.util.ArrayList;

public class Ex01 {
    public static List<Integer> ints = new ArrayList<Integer>();
    public static int[] idx = {-3, -2, -1};

    public static void main(String[] args) {
        push(0, 1);
        push(0, 2);
        push(0, 3);
        push(0, 4);
        push(0, 5);
        push(1, -1);
        push(1, -2);
        push(1, -3);
        push(1, -4);
        push(1, -5);
        System.out.println(pop(0));
        System.out.println(pop(1));
        System.out.println(pop(2));
    }

    public static void push(int stackNo, Integer valueToAdd) {
        int idxNo = idx[stackNo] + 3;
        extendList(idxNo + 1);
        ints.set(idxNo, valueToAdd);
        idx[stackNo] = idxNo;
    }

    public static Integer pop(int stackNo) {
        int idxNo = idx[stackNo];
        if(idxNo < 0) {
            return null;
        } else {
            Integer result = ints.get(idxNo);
            ints.set(idxNo, null);
            shrink();
            idx[stackNo] = idxNo - 3;
            return result;
        }
    }

    public static void shrink() {
        for(int i = ints.size() - 1; ints.get(i) == null; i--) {
            ints.remove(i);
        }
    }

    private static void extendList(int size) {
        while(ints.size() < size)  {
            ints.add(null);
        }
    }
}

