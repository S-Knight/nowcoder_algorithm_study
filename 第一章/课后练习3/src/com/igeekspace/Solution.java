package com.igeekspace;

public class Solution {
    public int Fibonacci(int n) {
        int[] previous = new int[]{0, 1};

        if (n < 2) {
            return previous[n];
        }

        int previousI = 0;
        for (int i = 2; i <= n; i++) {
            previousI = previous[0] + previous[1];
            previous[0] = previous[1];
            previous[1] = previousI;
        }

        return previous[1];
    }
}