package com.igeekspace;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Interval[] intervals = new Interval[]{
                new Interval(1, 5)
        };

        ArrayList<Interval> arrayIntervals = new ArrayList<>(Arrays.asList(intervals));

        Solution solution = new Solution();
        printIntervals(solution.insert(arrayIntervals, new Interval(2, 3)));
    }

    private static void printIntervals(ArrayList<Interval> arrayIntervals) {
        for (Interval interval: arrayIntervals) {
            System.out.println("s:" + interval.start + ",e:" + interval.end);
        }
    }
}
