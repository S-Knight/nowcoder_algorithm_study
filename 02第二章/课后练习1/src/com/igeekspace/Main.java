package com.igeekspace;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final boolean debug = false;

    /**
     * 交换数组中两个位置的值
     *
     * @param pIntegerArray 要操作的数组
     * @param i             要交换的元素索引i
     * @param j             要交换的元素索引j
     */
    private static void swapArrayElement(Integer[] pIntegerArray, int i, int j) {
        if (i == j) {
            return;
        }

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
     * 希尔排序
     * 对元素按照升序进行排序
     *
     * @param pIntegerArray 整型数组
     */
    private static void shellSort(Integer[] pIntegerArray) {
        for (int gap = pIntegerArray.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < pIntegerArray.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    while (pIntegerArray[j + gap] < pIntegerArray[j]) {
                        swapArrayElement(pIntegerArray, j + gap, j);
                    }
                }
            }
        }
    }

    /**
     * 归并排序
     * 对元素按照升序进行排序
     *
     * @param pIntegerArray 整型数组
     */
    private static void mergeSort(Integer[] pIntegerArray, int left, int right) {
        if (left >= right) {
            return;
        }

        int middle = left + (right - left >> 1);

        mergeSort(pIntegerArray, left, middle);
        mergeSort(pIntegerArray, middle + 1, right);

        merge(pIntegerArray, left, middle, right);
    }

    /**
     * 合并归并排序的左右两个数组
     *
     * @param pIntegerArray 整型数组
     * @param left          左数组开头索引
     * @param middle        left和right的平均值，为了减少计算量直接传进去
     * @param right         右数组的结尾索引
     */
    private static void merge(Integer[] pIntegerArray, int left, int middle, int right) {
        int i = left;
        int j = middle + 1;
        int k = 0;
        Integer[] help = new Integer[right - left + 1];

        while (i <= middle && j <= right) {
            help[k++] = pIntegerArray[i] <= pIntegerArray[j] ? pIntegerArray[i++] : pIntegerArray[j++];
        }

        while (i <= middle) {
            help[k++] = pIntegerArray[i++];
        }

        while (j <= right) {
            help[k++] = pIntegerArray[j++];
        }

        for (i = 0; i < help.length; i++) {
            pIntegerArray[left + i] = help[i];
        }
    }

    /**
     * 堆排序
     * 对元素按照升序进行排序
     *
     * @param pIntegerArray 整型数组
     */
    private static void heapSort(Integer[] pIntegerArray) {
        if (pIntegerArray.length < 2) {
            return;
        }

        //初始化大根堆
        initBigHeap(pIntegerArray);
        int size = pIntegerArray.length;

        while (size > 0) {
            swapArrayElement(pIntegerArray, 0, --size);
            bigHeapify(pIntegerArray, size, 0);
        }
    }

    /**
     * 将数组初始化为大根堆
     *
     * @param pIntegerArray 整型数组
     */
    private static void initBigHeap(Integer[] pIntegerArray) {
        for (int i = 1; i < pIntegerArray.length; i++) {
            int curIndex = i;
            int parentIndex = (curIndex - 1) / 2;

            while (pIntegerArray[curIndex] > pIntegerArray[parentIndex]) {
                swapArrayElement(pIntegerArray, curIndex, parentIndex);
                curIndex = parentIndex;
                parentIndex = (curIndex - 1) / 2;
            }
        }
    }

    /**
     * 将顶点为top，长度为size的数组部分调整为大根堆状态
     *
     * @param pIntegerArray 整型数组
     * @param size          大根堆的元素个数
     * @param top           顶点索引
     */
    private static void bigHeapify(Integer[] pIntegerArray, int size, int top) {
        int leftChildIndex = (top << 1) + 1;
        if (leftChildIndex >= size) {
            return;
        }

        int rightChildIndex = leftChildIndex + 1;

        int largestIndex = rightChildIndex < size && pIntegerArray[rightChildIndex] > pIntegerArray[leftChildIndex]
                ? rightChildIndex : leftChildIndex;

        if (pIntegerArray[top] < pIntegerArray[largestIndex]) {
            swapArrayElement(pIntegerArray, top, largestIndex);
            bigHeapify(pIntegerArray, size, largestIndex);
        }
    }

    /**
     * 快速排序
     * 对元素按照升序进行排序
     *
     * @param pIntegerArray 整型数组
     */
    private static void quickSort(Integer[] pIntegerArray, int left, int right) {
        if (left >= right) {
            return;
        }

        int rand = (int) (Math.random() * (right - left + 1));
        swapArrayElement(pIntegerArray, left + rand, right);
        int num = pIntegerArray[right];

        int i = left - 1;
        int j = right;
        int current = left;

        while (current < j) {
            if (pIntegerArray[current] < num) {
                swapArrayElement(pIntegerArray, current, ++i);
                current++;
            } else if (pIntegerArray[current] == num) {
                current++;
            } else {
                swapArrayElement(pIntegerArray, current, --j);
            }
        }

        swapArrayElement(pIntegerArray, j, right);

        quickSort(pIntegerArray, left, j - 1);
        quickSort(pIntegerArray, j + 1, right);
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
            //insertSort(pIntegerArray);

            //希尔排序
            shellSort(pIntegerArray);

            //归并排序
            //mergeSort(pIntegerArray, 0, pIntegerArray.length - 1);

            //堆排序
            //heapSort(pIntegerArray);

            //快速排序
            //quickSort(pIntegerArray, 0, pIntegerArray.length - 1);

            printArray(pIntegerArray, iSortFlag);
        }
    }
}
