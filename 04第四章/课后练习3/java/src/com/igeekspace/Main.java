package com.igeekspace;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer> leftNums;

    private static void init() {
        leftNums = new ArrayList<>();

        leftNums.add(0);

        for (int i = 1; i < 11; i++) {
            leftNums.add((int) (Math.pow(2, i) - 1));
        }
    }

    public static void main(String[] args) {
        init();

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();

            for (int i = 0; i < leftNums.size(); i++) {
                if (num < leftNums.get(i)) {
                    System.out.println(leftNums.get(i - 1));
                    break;
                } else if (num == leftNums.get(i)) {
                    System.out.println(leftNums.get(i));
                    break;
                }
            }
        }
    }
}
