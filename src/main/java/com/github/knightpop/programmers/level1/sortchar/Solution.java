package com.github.knightpop.programmers.level1.sortchar;

import java.util.*;

class Solution {
    public String solution(String s) { ;

        List<Character> characterList = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            characterList.add(s.charAt(i));
        }

        characterList.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return Character.compare(o1, o2) * -1;
            }
        });

        StringBuilder stringBuilder = new StringBuilder();

        for(Character c: characterList) {
            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }
}