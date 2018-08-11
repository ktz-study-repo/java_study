package com.github.knightpop.programmers.level1.gcdnlcm;

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = {getGcd(n, m), getLcm(n, m)};
        return answer;
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