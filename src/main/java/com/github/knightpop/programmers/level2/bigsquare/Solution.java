package com.github.knightpop.programmers.level2.bigsquare;

class Solution {
    public int solution(int [][]board) {
        int maxWidth = Integer.MIN_VALUE;

        for(int y = 0; y < board.length; y++) {
            for(int x = 0; x < board[0].length; x++) {
                if(getMaxReach(board, x, y) > maxWidth)
                    maxWidth = Integer.max(maxWidth, getMaxSquareWidth(board, x, y));
            }
        }

        return (int)Math.pow(maxWidth, 2);
    }

    private int getMaxSquareWidth(int[][] board, int x, int y) {
        int maxSquare = Integer.MIN_VALUE;
        for(int width = getMaxAvailableWidth(board, x, y); width > 0; width--) {
            if(canMakeSquare(board, x, y, width)) {
                return width;
            }
        }

        return maxSquare;
    }

    private int getMaxAvailableWidth(int[][] board, int x, int y) {
        int xWidth = 0;
        int yWidth = 0;
        for(; y + yWidth < board.length; yWidth++) {
            if(board[y + yWidth][x] == 0) break;
        }

        for(; x + xWidth < board[0].length; xWidth++) {
            if(board[y][x + xWidth] == 0) break;
        }

        return Integer.min(xWidth, yWidth);
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

    private int getMaxReach(int[][] board, int x, int y) {
        return Integer.min(board.length - y, board[0].length - x);
    }
}