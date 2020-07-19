package com.igeekspace;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    private static final boolean debug = false;

    /**
     * 获取string的循环字符串数组（不包括string本身）
     *
     * @param string 字符串
     * @return string的循环字符串数组
     */
    private static String[] getCycleStrings(String string) {
        String[] cycleStrings = new String[string.length() - 1];

        for (int i = 0; i < cycleStrings.length; i++) {
            cycleStrings[i] = string.substring(i + 1) + string.substring(0, i + 1);

            if (string.equals(cycleStrings[i])) {
                return null;
            }
        }

        return cycleStrings;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int n;
            n = scanner.nextInt();

            HashSet<String> strings = new HashSet<>();
            //所有输入字符串能
            HashSet<String> allCycleStrings = new HashSet<>();

            for (int i = 0; i < n; i++) {
                String string = scanner.next();
                if (!allCycleStrings.contains(string)) {
                    strings.add(string);
                }

                allCycleStrings.add(string);

                String[] cycleStrings = getCycleStrings(string);

                if (cycleStrings != null) {
                    allCycleStrings.addAll(Arrays.asList(cycleStrings));
                }
            }


            System.out.println(strings.size());

            if (debug) {
                for (String string : strings) {
                    System.out.println(string);
                }
            }
        }
    }
}
