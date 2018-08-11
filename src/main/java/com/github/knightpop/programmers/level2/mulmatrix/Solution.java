package com.github.knightpop.programmers.level2.mulmatrix;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int answer[][] = new int[arr1.length][arr2[0].length];

        for(int arr1Row = 0; arr1Row < arr1.length; arr1Row++) {
            for(int arr2Column = 0; arr2Column < arr2[0].length; arr2Column++) {
                answer[arr1Row][arr2Column] = mul(getRow(arr1, arr1Row), getColumn(arr2, arr2Column));
            }
        }


        return answer;
    }

    private int mul(int[] arr1, int[] arr2) {
        int result = 0;

        for(int i = 0; i < arr1.length; i++) {
            result += (arr1[i] * arr2[i]);
        }

        return result;
    }

    public int[] getRow(int[][] arr, int rowIdx) {
        return arr[rowIdx];
    }

    public int[] getColumn(int[][] arr, int columnIdx) {
        int[] column = new int[arr.length];

        for(int i = 0; i < column.length; i++) {
            column[i] = arr[i][columnIdx];
        }

        return column;
    }
}