package com.github.knightpop.programmers.leve1.year2016;

import java.util.*;

class Solution {
    public List<String> DATE = Arrays.asList("SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT");
    public List<Integer> N_OF_DATE_IN_MONTH = Arrays.asList(
            31,
            29,
            31,
            30,
            31,
            30,
            31,
            31,
            30,
            31,
            30,
            31
    );

    public String solution(int a, int b) {
        int monthInN = a - 1;
        int dateInN = b - 1;

        int nOfDay = calculateNOfDay(monthInN, dateInN);

        return getDateOfMonth(nOfDay);
    }

    private String getDateOfMonth(int nOfDay) {
        return DATE.get((nOfDay + 5) % 7);
    }

    private int calculateNOfDay(int month, int day) {
        int dayOfMonth = getDayOfMonth(month);
        return dayOfMonth + day;
    }

    private int getDayOfMonth(int month) {
        int sumOfDate = 0;
        for(int i = 0; i < month; i++) {
            sumOfDate += N_OF_DATE_IN_MONTH.get(i);
        }

        return sumOfDate;
    }
}