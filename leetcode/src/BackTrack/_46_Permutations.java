package BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by tangjialiang on 2017/5/31.
 *
 */
public class _46_Permutations {

    public static void main(String[] args) {
        int[] nums = {1,2,3} ;
        List<List<Integer>> work = new _46_Permutations().work(nums);
        System.out.println("work: " + work) ;
    }

    public List<List<Integer>> work(int[] nums) {
        return new Solution().permute(nums) ;
    }

    public class Solution {
        ArrayList<List<Integer>> ans = new ArrayList<>() ;

        public List<List<Integer>> permute(int[] nums) {

            ArrayList<Integer> integers = new ArrayList<>();
            for(Integer integer : nums) integers.add(integer) ;

            while(!ans.contains(integers)) {
                ans.add(integers) ;
                integers = (ArrayList<Integer>) nextPermutation(nums);
            }

            return ans ;
        }

        private List<Integer> nextPermutation(int[] integers) {
            int len = integers.length ;

            int pos = len-1 ;
            // find next num bigger than current num => pos
            for(; pos>=0; pos--) {
                if (pos != 0 && integers[pos-1] < integers[pos]) {
                    break ;
                }
            }


            // if pos not 0 then
            //      from pos to len-1 get max set to pos-1(swap), and sort from pos to len-1
            if (pos > 0) {
                // from pos to len-1 find the min num bigger than pos's num.
                int maxVal = integers[pos] ;
                int maxPos = pos ;
                for(int i=pos; i<integers.length; i++) {
                    if (integers[i] > integers[pos-1] && maxVal>integers[i]) {
                        maxVal = integers[i] ;
                        maxPos = i ;
                    }
                }

                integers[maxPos] = integers[pos-1] ;
                integers[pos-1] = maxVal ;

                Arrays.sort(integers, pos, integers.length);
            }
            // else pos equals to 0
            //      just sort all nums
            else {
                Arrays.sort(integers);
            }

            ArrayList<Integer> localInteger = new ArrayList<>();
            for(Integer integer : integers) localInteger.add(integer) ;

            return localInteger ;
        }
    }
}
