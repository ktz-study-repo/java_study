package com.example.ktz.algorithm.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MakingAnagram {
    public static int numberNeeded(String first, String second) {
        Map<Character, Integer> firstMap = mkHashMap(first);
        Map<Character, Integer> secondMap = mkHashMap(second);
        for (Map.Entry<Character, Integer> elem : firstMap.entrySet()) {
            if(secondMap.containsKey(elem.getKey())) {
                Integer minValue = getMinValue(firstMap, secondMap, elem.getKey());
                firstMap.put(elem.getKey(), firstMap.get(elem.getKey()) - minValue);
                secondMap.put(elem.getKey(), secondMap.get(elem.getKey()) - minValue);
            }
        }
        Integer result = 0;
        result += sumOfValue(firstMap);
        result += sumOfValue(secondMap);
        return result;
    }

    public static Integer getMinValue(Map<Character, Integer> aMap, Map<Character, Integer> bMap, Character key) {
        return Integer.min(aMap.get(key), bMap.get(key));
    }

    public static Integer sumOfValue(Map<Character, Integer> mapToSum) {
        return mapToSum.values().stream().reduce(0, (acc, v) -> acc + v, (acc1, acc2) -> acc1 + acc2);
    }

    public static Map<Character, Integer> mkHashMap(String target) {
        Map<Character, Integer> acc = new HashMap<>();
        for(char c : target.toCharArray()) {
            if(!acc.containsKey(c)) {
                acc.put(c, 0);
            }
            acc.put(c, acc.get(c) + 1);
        }
        return acc;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}





