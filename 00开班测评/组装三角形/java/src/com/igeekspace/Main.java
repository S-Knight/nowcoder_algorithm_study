package com.igeekspace;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] sticks = new int[n];

            for (int i = 0; i < n; i++) {
                sticks[i] = scanner.nextInt();
            }

            Arrays.sort(sticks);

            int count = 0;
            for (int i = 0; i < n - 2; i++) {
                for (int j = i + 1; j < n - 1; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if (sticks[i] + sticks[j] > sticks[k]) {
                            count++;
                        } else {
                            break;
                        }
                    }
                }
            }

            System.out.println(count);
        }
    }
}
