package com.igeekspace;

import java.util.HashSet;
import java.util.Iterator;
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
            HashSet<String> processedStrings = new HashSet<>();

            for (int i = 0; i < n; i++) {
                strings.add(scanner.next());
            }

            Iterator<String> it = strings.iterator();
            while (it.hasNext()) {
                String string = it.next();
                if (processedStrings.contains(string)) {
                    continue;
                }

                String[] cycleStrings = getCycleStrings(string);

                if (cycleStrings != null) {
                    boolean removeSuccess = false;
                    for (String cycleString : cycleStrings) {
                        if (strings.remove(cycleString)) {
                            removeSuccess = true;
                        }
                    }

                    if (removeSuccess) {
                        it = strings.iterator();
                    }
                }

                processedStrings.add(string);
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
