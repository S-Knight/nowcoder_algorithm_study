package com.igeekspace;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /**
     * 交换数组中两个位置的值
     *
     * @param pIntegerArray 要操作的数组
     * @param i             要交换的元素索引i
     * @param j             要交换的元素索引j
     */
    private static void swapArrayElement(Integer[] pIntegerArray, int i, int j) {
        Integer temp = pIntegerArray[j];
        pIntegerArray[j] = pIntegerArray[i];
        pIntegerArray[i] = temp;
    }

    /**
     * 冒泡排序
     * 对元素按照升序进行排序
     *
     * @param pIntegerArray 整型数组
     */
    private static void bubbleSort(Integer[] pIntegerArray) {
        for (int i = 0; i < pIntegerArray.length; i++) {
            for (int j = 1; j < pIntegerArray.length - i; j++) {
                if (pIntegerArray[j - 1] > pIntegerArray[j]) {
                    swapArrayElement(pIntegerArray, j, j - 1);
                }
            }
        }
    }


    /**
     * 选择排序
     * 对元素按照升序进行排序
     *
     * @param pIntegerArray 整型数组
     */
    private static void selectSort(Integer[] pIntegerArray) {
        for (int i = 0; i < pIntegerArray.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < pIntegerArray.length; j++) {
                if (pIntegerArray[j] < pIntegerArray[minIndex])
                    minIndex = j;
            }

            swapArrayElement(pIntegerArray, i, minIndex);
        }
    }

    /**
     * 插入排序
     * 对元素按照升序进行排序
     *
     * @param pIntegerArray 整型数组
     */
    private static void insertSort(Integer[] pIntegerArray) {
        for (int i = 0; i < pIntegerArray.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (pIntegerArray[j] < pIntegerArray[j - 1]) {
                    swapArrayElement(pIntegerArray, j, j - 1);
                }
            }
        }
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

            //Util库的sort排序
            //Arrays.sort(pIntegerArray);

            //冒泡排序
            //bubbleSort(pIntegerArray);

            //选择排序
            //selectSort(pIntegerArray);

            //插入排序
            insertSort(pIntegerArray);
            printArray(pIntegerArray, iSortFlag);
        }
    }
}
