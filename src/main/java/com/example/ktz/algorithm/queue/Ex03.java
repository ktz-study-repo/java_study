package com.example.ktz.algorithm.queue;

import java.util.List;
import java.util.ArrayList;

public class Ex03 {
    public final static int threathold = 5;
    public static List<List<Integer>> ints = new ArrayList<List<Integer>>();
    public static int idx = -1;

    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        push(4);
        push(5);
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
    }

    public static void push(Integer valueToAdd) {
        int x = (idx + 1) / threathold;
        if(ints.size() < x + 1) {
            ints.add(new ArrayList<Integer>());
        }
        ints.get(x).add(valueToAdd);
        idx += 1;
    }

    public static Integer pop() {
        if(idx < 0) return null;
        int x = idx / 5;
        int y = idx % 5;
        Integer result = ints.get(x).get(y);
        ints.get(x).remove(y);
        if(ints.get(x).size() == 0) {
            ints.remove(x);
        }
        idx -= 1;
        return result;
    }

}
