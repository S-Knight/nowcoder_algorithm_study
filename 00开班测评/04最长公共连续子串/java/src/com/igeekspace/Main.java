package com.igeekspace;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string1 = scanner.nextLine();
        String string2 = scanner.nextLine();

        //让string1成为较短的那一串字符串
        if (string2.length() < string1.length()) {
            String temp = string1;
            string1 = string2;
            string2 = temp;
        }

        int largestCommonLength = 0;
        for (int i = 0; i < string1.length(); i++) {
            for (int j = i + largestCommonLength + 1; j <= string1.length(); j++) {
                String substring = string1.substring(i, j);

                if (string2.contains(substring)) {
                    largestCommonLength = Math.max(substring.length(), largestCommonLength);
                }
            }
        }

        System.out.println(largestCommonLength);
    }
}
