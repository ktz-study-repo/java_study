package com.github.knightpop.programmers.summer2017.prime;

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int nOfPrime = 0;

        List<Integer> sums = getSums(nums);

        for(Integer sum: sums) {
            if(isPrimeNum(sum)) nOfPrime++;
        }

        return nOfPrime;
    }

    private List<Integer> getSums(int[] nums) {
        List<Integer> sumSet = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    sumSet.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }

        return sumSet;
    }

    private boolean isPrimeNum(int num) {
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }

        return true;
    }
}