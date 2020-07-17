package com.igeekspace;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if (intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }

        if (newInterval.end < intervals.get(0).start) {
            intervals.add(0, newInterval);
            return intervals;
        }

        int insertIndex = -1;
        ArrayList<Interval> removeIntervals = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            if (newInterval.start > intervals.get(i).end
                    && (i + 1 == intervals.size() || newInterval.end < intervals.get(i + 1).start)) {
                intervals.add(i + 1, newInterval);
                return intervals;
            }

            //两个区间有交叉
            if ((newInterval.start >= intervals.get(i).start && newInterval.start <= intervals.get(i).end)
                    || (newInterval.end >= intervals.get(i).start && newInterval.end <= intervals.get(i).end)
                    || (intervals.get(i).start >= newInterval.start && intervals.get(i).start <= newInterval.end)
                    || (intervals.get(i).end >= newInterval.start && intervals.get(i).end <= newInterval.end)) {

                newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
                newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
                removeIntervals.add(intervals.get(i));

                if (insertIndex == -1) {
                    insertIndex = i;
                }
            }

            if (newInterval.end < intervals.get(i).start) {
                break;
            }
        }

        intervals.removeAll(removeIntervals);

        intervals.add(insertIndex, newInterval);

        return intervals;
    }
}
