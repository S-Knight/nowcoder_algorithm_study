package com.igeekspace;

public class Solution {
    private boolean binSearch(int target, int[][] array, int leftI, int leftJ, int rightI, int rightJ) {
        if (leftI > rightI || leftJ > rightJ) {
            return false;
        }

        int middleI = (leftI + rightI) / 2;
        int middleJ = (leftJ + rightJ) / 2;

        if (target == array[middleI][middleJ]) {
            return true;
        } else if (target > array[middleI][middleJ]) {
            return binSearch(target, array, leftI, middleJ + 1, middleI, rightJ)
                    || binSearch(target, array, middleI + 1, leftJ, rightI, rightJ);
        } else {
            return binSearch(target, array, leftI, leftJ, rightI, middleJ - 1)
                    || binSearch(target, array, leftI, middleJ, middleI - 1, rightJ);
        }
    }

    public boolean Find(int target, int[][] array) {
        if (array.length == 0 || array[0].length == 0) {
            return false;
        }

        return binSearch(target, array, 0, 0, array.length - 1, array[0].length - 1);
    }
}