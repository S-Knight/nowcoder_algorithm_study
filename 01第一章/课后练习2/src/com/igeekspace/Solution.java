package com.igeekspace;

public class Solution {
    private static final boolean debug = false;

    public boolean Find(int target, int[][] array) {
        if (array.length == 0 || array[0].length == 0) {
            return false;
        }

        int i = array.length - 1;
        int j = 0;

        while (j != array[0].length && i >= 0) {
            if (debug) {
                System.out.println("i is " + i + ";j is " + j + ";array[i][j] is " + array[i][j]);
            }

            if (target == array[i][j]) {
                return true;
            } else if (target > array[i][j]) {
                j++;
            } else {
                i--;
            }
        }

        return false;
    }
}