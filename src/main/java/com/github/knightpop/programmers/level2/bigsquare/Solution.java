package com.github.knightpop.programmers.level2.bigsquare;

class Solution {
    public int solution(int [][]board) {
        int maxSquare = Integer.MIN_VALUE;

        for(int y = 0; y < board.length; y++) {
            for(int x = 0; x < board[0].length; x++) {
                maxSquare = Integer.max(maxSquare, getMaxSquare(board, x, y));
            }
        }

        return maxSquare;
    }

    private int getMaxSquare(int[][] board, int x, int y) {
        int maxSquare = Integer.MIN_VALUE;
        for(int width = 1; width <= board.length; width++) {
            if(canMakeSquare(board, x, y, width)) {
                maxSquare = (int)Math.pow(width, 2);
            } else {
                return maxSquare;
            }
        }

        return maxSquare;
    }

    private boolean canMakeSquare(int[][] board, int x, int y, int width) {
        if(board.length < y + width || board[0].length < x + width) return false;

        for(int row = y; row < y + width; row++) {
            for(int column = x; column < x + width; column++) {
                if(board[row][column] == 0) return false;
            }
        }

        return true;
    }
}