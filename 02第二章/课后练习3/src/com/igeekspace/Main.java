package com.igeekspace;

public class Main {

    public static void main(String[] args) {
        ShortSubsequence shortSubsequence = new ShortSubsequence();
        int[] array = new int[]{1, 5, 3, 4, 2, 6, 7};

        System.out.println(shortSubsequence.findShortest(array, array.length));

        array = new int[]{7, 4, 4, 4, 4, 4, 9};
        System.out.println(shortSubsequence.findShortest(array, array.length));
    }
}
