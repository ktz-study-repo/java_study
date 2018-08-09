package com.github.knightpop.programmers.leve1.squar;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < b; i++) {
            for(int j = 0; j < a; j++) {
                stringBuilder.append('*');
            }
            stringBuilder.append('\n');
        }

        System.out.println(stringBuilder.toString());
    }
}