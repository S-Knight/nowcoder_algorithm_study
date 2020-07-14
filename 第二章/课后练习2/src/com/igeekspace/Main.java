package com.igeekspace;

import java.util.Scanner;

public class Main {
    private static void swapChar(char[] chars, int i, int j) {
        if (i == j) {
            return;
        }

        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    private static void insertSort(char[] chars) {
        for (int i = 1; i < chars.length; i++) {
            //非英文字母的其它字符保持原来的位置。
            if (!Character.isLetter(chars[i])) {
                continue;
            }

            int insertIndex = i;//当前要操作的数的索引
            for (int j = i - 1; j >= 0; j--) {
                if (!Character.isLetter(chars[j])) {
                    continue;
                }

                if (Character.toLowerCase(chars[insertIndex]) < Character.toLowerCase(chars[j])) {
                    swapChar(chars, insertIndex, j);
                    insertIndex = j;
                } else {
                    break;
                }
            }
        }
    }

    private static void printChars(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }

        System.out.println();
    }

    public static void main(String[] args) {
        String input;
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            input = scanner.nextLine();

            char[] charArray = input.toCharArray();

            //插入排序
            insertSort(charArray);

            printChars(charArray);
        }
    }
}
