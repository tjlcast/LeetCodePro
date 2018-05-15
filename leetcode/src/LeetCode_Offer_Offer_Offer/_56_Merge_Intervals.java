package LeetCode_Offer_Offer_Offer;

import Type.Interval;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/9/8.
 */
public class _56_Merge_Intervals {
    /**
     * Given a collection of intervals, merge all overlapping intervals.

     For example,
     Given [1,3],[2,6],[8,10],[15,18],
     return [1,6],[8,10],[15,18].
     */

    public static void main(String[] args) {
        List<Interval> inter = new LinkedList<>() ;
        inter.add(new Interval(1, 3)) ;
        inter.add(new Interval(2, 6)) ;
        inter.add(new Interval(8, 10)) ;
        inter.add(new Interval(1, 18)) ;

        _56_Merge_Intervals merge_intervals = new _56_Merge_Intervals();
        List<Interval> work = merge_intervals.work(inter);

        System.out.println("work is: ");
        for(Interval i: work) {
            System.out.println(i) ;
        }
    }

    public List<Interval> work(List<Interval> intervals) {
        Solution solution = new Solution();
        List<Interval> merge = solution.merge(intervals);

        return merge ;
    }

    class Solution {

        List<Interval> ansList = new LinkedList<>() ;

        public List<Interval> merge(List<Interval> intervals) {

            if (intervals==null || intervals.size()==0) return ansList ;

            int lastBegin = Integer.MIN_VALUE ;
            int top = Integer.MIN_VALUE ;

            Collections.sort(intervals, new Comparator<Interval>() {
                @Override
                public int compare(Interval o1, Interval o2) {
                    return o1.start - o2.start ;
                }
            });

            for(Interval inter : intervals) {
                if (inter.start > top) {
                    if (lastBegin!=Integer.MIN_VALUE) {
                        // not the prepare step
                        ansList.add(new Interval(lastBegin, top)) ;
                    }
                    lastBegin = inter.start ;
                    top = inter.end ;
                }

                if (inter.start<=top && inter.end > top) {
                    top = inter.end ;
                }
            }

            if (lastBegin!=-1) {
                // not the prepare step
                ansList.add(new Interval(lastBegin, top)) ;
            }

            return ansList ;
        }
    }
}
