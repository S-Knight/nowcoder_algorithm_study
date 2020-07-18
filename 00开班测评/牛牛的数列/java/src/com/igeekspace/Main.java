package com.igeekspace;

import java.util.Scanner;

public class Main {
    private static final boolean debug = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();

            int[] nums = new int[n];
            int[] unchangeHelp = new int[n];
            int[] changeLastHelp = new int[n];
            int[] changeFrontHelp = new int[n];

            for (int i = 0; i < nums.length; i++) {
                nums[i] = scanner.nextInt();
            }

            unchangeHelp[0] = changeLastHelp[0] = changeFrontHelp[0] = 1;

            for (int i = 1; i < nums.length; i++) {
                changeLastHelp[i] = unchangeHelp[i - 1] + 1;
                if (nums[i] > nums[i - 1]) {
                    unchangeHelp[i] = unchangeHelp[i - 1] + 1;
                    changeFrontHelp[i] = changeFrontHelp[i - 1] + 1;
                    if (changeFrontHelp[i - 1] + 1 > changeFrontHelp[i]) {

                    }
                } else {
                    unchangeHelp[i] = 1;
                    changeFrontHelp[i] = 1;
                }

                if (i == 1) {
                    changeFrontHelp[i] = 2;
                    continue;
                }

                if (nums[i] - nums[i - 2] > 1) {
                    changeFrontHelp[i] = Math.max(changeLastHelp[i - 1] + 1, changeFrontHelp[i]);
                } else {
                    changeFrontHelp[i] = Math.max(2, changeFrontHelp[i]);
                }
            }

            int max = 1;
            for (int i = 1; i < nums.length; i++) {
                max = Math.max(max, changeFrontHelp[i]);
                max = Math.max(max, changeLastHelp[i]);
            }

            if (debug) {
                for (int i = 0; i < unchangeHelp.length; i++) {
                    System.out.print(unchangeHelp[i] + " ");
                }
                System.out.println();

                for (int i = 0; i < changeLastHelp.length; i++) {
                    System.out.print(changeLastHelp[i] + " ");
                }
                System.out.println();

                for (int i = 0; i < changeFrontHelp.length; i++) {
                    System.out.print(changeFrontHelp[i] + " ");
                }
                System.out.println();
            }

            System.out.println(max);
        }
    }
}
