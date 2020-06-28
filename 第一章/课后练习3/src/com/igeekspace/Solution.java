package com.igeekspace;

public class Solution {
    private int[] fibNums;

    public Solution() {
        fibNums = new int[40];
        fibNums[0] = 0;
        fibNums[1] = 1;

        for (int i = 2; i < 40; i++) {
            fibNums[i] = fibNums[i - 2] + fibNums[i - 1];
        }
    }

    public int Fibonacci(int n) {
        return fibNums[n];
    }
}