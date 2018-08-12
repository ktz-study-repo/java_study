package com.github.knightpop.programmers.summer2017.end2end;

import java.util.HashSet;
import java.util.Set;

class Solution {
    private Set<String> wordSet = new HashSet<>();
    private String prevWord = null;

    public int[] solution(int nOfPlayer, String[] words) {
        for(int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            if(!isValidWord(currentWord)) {
                return getCurrentPosition(nOfPlayer, i);
            }
            wordSet.add(currentWord);
            prevWord = currentWord;
        }

        return new int[]{0, 0};
    }

    private boolean isValidWord(String wordToCheck) {
        if(prevWord == null) return true;

        return !wordSet.contains(wordToCheck) &&
                prevWord.charAt(prevWord.length() - 1) == wordToCheck.charAt(0);
    }

    private int[] getCurrentPosition(int nOfPlayer, int i) {
        int[] currentPosition = new int[2];
        currentPosition[0] = getCurrentPlayer(nOfPlayer, i);
        currentPosition[1] = getCurrentRound(nOfPlayer, i);

        return currentPosition;
    }

    private int getCurrentRound(int nOfPlayer, int i) {
        return (i / nOfPlayer) + 1;
    }

    private int getCurrentPlayer(int nOfPlayer, int i) {
        return (i % nOfPlayer) + 1;
    }
}