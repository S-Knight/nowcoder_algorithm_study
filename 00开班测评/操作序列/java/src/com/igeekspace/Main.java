package com.igeekspace;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] indexs = new int[n];
            int[] nums = new int[n];

            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }

            int temp = n;
            int i = 0;
            do {
                indexs[i++] = temp - 1;
                temp -= 2;

            } while (temp >= 1);

            temp = n - 1;
            i = n - 1;
            do {
                indexs[i--] = temp - 1;
                temp -= 2;
            } while (temp >= 1);

            for (int j = 0; j < indexs.length; j++) {
                System.out.print(nums[indexs[j]]);

                if (j == indexs.length - 1) {
                    System.out.println();
                } else {
                    System.out.print(" ");
                }
            }
        }
    }
}
