package com.igeekspace;

import java.util.HashMap;

public class Solution {
    /**
     * @param numbers int整型一维数组
     * @param target  int整型
     * @return int整型一维数组
     */
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            hashMap.put(numbers[i], i + 1);
        }

        for (int i = 0; i < numbers.length; i++) {
            Integer otherIndex = hashMap.get(target - numbers[i]);
            if (otherIndex != null && otherIndex != i+1) {
                return new int[]{i + 1, otherIndex};
            }
        }

        return null;
    }
}