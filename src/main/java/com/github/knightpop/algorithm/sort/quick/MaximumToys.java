package com.github.knightpop.algorithm.sort.quick;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MaximumToys {

    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        quickSort(prices, 0, prices.length - 1);
        int nOfToyes = 0;
        int sumOfPrice = 0;
        for (int price : prices) {
            if((sumOfPrice + price) > k) {
                return nOfToyes;
            } else {
                nOfToyes++;
                sumOfPrice += price;
            }
        }
        
        return nOfToyes;
    }
    
    static void quickSort(int[] prices, int startIdx, int endIdx) {
        int idx = partition(prices, startIdx, endIdx);
        if(startIdx < idx - 1) {
            quickSort(prices, startIdx, idx - 1);
        }
        if(idx < endIdx) {
            quickSort(prices, idx, endIdx);
        }
    }
    
    static int partition(int[] prices, int startIdx, int endIdx) {
        int i = startIdx;
        int j = endIdx;
        int pivot = prices[(i + j) / 2];
        while(i <= j) {
            while(prices[i] < pivot) {
                i++;
            }
            while(prices[j] > pivot) {
                j--;
            }
            
            if(i <= j) {
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
                i++;
                j--;
            }
        }
        
        return i;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[] prices = new int[]{1, 12, 5, 111, 200, 1000, 10};

        int result = maximumToys(prices, 50);



        scanner.close();
    }
}
