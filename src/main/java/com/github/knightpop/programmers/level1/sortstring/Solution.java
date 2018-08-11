package com.github.knightpop.programmers.level1.sortstring;

import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        SortedSet<String> sortedString = new TreeSet<>(getComparator(n));

        sortedString.addAll(Arrays.asList(strings));

        return sortedString.toArray(new String[sortedString.size()]);
    }

    private Comparator<String> getComparator(int n) {
        return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int nCompared = compareTo(o1, o2, n);
                if(nCompared == 0) {
                    for(int i = 0; i < Integer.min(o1.length(), o2.length()); i++) {
                        int iCompared = compareTo(o1, o2, i);
                        if(iCompared != 0) {
                            return iCompared;
                        }
                    }
                    return Integer.compare(o1.length(), o2.length());
                } else {
                    return nCompared;
                }
            }
        };
    }

    private int compareTo(String o1, String o2, int n) {
        return Character.compare(o1.charAt(n), o2.charAt(n));
    }
}