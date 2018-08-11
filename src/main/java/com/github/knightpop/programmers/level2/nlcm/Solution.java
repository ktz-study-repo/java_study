package com.github.knightpop.programmers.level2.nlcm;

class Solution {
    public int solution(int[] arr) {
        int lcm = arr[0];

        for(int i = 1; i < arr.length; i++) {
            lcm = getLcm(lcm, arr[i]);
        }

        return lcm;
    }

    int getGcd(int a, int b){
        while(b!=0){
            int r = a%b;
            a= b;
            b= r;
        }
        return a;
    }

    int getLcm(int a, int b){
        return a * b / getGcd(a,b);
    }
}