package com.example.ktz.algorithm.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RansomNote {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }
        Boolean result = canMakeRansom(mkHashMap(magazine), mkHashMap(ransom));
        if(result) System.out.println("Yes");
        else System.out.println("No");
    }

    public static Boolean canMakeRansom(Map<String, Integer> magazineMap, Map<String, Integer> ransomMap) {
        for(Map.Entry<String, Integer> elem : ransomMap.entrySet()) {
            if(!magazineMap.containsKey(elem.getKey())) return false;
      else if(magazineMap.get(elem.getKey()) < elem.getValue()){
                return false;
            }
        }
        return true;
    }

    public static Map<String, Integer> mkHashMap(String[] words) {
        Map<String, Integer> acc = new HashMap<>();
        for(String word : words) {
            if(!acc.containsKey(word)) {
                acc.put(word, 0);
            }
            acc.put(word, acc.get(word) + 1);
        }

        return acc;
    }
}

