package com.github.knightpop.programmers.meister.pocketmon;

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int nOfPocketmonCanGet = nums.length / 2;
        Set<Integer> pocketmonSet = getPocketmonSet(nums);

        return Integer.min(nOfPocketmonCanGet, pocketmonSet.size());
    }

    private Set<Integer> getPocketmonSet(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for(int num : nums) {
            numSet.add(num);
        }

        return numSet;
    }
}