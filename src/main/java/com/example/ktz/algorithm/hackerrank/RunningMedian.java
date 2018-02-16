package com.example.ktz.algorithm.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RunningMedian {

    public static List<Integer> sort(List<Integer> intsToSort) {
        Collections.sort(intsToSort);
        return intsToSort;
    }

    public static Double getMidium(List<Integer> intsToSort) {
        Integer midiumIdx = intsToSort.size() / 2;
        if(intsToSort.size() % 2 == 0) {
            return (intsToSort.get(midiumIdx - 1) + intsToSort.get(midiumIdx)) / 2.0;
        } else {
            return new Double(intsToSort.get(midiumIdx));
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> a = new ArrayList<Integer>();
        for(int a_i=0; a_i < n; a_i++){
            a.add(in.nextInt());
            sort(a);
            System.out.println(getMidium(a));
        }
    }
}
