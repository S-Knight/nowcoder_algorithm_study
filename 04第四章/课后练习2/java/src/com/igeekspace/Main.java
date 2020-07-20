package com.igeekspace;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{3,2,4};
        int[] twoIndexs = solution.twoSum(nums, 6);

        System.out.println(Arrays.toString(twoIndexs));
    }
}
