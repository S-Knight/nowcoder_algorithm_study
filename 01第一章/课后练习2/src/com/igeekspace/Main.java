package com.igeekspace;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] array = new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};

        System.out.println(solution.Find(15, array));
    }
}
