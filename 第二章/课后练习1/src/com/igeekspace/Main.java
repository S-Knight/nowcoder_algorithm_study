package com.igeekspace;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /**
     * 输入整型数组和排序标识，对其元素按照升序或降序进行排序
     *
     * @param pIntegerArray 整型数组
     * @param iSortFlag     排序标识：0表示按升序，1表示按降序
     */
    private static void bubbleSort(Integer[] pIntegerArray, int iSortFlag) {
        for (int i = 0; i < pIntegerArray.length; i++) {
            for (int j = 1; j < pIntegerArray.length - i; j++) {
                if (pIntegerArray[j - 1] > pIntegerArray[j]) {
                    Integer temp = pIntegerArray[j];
                    pIntegerArray[j] = pIntegerArray[j - 1];
                    pIntegerArray[j - 1] = temp;
                }
            }
        }

        printArray(pIntegerArray, iSortFlag);
    }

    /**
     * 根据排序要求，输出数组的内容
     *
     * @param pIntegerArray 整型数组
     * @param iSortFlag     排序标识：0表示按升序，1表示按降序
     */
    private static void printArray(Integer[] pIntegerArray, int iSortFlag) {
        if (iSortFlag == 0) {
            for (int i = 0; i < pIntegerArray.length; i++) {
                System.out.print(pIntegerArray[i]);

                if (i != pIntegerArray.length - 1) {
                    System.out.print(" ");
                }
            }
        } else {
            for (int i = pIntegerArray.length - 1; i >= 0; i--) {
                System.out.print(pIntegerArray[i]);

                if (i != 0) {
                    System.out.print(" ");
                }
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int numCount = scanner.nextInt();

            if (numCount == 0) {
                continue;
            }

            Integer[] pIntegerArray = new Integer[numCount];
            for (int i = 0; i < numCount; i++) {
                pIntegerArray[i] = scanner.nextInt();
            }

            int iSortFlag = scanner.nextInt();
            Arrays.sort(pIntegerArray);
            printArray(pIntegerArray, iSortFlag);
        }
    }
}
