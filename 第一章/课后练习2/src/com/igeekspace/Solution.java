package com.igeekspace;

public class Solution {
    private boolean binSearch(int target, int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (true) {
            int middle = (left + right) / 2;

            if (target == array[middle]) {
                return true;
            } else if (target < array[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }

            if (left > right) {
                return false;
            }
        }
    }

    public boolean Find(int target, int[][] array) {
        if (array.length == 0 || array[0].length == 0) {
            return false;
        }

        for (int i = 0; i < array.length; i++) {
            if (target >= array[i][0]) {
                if (binSearch(target, array[i])) {
                    return true;
                }
            } else {
                return false;
            }
        }

        return false;
    }
}