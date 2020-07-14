package com.igeekspace;

import java.util.Scanner;

public class Main {
    /**
     * 交换数组两个元素的值
     *
     * @param chars 要交换的数组
     * @param i     要交换元素1的索引
     * @param j     要交换元素2的索引
     */
    private static void swapChar(char[] chars, int i, int j) {
        if (i == j) {
            return;
        }

        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    /**
     * 插入排序
     *
     * @param chars 要排序的数组
     */
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

    private static void bubbleSort(char[] chars) {
        int firstLetterIndex = findNextLetter(chars, 0);
        int secondLetterIndex = findNextLetter(chars, firstLetterIndex + 1);

        for (int i = 0; i < chars.length; i++) {
            //非英文字母的其它字符保持原来的位置。
            if (!Character.isLetter(chars[chars.length - 1 - i])) {
                continue;
            }

            int j = firstLetterIndex;
            int k = secondLetterIndex;

            while (true) {
                if (j == -1 || k == -1 || k >= chars.length - i) {
                    break;
                }

                if (Character.toLowerCase(chars[j]) > Character.toLowerCase(chars[k])) {
                    swapChar(chars, j, k);
                }

                j = k;
                k = findNextLetter(chars, k + 1);
            }
        }
    }

    /**
     * 查找从指定位置开始，字符数组里是英文字母的元素的索引
     *
     * @param chars 要查找的数组
     * @param start 起始索引
     * @return 如果能找到，则返回英文字母的元素的索引，否则返回-1
     */
    private static int findNextLetter(char[] chars, int start) {
        if (start < 0) {
            start = 0;
        }

        for (int i = start; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                return i;
            }
        }

        return -1;
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
            //insertSort(charArray);

            //冒泡排序
            bubbleSort(charArray);

            printChars(charArray);
        }
    }
}
