package com.github.knightpop.programmers.leve1.sumarr;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] sumArr = new int[arr1.length][arr1[0].length];

        for(int i = 0; i < sumArr.length; i++) {
            for(int j = 0; j < sumArr[0].length; j++) {
                sumArr[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        return sumArr;
    }
}