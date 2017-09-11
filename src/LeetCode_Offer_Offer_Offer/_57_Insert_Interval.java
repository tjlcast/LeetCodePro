package LeetCode_Offer_Offer_Offer;

import Type.Interval;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/9/8.
 */
public class _57_Insert_Interval {
    /**
     * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

     You may assume that the intervals were initially sorted according to their start times.

     Example 1:
     Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

     Example 2:
     Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

     This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
     */

    public static void main(String[] args) {
        List<Interval> intervals = new LinkedList<>() ;
        intervals.add(new Interval(1, 2)) ;
        intervals.add(new Interval(3, 5)) ;
        intervals.add(new Interval(6, 7)) ;
        intervals.add(new Interval(8, 10)) ;
        intervals.add(new Interval(12, 16)) ;
//        intervals.add(new Interval(8, 10)) ;
//        intervals.add(new Interval(1, 18)) ;

        Interval newInterval = new Interval(4, 9) ;

        _57_Insert_Interval insert_interval = new _57_Insert_Interval();
        List<Interval> work = insert_interval.work(intervals, newInterval);

        System.out.println("work is: ") ;
        for(Interval i : work){
            System.out.println(i) ;
        }

    }

    public List<Interval> work(List<Interval> intervals, Interval newInterval) {
        Solution solution = new Solution();
        List<Interval> insert = solution.insert(intervals, newInterval);

        return insert ;
    }

    class Solution {
        private List<Interval> ansList = new LinkedList<>() ;

        public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
            int l = -1 ;
            int r = -1 ;

            for(Interval inter : intervals) {
                if (inter.end < newInterval.start || inter.start > newInterval.end) {
                    ansList.add(inter) ;
                }

                // newInterval's start in range
                if (newInterval.start<=inter.end && newInterval.start>=inter.start) {
                    l = inter.start ;
                }

                // newInterval's end in range
                if (newInterval.end<=inter.end && newInterval.end>=inter.start) {
                    r = inter.end ;
                }

                // the interval is in the range.
                if (newInterval.start<=inter.start && newInterval.end<=inter.end) continue;
            }

            if (l!=-1) newInterval.start = l ;
            if (r!=-1) newInterval.end = r ;

            ansList.add(newInterval) ;

            Collections.sort(ansList, new Comparator<Interval>() {
                @Override
                public int compare(Interval o1, Interval o2) {
                    return o1.start - o2.start ;
                }
            }) ;

            return ansList ;
        }

    }

}
