package com.igeekspace;

import java.util.*;

public class ShortSubsequence {
    private static final boolean debug = false;

    private void swap(int[] A, int i, int j) {
        if (i == j) {
            return;
        }

        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private int selectSort(int[] A) {
        int[] tempArray = Arrays.copyOf(A, A.length);
        //升序排序需要调整的长度
        int ascLength = getSelectSortLength(tempArray, 0);
        tempArray = Arrays.copyOf(A, A.length);
        //降序排序需要调整的长度
        int descLength = getSelectSortLength(tempArray, 1);

        if (debug) {
            System.out.println("ascLength is " + ascLength);
            System.out.println("descLength is " + descLength);
        }

        return Math.min(ascLength, descLength);
    }

    /**
     * 计算选择排序需要排序的子数组的长度
     *
     * @param A        要排序的数组
     * @param sortType 0：升序排序 1：降序排序
     * @return 需要排序的子数组的长度
     */
    private int getSelectSortLength(int[] A, int sortType) {
        int left = -1;
        int right = -1;
        //从小到大排序
        for (int i = 0; i < A.length - 1; i++) {
            int minOrMaxIndex = i;
            for (int j = i + 1; j < A.length; j++) {
                if (sortType == 0) {
                    if (A[j] < A[minOrMaxIndex]) {
                        minOrMaxIndex = j;
                    }
                } else {
                    if (A[j] > A[minOrMaxIndex]) {
                        minOrMaxIndex = j;
                    }
                }
            }

            //位置i的元素需要调整
            if (i != minOrMaxIndex) {
                if (left == -1) {
                    left = i;
                }

                if (minOrMaxIndex > right) {
                    right = minOrMaxIndex;
                }
            }
            swap(A, i, minOrMaxIndex);
        }

        if (debug) {
            System.out.println("right is " + right);
            System.out.println("left is " + left);
        }

        return right - left > 0 ? right - left + 1 : 0;
    }

    public int findShortest(int[] A, int n) {
        return selectSort(A);
    }
}